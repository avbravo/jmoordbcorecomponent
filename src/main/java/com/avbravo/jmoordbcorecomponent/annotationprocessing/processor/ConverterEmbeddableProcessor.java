/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor;

/**
 *
 * @author avbravo
 */
import com.avbravo.jmoordbcorecomponent.annotationprocessing.ConverterEmbeddable;
import com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.generated.ConverterEmbeddableServicesGenerator;
import com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.generated.ConverterServicesGenerator;
import com.avbravo.jmoordbcorecomponent.domains.IdInformation;
import com.avbravo.jmoordbcorecomponent.domains.ResultGeneration;
import com.avbravo.jmoordbcorecomponent.utils.ProcessorTools;
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
import com.jmoordb.core.annotation.Id;
import java.io.BufferedWriter;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.avbravo.jmoordbcorecomponent.annotationprocessing.ConverterEmbeddable")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class ConverterEmbeddableProcessor extends AbstractProcessor {

    ResultGeneration resultGeneration = new ResultGeneration();
    ConverterEmbeddableServicesGenerator converterEmbeddableServerGenerator = new ConverterEmbeddableServicesGenerator();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        IdInformation idInformation = new IdInformation();
        for (Element element : roundEnv.getElementsAnnotatedWith(ConverterEmbeddable.class)) {

            JavaFileObject builderClass = null;
            PackageElement packageElement = (PackageElement) element.getEnclosingElement();
            BufferedWriter bufferedWriter = null;
            try {
                String builderName = element.getSimpleName().toString() + "Converter";

                String builderGenName = packageElement.getQualifiedName().toString() + "." + builderName;
                /**
                 * Obtener valores de los atributos de la anotacion
                 * ConverterEmbeddable
                 */
                ConverterEmbeddable ce = element.getAnnotation(ConverterEmbeddable.class);

                builderClass = processingEnv.getFiler().createSourceFile(builderGenName);
                bufferedWriter = new BufferedWriter(builderClass.openWriter());
                bufferedWriter.append("package ");
                bufferedWriter.append(packageElement.getQualifiedName().toString());
                bufferedWriter.append(";");
                bufferedWriter = imports(bufferedWriter, packageElement, ce.imports()
                );
                bufferedWriter.newLine();
                bufferedWriter.append("@Named");
                bufferedWriter.newLine();
                bufferedWriter.append("@FacesConverter(forClass =" + element.getSimpleName().toString() + ".class, managed = true)");
                bufferedWriter.newLine();
                bufferedWriter.append("\npublic class ");
                bufferedWriter.append(builderName);
                bufferedWriter.append("  implements Converter<" + element.getSimpleName().toString() + ">");
                bufferedWriter.append("{");

                bufferedWriter = inject(bufferedWriter, element.getSimpleName().toString(), ce.injects());

                bufferedWriter.newLine();

                /**
                 * Imprime los set/get de todos los campos Falta mejorarlo
                 */
//                 bufferedWriter = setGet(bufferedWriter, element,builderName);
                idInformation = analizeColumn(element, ce.column());

                bufferedWriter = getAsObject(bufferedWriter, element.getSimpleName().toString(), idInformation);
                bufferedWriter = getAsString(bufferedWriter, element.getSimpleName().toString(), idInformation
                );

                bufferedWriter.newLine();
                bufferedWriter.append("}");
                bufferedWriter.newLine();
                bufferedWriter.newLine();

                bufferedWriter.close();

                if (!(resultGeneration = converterEmbeddableServerGenerator.generate(element, processingEnv, idInformation)).getSuccessful()) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, resultGeneration.getMessage());
                }
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.toString());
            }
            /**
             * Generar el ConverterServer Se invoca a la clase que lo maneja
             */

        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="BufferedWriter imports(BufferedWriter bufferedWriter,PackageElement packageElement, String[] imports )">
    public BufferedWriter imports(BufferedWriter bufferedWriter, PackageElement packageElement, String[] imports) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.append("import jakarta.inject.Inject;\n");
            bufferedWriter.append("import jakarta.faces.convert.Converter;\n");
            bufferedWriter.append("import jakarta.faces.convert.FacesConverter;\n");
            bufferedWriter.append("import jakarta.inject.Named;\n");
            bufferedWriter.append("import jakarta.faces.component.UIComponent;\n");
            bufferedWriter.append("import jakarta.faces.context.FacesContext;\n");
            bufferedWriter.append("import jakarta.faces.application.FacesMessage;\n");
            bufferedWriter.append("import java.util.Optional;\n");
            bufferedWriter.append("import com.avbravo.jmoordbcorecomponent.utils.FacesUtil;\n");
            bufferedWriter.append("import jakarta.faces.convert.ConverterException;\n");
            bufferedWriter.append("import " + ProcessorTools.removeLastPackage(packageElement.getQualifiedName().toString()) + ".services.*;\n");
            if (imports.length == 0) {

            } else {
                for (int i = 0; i < imports.length; i++) {
                    bufferedWriter.append("import " + imports[i] + ";\n");
                }
            }
        } catch (Exception e) {
       System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BufferedWriter getAsObject(BufferedWriter bufferedWriter,IdInformation idInformation)">

    public BufferedWriter getAsObject(BufferedWriter bufferedWriter, String nameOfClass, IdInformation idInformation) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.append("\t@Override");
            bufferedWriter.newLine();
            bufferedWriter.append("\tpublic " + nameOfClass + " getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {");
            bufferedWriter.newLine();
            bufferedWriter.append("\t\t" + nameOfClass + " obj = new  " + nameOfClass + "();\n");
            bufferedWriter.append("\t\tif (submittedValue == null || submittedValue.isEmpty()) {\n");
            bufferedWriter.append("\t\t    return null;\n");
            bufferedWriter.append("\t\t}\n");
            bufferedWriter.append("\t\ttry{\n");
            if (idInformation.getType().equals("java.lang.Integer")) {
                bufferedWriter.append("\t\tInteger id = Integer.parseInt(submittedValue);\n");
                bufferedWriter.append("\t\tOptional<" + nameOfClass + "> optional = " + ProcessorTools.toLowercaseFirstLetter(nameOfClass) + "ConverterServices.get( id );\n");
                bufferedWriter.append("\t\tif (optional.isPresent()) {;\n");
                bufferedWriter.append("\t\t  obj = optional.get();\n");
                bufferedWriter.append("\t\t }\n");
                bufferedWriter.append("\t\t return obj;\n");
            } else {
                if (idInformation.getType().equals("java.lang.Long")) {
                    bufferedWriter.append("\t\tInteger id0 = Integer.parseInt(submittedValue);\n");
                    bufferedWriter.append("\t\tLong id = id0.longValue();\n");

                    bufferedWriter.append("\t\tOptional<" + nameOfClass + "> optional = " + ProcessorTools.toLowercaseFirstLetter(nameOfClass) + "ConverterServices.get(id);\n");
                    bufferedWriter.append("\t\tif (optional.isPresent()) {;\n");
                    bufferedWriter.append("\t\t  obj = optional.get();\n");
                    bufferedWriter.append("\t\t }\n");
                    bufferedWriter.append("\t\t return obj;\n");
                } else {
                    bufferedWriter.append("\t\tString id = Integer.parseInt(submittedValue);\n");
                    bufferedWriter.append("\t\tOptional<" + nameOfClass + "> optional = " + ProcessorTools.toLowercaseFirstLetter(nameOfClass) + "ConverterServices.get(id);\n");
                    bufferedWriter.append("\t\tif (optional.isPresent()) {\n");
                    bufferedWriter.append("\t\t  obj = optional.get();\n");
                    bufferedWriter.append("\t\t }\n");
                    bufferedWriter.append("\t\t return obj;\n");

                }
            }

            bufferedWriter.append("\t\t } catch (Exception e) {\n");
            bufferedWriter.append("\t\t   System.out.println(FacesUtil.nameOfClassAndMethod() + \" \" + e.getLocalizedMessage());\n");
            bufferedWriter.append("\t\t  throw new ConverterException(new FacesMessage(submittedValue + \" is not a valid selecction from Converter\"), e);\n");
            bufferedWriter.append("\t\t}\n");
            bufferedWriter.newLine();
            bufferedWriter.append("\t}");

        } catch (Exception e) {
          System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BufferedWriter getAsString(BufferedWriter bufferedWriter,IdInformation idInformation)">

    public BufferedWriter getAsString(BufferedWriter bufferedWriter, String nameOfClass, IdInformation idInformation) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.append("\t@Override");
            bufferedWriter.newLine();
            bufferedWriter.append("\tpublic String getAsString(FacesContext fc, UIComponent uic," + nameOfClass + " t) {");
            bufferedWriter.newLine();
            bufferedWriter.append("\t    try {\n");
            bufferedWriter.append("\t    if (t == null) {\n");
            bufferedWriter.append("\t       return \"\";\n");
            bufferedWriter.append("\t     }\n");
            bufferedWriter.append("\t     if (t.get" + idInformation.getName() + "() != null) {\n");
            bufferedWriter.append("\t         return t.get" + idInformation.getName() + "().toString();\n");
            bufferedWriter.append("\t     }\n");
            bufferedWriter.append("\t    } catch (Exception e) {\n");
            bufferedWriter.append("\t       new FacesMessage(\"Error en converter  \" + e.getLocalizedMessage());\n");
            bufferedWriter.append("\t    }\n");
            bufferedWriter.append("\t    return \"\";\n");
            bufferedWriter.append("\t}");

        } catch (Exception e) {
           System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BufferedWriter inject(BufferedWriter bufferedWriter, String[] injects)">
    public BufferedWriter inject(BufferedWriter bufferedWriter, String nameOfClass, String[] injects) {
        try {
            bufferedWriter.newLine();
             bufferedWriter.newLine();
            bufferedWriter.append("\t@Inject\n");
            bufferedWriter.newLine();
            bufferedWriter.append("\t " + nameOfClass + "ConverterServices " + ProcessorTools.toLowercaseFirstLetter(nameOfClass) + "ConverterServices;\n");

            if (injects.length == 0) {

            } else {
                for (int i = 0; i < injects.length; i++) {
                    bufferedWriter.append("\t@Inject");
                    bufferedWriter.newLine();
                    bufferedWriter.append("\t " + injects[i] + " " + ProcessorTools.toLowercaseFirstLetter(injects[i]) + ";\n");
                }
            }
        } catch (Exception e) {
          System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BufferedWriter setGet(BufferedWriter bufferedWriter, Element element,String builderName)">
    public BufferedWriter setGet(BufferedWriter bufferedWriter, Element element, String builderName) {
        try {
            /**
             * Imprime los set/get de todos los campos
             */
            if (element.getKind().isClass()) {
                for (Element enclosed : element.getEnclosedElements()) {
                    if (enclosed.getKind().isField() & (enclosed.getModifiers().contains(Modifier.PRIVATE)
                            | enclosed.getModifiers().contains(Modifier.PROTECTED))) {
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
        } catch (Exception e) {
         System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="IdInformation analizeId()">
    /**
     * Encuentra la información de la llave primaria
     *
     * @return
     */
    public IdInformation analizeId(Element element) {
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
    // <editor-fold defaultstate="collapsed" desc="IdInformation analizeColumn(Element element, String column)">
    /**
     * Encuentra la información de la llave primaria
     *
     * @return
     */
    public IdInformation analizeColumn(Element element, String column) {
        IdInformation idInformation = new IdInformation();
        try {
            String name = "";
            String type = "";
            String simpleName = "";
            if (element.getKind().isClass()) {
                for (Element enclosed : element.getEnclosedElements()) {
                    if (enclosed.getKind().isField() & (enclosed.getModifiers().contains(Modifier.PRIVATE)
                            | enclosed.getModifiers().contains(Modifier.PROTECTED))) {

                        if (enclosed.getSimpleName().toString().equals(column.trim())) {
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
}
