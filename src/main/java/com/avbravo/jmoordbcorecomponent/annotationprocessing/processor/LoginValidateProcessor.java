/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor;

/**
 *
 * @author avbravo
 */
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
import com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.services.LoginValidateProcessorServices;
import com.avbravo.jmoordbcorecomponent.annotationprocessing.LoginSecurity;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.avbravo.jmoordbcorecomponent.annotationprocessing.LoginValidate")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class LoginValidateProcessor extends AbstractProcessor {

    LoginValidateProcessorServices loginValidateProcessorServices = new LoginValidateProcessorServices();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for (Element element : roundEnv.getElementsAnnotatedWith(LoginSecurity.class)) {
            JavaFileObject builderClass = null;
            PackageElement packageElement = (PackageElement) element.getEnclosingElement();
            BufferedWriter bufferedWriter = null;
            try {
//                String builderName = element.getSimpleName().toString() + "Faces";
                String builderName = "LoginValidateServices";

                String builderGenName = packageElement.getQualifiedName().toString() + "." + builderName;

//                builderClass = processingEnv.getFiler().createSourceFile(builderName);
                builderClass = processingEnv.getFiler().createSourceFile(builderGenName);
                bufferedWriter = new BufferedWriter(builderClass.openWriter());
                bufferedWriter.append("package ");
                bufferedWriter.append(packageElement.getQualifiedName().toString());
                bufferedWriter.append(";");
                bufferedWriter.newLine();
                bufferedWriter.append("\n" + loginValidateProcessorServices.imports(packageElement.getQualifiedName().toString()));
                bufferedWriter.newLine();
                bufferedWriter.append("\npublic interface ");
                bufferedWriter.append(builderName);
                bufferedWriter.append(" {");
                bufferedWriter.newLine();
                bufferedWriter.append(loginValidateProcessorServices.methods());
                bufferedWriter.newLine();

                bufferedWriter.append(loginValidateProcessorServices.validateProfileUser());
                bufferedWriter.append(loginValidateProcessorServices.validateRoles());

                bufferedWriter.newLine();

                bufferedWriter.append("}");
                bufferedWriter.close();
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.toString());
            }

        }
        return false;
    }

}
