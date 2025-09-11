/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.builder;

/**
 *
 * @author avbravo
 */
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.google.auto.service.AutoService;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ExecutableType;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.jmoordb.core.annotation.builder.OldCoreBuilderProperty")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class CoreBuilderPropertyProcessorCodeOld extends AbstractProcessor{

       private final MustacheFactory mf = new DefaultMustacheFactory();
    private final Mustache mustache = mf.compile("coresetterbuilder-template.mustache");
    
    /**
     * Procesar los metodos set que tengan la anotación
     * @param annotations
     * @param roundEnv
     * @return 
     */
   @Override
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

            Map<String, String> setterMap = setters.stream().collect(Collectors.toMap(setter -> setter.getSimpleName().toString(), setter -> ((ExecutableType) setter.asType()).getParameterTypes().get(0).toString()));

            try {
                writeBuilderFile(className, setterMap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return true;
    }

    private void writeBuilderFile(String className, Map<String, String> setterMap) throws IOException {

        String packageName = null;
        int lastDot = className.lastIndexOf('.');
        if (lastDot > 0) {
            packageName = className.substring(0, lastDot);
        }

        String simpleClassName = className.substring(lastDot + 1);
        String builderClassName = className + "Builder";
        String builderSimpleClassName = builderClassName.substring(lastDot + 1);
        JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(builderClassName);
        try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {

            if (packageName != null) {
                out.print("package ");
                out.print(packageName);
                out.println(";");
                out.println();
            }

            out.print("public class ");
            out.print(builderSimpleClassName);
            out.println(" {");
            out.println();

            out.print("    private ");
            out.print(simpleClassName);
            out.print(" object = new ");
            out.print(simpleClassName);
            out.println("();");
            out.println();

            out.print("    public ");
            out.print(simpleClassName);
            out.println(" build() {");
            out.println("        return object;");
            out.println("    }");
            out.println();

            setterMap.entrySet().forEach(setter -> {
                String methodName = setter.getKey();
                String argumentType = setter.getValue();

                out.print("    public ");
                out.print(builderSimpleClassName);
                out.print(" ");
                out.print(methodName);

                out.print("(");

                out.print(argumentType);
                out.println(" value) {");
                out.print("        object.");
                out.print(methodName);
                out.println("(value);");
                out.println("        return this;");
                out.println("    }");
                out.println();
            });

            out.println("}");

        }
    }
    
            

}
