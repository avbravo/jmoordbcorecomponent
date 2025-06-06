/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor;

/**
 *
 * @author avbravo
 */
import com.avbravo.jmoordbcorecomponent.annotationprocessing.HtmlBuilder;
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
import java.io.BufferedWriter;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.avbravo.jmoordbcorecomponent.annotationprocessing.HtmlBuilder")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class HtmlBuilderProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("----------------------------------------------------------");
      //  System.out.println(">>>>>>>>>>>[projectBuildDir] "+projectBuildDir);
        System.out.println("----------------------------------------------------------");
        for (Element element : roundEnv.getElementsAnnotatedWith(HtmlBuilder.class)) {
            JavaFileObject builderClass = null;
            PackageElement packageElement = (PackageElement) element.getEnclosingElement();
            BufferedWriter bufferedWriter = null;
            try {
                String builderName = element.getSimpleName().toString() + "Html";

                String builderGenName = packageElement.getQualifiedName().toString() + "." + builderName;
                System.out.println("--> packageElement.getQualifiedName().toString(): "+packageElement.getQualifiedName().toString());
                System.out.println("--> builderName: "+builderName);
                System.out.println("--> builderGenName: "+builderGenName);

                builderClass = processingEnv.getFiler().createSourceFile(builderGenName);
                bufferedWriter = new BufferedWriter(builderClass.openWriter());
       //         bufferedWriter.append("<html>");
                bufferedWriter.append("package ");
                bufferedWriter.append(packageElement.getQualifiedName().toString());
                bufferedWriter.append(";");
                bufferedWriter.newLine();
                bufferedWriter.append("\npublic class ");
                bufferedWriter.append(builderName);
                bufferedWriter.append("{");
                bufferedWriter.newLine();

                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.append("\n\tprivate ");
                bufferedWriter.append(element.getSimpleName().toString());
                bufferedWriter.append(" object ");
                bufferedWriter.append(" = new " + element.getSimpleName().toString() + "();");

                bufferedWriter.newLine();

                if (element.getKind().isClass()) {
                    for (Element enclosed : element.getEnclosedElements()) {
                        if (enclosed.getKind().isField() & (enclosed.getModifiers().contains(Modifier.PUBLIC)
                                | enclosed.getModifiers().contains(Modifier.PROTECTED))) {
                            bufferedWriter.newLine();
                            bufferedWriter.newLine();
                            bufferedWriter.append("\tpublic ");
                            bufferedWriter.append(builderName);
                            bufferedWriter.append(" set");
                            String field = enclosed.getSimpleName().toString();
                            String s1 = field.substring(0, 1).toUpperCase();
                            String nameCapitalized = s1 + field.substring(1);
                            bufferedWriter.append(nameCapitalized);
                            bufferedWriter.append("(");
                            bufferedWriter.append(enclosed.asType().toString());
                            bufferedWriter.append(" param){");
                            bufferedWriter.newLine();
                            bufferedWriter.append("\tthis.object.");
                            bufferedWriter.append(enclosed.getSimpleName().toString());
                            bufferedWriter.append(" = ");
                            bufferedWriter.append("param;");
                            bufferedWriter.newLine();
                            bufferedWriter.append("\treturn this;\n\t}");
                        }
                    }
                }
                bufferedWriter.newLine();
                bufferedWriter.append("\tpublic ");
                bufferedWriter.append(element.getSimpleName());
                bufferedWriter.append(" build(){");
                bufferedWriter.newLine();
                bufferedWriter.append("\treturn this.object;\n\t}");
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.append("}");
           //     bufferedWriter.append("</html>");
                bufferedWriter.close();
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.toString());
            }

        }
        return false;
    }
}
