/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.utils;

import com.jmoordb.core.util.MessagesUtil;
import java.util.function.Supplier;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;

/**
 *
 * @author avbravo
 */
public class ProcessorTools {

    public static String toLowercaseFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Handle null or empty strings
        }
        // Convert the first character to lowercase and concatenate with the rest of the string
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    // <editor-fold defaultstate="collapsed" desc="String packageOfTypeMirror(TypeMirror typeMirror)">
    /**
     *
     * @param typeMirror
     * @return En package de un entity con el formato com.mypackage.
     */
    public static String packageOfTypeMirror(TypeMirror typeMirror) {
        String packageOfEntity = "";
        try {
            String nameOfEntity = nameOfFileInPath(typeMirror.toString());
            packageOfEntity = typeMirror.toString().replace(nameOfEntity, "");
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return packageOfEntity;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String nameOfFileInPath(String filenamePath)">
    /**
     *
     * @param filenamePath
     * @return el nombre del archivo que esta en un path
     */
    public static String nameOfFileInPath(String filenamePath) {
        String name = "";
        try {
            name = filenamePath.substring(filenamePath.lastIndexOf('.') + 1, filenamePath.length());
        } catch (Exception e) {
            System.out.println(nameOfMethod() + " " + e.getLocalizedMessage());
        }
        return name;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="nameOfClassAndMethod()">
    public static String nameOfClassAndMethod() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length()) + "." + e.getMethodName();
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="nameOfClass()">

    public static String nameOfClass() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length());
    }    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="nameOfMethod(">
    public static String nameOfMethod() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return e.getMethodName();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String removeLastPackage(String packagePath)">
    public static String removeLastPackage(String packagePath) {
        String result = "";
        try {

            result = packagePath.substring(0, packagePath.lastIndexOf("."));
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String nameOfMethod(ExecutableElement executableElement)">
    public static String nameOfMethod(ExecutableElement executableElement) {
        String name = "";
        try {
            name = executableElement.getSimpleName().toString();
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return name;
    }
// </editor-fold>

    public static TypeMirror mirror(Supplier<Class<?>> classValue) {
        try {
            var ignored = classValue.get();
            throw new IllegalStateException("Expected a MirroredTypeException to be thrown but got " + ignored);
        } catch (MirroredTypeException e) {
            return e.getTypeMirror();
        }
    }
}
