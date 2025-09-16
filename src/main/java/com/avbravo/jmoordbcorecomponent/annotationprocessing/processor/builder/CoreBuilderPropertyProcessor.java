/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.builder;

/**
 *
 * @author avbravo
 */
import com.avbravo.jmoordbcorecomponent.utils.ProcessorTools;
import static com.avbravo.jmoordbcorecomponent.utils.ProcessorTools.capitalize;
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
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import javax.lang.model.type.ExecutableType;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.jmoordb.core.annotation.builder.CoreBuilderProperty")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class CoreBuilderPropertyProcessor extends AbstractProcessor {

    private final MustacheFactory mf = new DefaultMustacheFactory();
    private final Mustache mustache = mf.compile("corebuilderproperty-template.mustache");

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {

            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);

            Map<Boolean, List<Element>> annotatedMethods = annotatedElements.stream().collect(Collectors.partitioningBy(element -> ((ExecutableType) element.asType()).getParameterTypes().size() == 1 && element.getSimpleName().toString().startsWith("set")));

            List<Element> setters = annotatedMethods.get(true);
            List<Element> otherMethods = annotatedMethods.get(false);

            otherMethods.forEach(element -> processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "@CoreSetterBuilderProperty must be applied to a setXxx method with a single argument", element));

            if (setters.isEmpty()) {
                continue;
            }

            String className = ((TypeElement) setters.get(0).getEnclosingElement()).getQualifiedName().toString();
            String packageName = processingEnv.getElementUtils().getPackageOf(((TypeElement) setters.get(0).getEnclosingElement())).getQualifiedName().toString();
            Map<String, String> setterMap = setters.stream().collect(Collectors.toMap(setter -> setter.getSimpleName().toString(), setter -> ((ExecutableType) setter.asType()).getParameterTypes().get(0).toString()));

            try {
                
                writeBuilderFile(className, packageName, setterMap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return true;
    }

   
    private void writeBuilderFile(String className, String packageName, Map<String, String> setterMap) throws IOException {

        int lastDot = className.lastIndexOf('.');
        if (lastDot > 0) {
            packageName = className.substring(0, lastDot);
        }

        String simpleClassName = className.substring(lastDot + 1);
        //    String builderClassName = className + "Builder";
//        String builderSimpleClassName = builderClassName.substring(lastDot + 1);

        List<Map<String, String>> metodos = new ArrayList<>();

        setterMap.entrySet().forEach(setter -> {
            String methodName = setter.getKey();
            String argumentType = setter.getValue();
            Map<String, String> fieldMethod = new HashMap<>();
            fieldMethod.put("methodName", methodName);
            fieldMethod.put("argumentType", argumentType);
            fieldMethod.put("capitalizename", ProcessorTools.capitalize(methodName));
            fieldMethod.put("setterName", "with" + ProcessorTools.capitalize(methodName));
            metodos.add(fieldMethod);
        });

        // Create a data map for Mustache
        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("className", simpleClassName);
        data.put("builderClassName", simpleClassName + "Builder");
//        data.put("className", className);
//        data.put("builderClassName", className + "Builder");
//        data.put("methods", setterMap);
        data.put("methods", metodos);

        // Generate the new source file
        

        
        JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(packageName + "." + simpleClassName + "Builder");
        try (Writer writer = builderFile.openWriter()) {
            mustache.execute(writer, data).flush();
        }

    }

   
   
    
}
