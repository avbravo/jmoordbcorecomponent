/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.utils;

import com.avbravo.jmoordbcore.domains.DataID;
import com.avbravo.jmoordbcore.domains.IdInformation;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.util.MessagesUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
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

    // <editor-fold defaultstate="collapsed" desc="Boolean isRecord(TypeElement classElement)">
    /**
     * Determina si es una clase o un Java Record
     *
     * @param classElement
     * @return
     */
    public static Boolean isRecord(TypeElement classElement, TypeElement superclassElement) {
        Boolean result = Boolean.FALSE;
        try {
            TypeMirror superclassMirror = classElement.getSuperclass();

            // Verificamos si la superclase existe y no es java.lang.Object
            if (superclassMirror != null && !superclassMirror.toString().equals("java.lang.Object")) {
                //TypeElement superclassElement = (TypeElement) ((javax.lang.model.util.Types) processingEnv.getTypeUtils()).asElement(superclassMirror);

                if (superclassElement != null && superclassElement.getQualifiedName().contentEquals("java.lang.Record")) {
                    result = Boolean.TRUE;
//                            System.out.println("Es un Java Record: " + classElement.getQualifiedName());
                } else {
//                            System.out.println("Es una clase normal: " + classElement.getQualifiedName());
                }
            } else {
//                        System.out.println("Es una clase normal: " + classElement.getQualifiedName());
            }
        } catch (Exception e) {
            throw new IllegalStateException("isRecord() " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String capitalize(String str) ">
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String lowercaseInitial(String str) ">
    public static String lowercaseInitial(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Map<String, String>> fields(TypeElement classElement)">
    /**
     * *
     * Devuelve los campos y el separador "," o " " .
     *
     * @param classElement
     * @return
     */
    public static List<Map<String, String>> fields(TypeElement classElement) {
        List<Map<String, String>> result = new ArrayList<>();

        try {

            List<VariableElement> filteredElements = classElement.getEnclosedElements().stream()
                    .filter(e -> e.getKind().isField())
                    .map(e -> (VariableElement) e)
                    .collect(Collectors.toList());

// 2. Procesa la lista con índices para agregar el atributo "isLast"
            result = IntStream.range(0, filteredElements.size())
                    .mapToObj(i -> {
                        VariableElement field = filteredElements.get(i);
                        Map<String, String> fieldData = new HashMap<>();
                        String type = field.asType().toString();
                        fieldData.put("type", field.asType().toString());
                        var fieldName = field.getSimpleName().toString();
                        fieldData.put("name", fieldName);
                        fieldName = !fieldName.substring(0,1).equals("_") ? fieldName : fieldName.substring(1, fieldName.length());
                        fieldData.put("capitalizeName", capitalize(fieldName));
                        fieldData.put("lowercaseInitialName", lowercaseInitial(fieldName));
                        fieldData.put("lista", "java.util.List<Persona>");
                        // Añade el atributo booleano "isLast"
                        boolean isLast = i == filteredElements.size() - 1;
                        fieldData.put("separator", isLast ? "" : ",");
                        return fieldData;
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="IdInformation analizeId()">
    /**
     * Encuentra la información de la llave primaria
     *
     * @return
     */
    public static IdInformation analizeId(Element element) {
        IdInformation idInformation = new IdInformation();
        try {
            String name = "";
            String type = "";
            String simpleName = "";
            if (element.getKind().isClass()) {
                for (Element enclosed : element.getEnclosedElements()) {
                    if (enclosed.getKind().isField() & (enclosed.getModifiers().contains(Modifier.PRIVATE)
                            | enclosed.getModifiers().contains(Modifier.PROTECTED))) {

                        Id id = enclosed.getAnnotation(Id.class);
                        if (id != null) {
                            String field = enclosed.getSimpleName().toString();
                            String s1 = field.substring(0, 1).toUpperCase();
                            String nameCapitalized = s1 + field.substring(1);

                            name = nameCapitalized;
                            type = enclosed.asType().toString();
                            simpleName = enclosed.getSimpleName().toString();
                            break;
                        }
                    }
                }
            }
            idInformation = new IdInformation.Builder()
                    .name(name)
                    .type(type)
                    .simpleName(simpleName)
                    .build();

        } catch (Exception e) {
            System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return idInformation;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="DataID getDataID(Element element)">
    /**
     * Encuentra la información de la llave primaria
     *
     * @return
     */
    public static DataID getDataID(Element element) {

        try {
            String name = "";
            String type = "";
            String simpleName = "";
            if (element.getKind().isClass()) {
                for (Element enclosed : element.getEnclosedElements()) {
                    if (enclosed.getKind().isField() & (enclosed.getModifiers().contains(Modifier.PRIVATE)
                            | enclosed.getModifiers().contains(Modifier.PROTECTED))) {

                        Id id = enclosed.getAnnotation(Id.class);
                        if (id != null) {
                            String field = enclosed.getSimpleName().toString();
                            String s1 = field.substring(0, 1).toUpperCase();
                            String nameCapitalized = s1 + field.substring(1);

                            name = nameCapitalized;
                            type = enclosed.asType().toString();
                            simpleName = enclosed.getSimpleName().toString();
                            break;
                        }
                    }
                }
            }

            return new DataID(name, type, simpleName);

        } catch (Exception e) {
            System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return new DataID("", "", "");
    }
    // </editor-fold>
}
