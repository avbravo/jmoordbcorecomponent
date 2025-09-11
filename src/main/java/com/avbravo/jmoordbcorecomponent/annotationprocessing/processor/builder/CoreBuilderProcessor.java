/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.builder;

/**
 *
 * @author avbravo
 */
import com.avbravo.jmoordbcorecomponent.domains.IdInformation;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.lang.model.element.VariableElement;
import javax.tools.JavaFileObject;
import com.jmoordb.core.annotation.builder.CoreBuilder;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.jmoordb.core.annotation.builder.CoreBuilder")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class CoreBuilderProcessor extends AbstractProcessor {

    private final MustacheFactory mf = new DefaultMustacheFactory();
    private final Mustache mustache = mf.compile("corebuilder-template.mustache");

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        IdInformation idInformation = new IdInformation();
        for (Element element : roundEnv.getElementsAnnotatedWith(CoreBuilder.class)) {
            if (element instanceof TypeElement) {
                TypeElement classElement = (TypeElement) element;
                try {
                    generateBuilder(classElement);
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

    private void generateBuilder(TypeElement classElement) throws IOException {
        String className = classElement.getSimpleName().toString();
        String packageName = processingEnv.getElementUtils().getPackageOf(classElement).getQualifiedName().toString();

        // Collect fields to pass to the Mustache template
        List<Map<String, String>> fields = classElement.getEnclosedElements().stream()
                .filter(e -> e.getKind().isField())
                .map(e -> (VariableElement) e)
                .map(field -> {
                    Map<String, String> fieldData = new HashMap<>();
                    fieldData.put("type", field.asType().toString());
                    fieldData.put("name", field.getSimpleName().toString());
                    fieldData.put("capitalizename", capitalize(field.getSimpleName().toString()));
                    fieldData.put("setterName", "with" + capitalize(field.getSimpleName().toString()));
                    return fieldData;
                })
                .collect(Collectors.toList());

        // Create a data map for Mustache
        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("className", className);
        data.put("builderClassName", className + "Builder");
        data.put("fields", fields);

        // Generate the new source file
        JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(packageName + "." + className + "Builder");
        try (Writer writer = builderFile.openWriter()) {
            mustache.execute(writer, data).flush();
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
