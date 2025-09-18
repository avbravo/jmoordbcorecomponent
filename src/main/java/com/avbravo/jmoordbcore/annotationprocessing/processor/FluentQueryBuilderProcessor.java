/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcore.annotationprocessing.processor;

/**
 *
 * @author avbravo
 */
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
import com.avbravo.jmoordbcore.annotationprocessing.EntityRepository;
import com.jmoordb.core.annotation.FluentQuery;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.jmoordb.core.annotation.FluentQuery")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class FluentQueryBuilderProcessor extends AbstractProcessor {

    private final MustacheFactory mf = new DefaultMustacheFactory();
    private final Mustache mustache = mf.compile("fluentquery-template.mustache");

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        IdInformation idInformation = new IdInformation();
        for (Element element : roundEnv.getElementsAnnotatedWith(FluentQuery.class)) {
            if (element instanceof TypeElement) {
                TypeElement classElement = (TypeElement) element;
                try {
                    generateRepository(classElement);
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

    private void generateRepository(TypeElement classElement) throws IOException {
        String entityClassName = classElement.getSimpleName().toString();
        String packageName = processingEnv.getElementUtils().getPackageOf(classElement).getQualifiedName().toString();
        String repositoryClassName = entityClassName + "Repository";

        // Obtener el tipo de la clave primaria (asumimos que hay un método getId())
        // En un caso real, esto sería más complejo, por ejemplo, buscando una anotación @Id
        String idType = "Long";

        // Datos para la plantilla de Mustache
        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("repositoryClassName", repositoryClassName);
        data.put("entityClassName", entityClassName);
        data.put("idType", idType);

        // Generar el nuevo archivo de código fuente
        JavaFileObject repositoryFile = processingEnv.getFiler().createSourceFile(packageName + "." + repositoryClassName);
        try (Writer writer = repositoryFile.openWriter()) {
            mustache.execute(writer, data).flush();
        }
    }
}
