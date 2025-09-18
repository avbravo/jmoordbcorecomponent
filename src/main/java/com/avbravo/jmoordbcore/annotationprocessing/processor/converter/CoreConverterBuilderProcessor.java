/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcore.annotationprocessing.processor.converter;

/**
 *
 * @author avbravo
 */
import com.avbravo.jmoordbcore.domains.DataID;
import com.avbravo.jmoordbcore.domains.IdInformation;
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
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.tools.JavaFileObject;
import com.avbravo.jmoordbcorecomponent.utils.ProcessorTools;
import com.jmoordb.core.annotation.faces.CoreConverter;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.jmoordb.core.annotation.faces.CoreConverter")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class CoreConverterBuilderProcessor extends AbstractProcessor {

    private final MustacheFactory mf = new DefaultMustacheFactory();
    private final Mustache mustache = mf.compile("coreconverter-template.mustache");

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        System.out.println("..........................................................");
        System.out.println("............................... iniciando JMDCCONVERTER");
        for (Element element : roundEnv.getElementsAnnotatedWith(CoreConverter.class)) {
            if (element instanceof TypeElement) {
                TypeElement classElement = (TypeElement) element;
                try {
                    DataID dataID = ProcessorTools.getDataID(element);
                    generateConverter(classElement,dataID);
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

    private void generateConverter(TypeElement classElement, DataID dataID) throws IOException {
        String entityClassName = classElement.getSimpleName().toString();
        String packageName = processingEnv.getElementUtils().getPackageOf(classElement).getQualifiedName().toString();
        String repositoryClassName = entityClassName + "Converter";

        // Obtener el tipo de la clave primaria (asumimos que hay un método getId())
        // En un caso real, esto sería más complejo, por ejemplo, buscando una anotación @Id

        // Datos para la plantilla de Mustache
        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("repositoryClassName", repositoryClassName);
        data.put("entityClassName", entityClassName);
        data.put("entityClassNameVar", ProcessorTools.toLowercaseFirstLetter(entityClassName));
        data.put("idType", dataID.type());
        data.put("idName", dataID.name());
        data.put("idSimpleName", dataID.simpleName());

        // Generar el nuevo archivo de código fuente
        JavaFileObject repositoryFile = processingEnv.getFiler().createSourceFile(packageName + "." + repositoryClassName);
        try (Writer writer = repositoryFile.openWriter()) {
            mustache.execute(writer, data).flush();
        }
    }
}
