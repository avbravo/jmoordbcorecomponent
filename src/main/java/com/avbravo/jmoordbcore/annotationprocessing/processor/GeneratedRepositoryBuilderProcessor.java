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
import com.avbravo.jmoordbcore.annotationprocessing.GeneratedRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeMirror;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.avbravo.jmoordbcorecomponent.annotationprocessing.GeneratedRepository")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class GeneratedRepositoryBuilderProcessor extends AbstractProcessor {

    private final MustacheFactory mf = new DefaultMustacheFactory();
    private final Mustache mustache = mf.compile("generatedrepository-template.mustache");

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        IdInformation idInformation = new IdInformation();
        for (Element element : roundEnv.getElementsAnnotatedWith(GeneratedRepository.class)) {
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

    private void generateRepository(TypeElement interfaceElement) throws IOException {
        // Obtener la entidad de la anotación
        TypeMirror entityType = interfaceElement.getAnnotationMirrors().stream()
                .filter(am -> am.getAnnotationType().toString().equals(GeneratedRepository.class.getName()))
                .flatMap(am -> am.getElementValues().entrySet().stream())
                .filter(entry -> entry.getKey().getSimpleName().toString().equals("entity"))
                .map(entry -> ((javax.lang.model.type.DeclaredType) entry.getValue().getValue()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Entity not found in annotation"));

        String entityClassName = ((TypeElement) processingEnv.getTypeUtils().asElement(entityType)).getSimpleName().toString();
        String packageName = processingEnv.getElementUtils().getPackageOf(interfaceElement).getQualifiedName().toString();
        String repositoryInterfaceName = interfaceElement.getSimpleName().toString();
        String repositoryClassName = repositoryInterfaceName.replace("Interface", ""); // O alguna otra convención
        repositoryClassName += "Impl";

        // Obtener los métodos de la interfaz
        List<Map<String, String>> customMethods = interfaceElement.getEnclosedElements().stream()
                .filter(e -> e.getKind() == ElementKind.METHOD)
                .map(e -> (ExecutableElement) e)
                .map(method -> {
                    Map<String, String> methodData = new HashMap<>();
                    methodData.put("name", method.getSimpleName().toString());
                    methodData.put("returnType", method.getReturnType().toString());
                    String params = method.getParameters().stream()
                            .map(p -> p.asType().toString() + " " + p.getSimpleName().toString())
                            .collect(Collectors.joining(", "));
                    methodData.put("parameters", params);
                    methodData.put("body", generateMethodBody(method));
                    return methodData;
                })
                .collect(Collectors.toList());

        // Datos para la plantilla
        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("repositoryInterfaceName", repositoryInterfaceName);
        data.put("repositoryClassName", repositoryClassName);
        data.put("entityClassName", entityClassName);
        data.put("customMethods", customMethods);

        // Generar el archivo de código
        JavaFileObject repositoryFile = processingEnv.getFiler().createSourceFile(packageName + "." + repositoryClassName);
        try (Writer writer = repositoryFile.openWriter()) {
            mustache.execute(writer, data).flush();
        }
    }

    /**
     * Genera el cuerpo del método basándose en su nombre. Esta lógica podría
     * ser más compleja, usando regex o un mapeo.
     */
    private String generateMethodBody(ExecutableElement method) {
        String methodName = method.getSimpleName().toString();
        String returnType = method.getReturnType().toString();

        switch (methodName) {
            case "findAll":
                return "return new ArrayList<>(entities);";
            case "count":
                return "return (long) entities.size();";
            case "deleteById":
                return "return repo.deleteBy();";
            default:
                return "throw new UnsupportedOperationException(\"Method '" + methodName + "' not yet implemented.\");";
        }
    }
}
