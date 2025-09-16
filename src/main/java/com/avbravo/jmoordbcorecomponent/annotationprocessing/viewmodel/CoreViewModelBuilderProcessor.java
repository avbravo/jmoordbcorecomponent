/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.viewmodel;

/**
 *
 * @author avbravo
 */
import com.avbravo.jmoordbcorecomponent.domains.IdInformation;
import com.avbravo.jmoordbcorecomponent.utils.ProcessorTools;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.IOException;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.google.auto.service.AutoService;
import com.jmoordb.core.annotation.ViewModel;
import com.jmoordb.core.annotation.builder.CoreViewModelBuilder;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.jmoordb.core.annotation.builder.CoreViewModelBuilder")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class CoreViewModelBuilderProcessor extends AbstractProcessor {

    private final MustacheFactory mf = new DefaultMustacheFactory();
    private final Mustache mustacheRecord = mf.compile("coreviewmodelbuilderrecord-template.mustache");

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        IdInformation idInformation = new IdInformation();
        for (Element element : roundEnv.getElementsAnnotatedWith(CoreViewModelBuilder.class)) {
            if (element instanceof TypeElement) {
                TypeElement classElement = (TypeElement) element;
                try {
                    // Verifica si es una clase Java o un Java Records
                    if (ProcessorTools.isRecord(classElement, (TypeElement) ((javax.lang.model.util.Types) processingEnv.getTypeUtils()).asElement(classElement.getSuperclass()))) {
                        generateBuilderRecord(classElement);
                    } else {
                       processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "@CoreViewModelBuilder must be applied to a Java Records.");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /**
             * Generar el ConverterServer Se invoca a la clase que lo maneja
             */
        }
        return false;
    }


// <editor-fold defaultstate="collapsed" desc="void generateBuilderRecord(TypeElement classElement)">
    private void generateBuilderRecord(TypeElement classElement) throws IOException {
        String className = classElement.getSimpleName().toString();
        String packageName = processingEnv.getElementUtils().getPackageOf(classElement).getQualifiedName().toString();

        List<Map<String, String>> fields = ProcessorTools.fields(classElement);

        // Create a data map for Mustache
        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("className", className);
        data.put("capitalizeClassName", ProcessorTools.capitalize(className));
        data.put("lowercaseInitialClassName", ProcessorTools.lowercaseInitial(className));
        data.put("builderClassName", className + "ViewModelBuilder");
        data.put("fields", fields);

        // Generate the new source file
        JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(packageName + "." + className + "ViewModelBuilder");
        try (Writer writer = builderFile.openWriter()) {
            mustacheRecord.execute(writer, data).flush();
       
        }
    }

    // </editor-fold>
}
