/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.login;

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
import javax.lang.model.element.PackageElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.services.login.LoginSecurityIdentityProcessorServices;
import com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.services.login.LoginValidateProcessorServices;
import com.avbravo.jmoordbcorecomponent.annotationprocessing.LoginSecurity;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.avbravo.jmoordbcorecomponent.annotationprocessing.LoginSecurityIdentity")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class LoginSecurityIdentityProcessor extends AbstractProcessor {

    LoginSecurityIdentityProcessorServices loginSecurityIdentityProcessorServices = new LoginSecurityIdentityProcessorServices();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for (Element element : roundEnv.getElementsAnnotatedWith(LoginSecurity.class)) {
            JavaFileObject builderClass = null;
            PackageElement packageElement = (PackageElement) element.getEnclosingElement();
            BufferedWriter bufferedWriter = null;
            try {
//                String builderName = element.getSimpleName().toString() + "Faces";
                String builderName = "SecurityIdentityStore";

                String builderGenName = packageElement.getQualifiedName().toString() + "." + builderName;

//                builderClass = processingEnv.getFiler().createSourceFile(builderName);
                builderClass = processingEnv.getFiler().createSourceFile(builderGenName);
                bufferedWriter = new BufferedWriter(builderClass.openWriter());
                bufferedWriter.append("package ");
                bufferedWriter.append(packageElement.getQualifiedName().toString());
                bufferedWriter.append(";");
                bufferedWriter.newLine();
                bufferedWriter.append("\n" + loginSecurityIdentityProcessorServices.imports(packageElement.getQualifiedName().toString()));
                bufferedWriter.newLine();
                bufferedWriter.append(loginSecurityIdentityProcessorServices.header());

                bufferedWriter.append("\npublic class ");
                bufferedWriter.append(builderName);
                bufferedWriter.append(" implements IdentityStore {");
                bufferedWriter.newLine();

                bufferedWriter.newLine();

                bufferedWriter.append(loginSecurityIdentityProcessorServices.inject());
                bufferedWriter.append(loginSecurityIdentityProcessorServices.constructor(builderName));
                bufferedWriter.append(loginSecurityIdentityProcessorServices.validate());
                bufferedWriter.append(loginSecurityIdentityProcessorServices.isValidData());

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
