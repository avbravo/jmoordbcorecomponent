/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.generated;

import com.avbravo.jmoordbcorecomponent.domains.IdInformation;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import com.avbravo.jmoordbcorecomponent.annotationprocessing.Converter;
import com.avbravo.jmoordbcorecomponent.domains.IdInformation;
import com.avbravo.jmoordbcorecomponent.domains.ResultGeneration;
import com.avbravo.jmoordbcorecomponent.utils.FacesUtil;
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
import jakarta.persistence.criteria.PluralJoin;
import java.io.BufferedWriter;
import java.util.List;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 *
 * @author avbravo
 */
public class ConverterServicesGenerator {
String pluralName ="s";
    public ResultGeneration generate(Element element, ProcessingEnvironment processingEnv) {
        ResultGeneration resultGeneration = new ResultGeneration(Boolean.TRUE, "");

        try {
            JavaFileObject builderClass = null;
            PackageElement packageElement = (PackageElement) element.getEnclosingElement();
            BufferedWriter bufferedWriter = null;
            try {
                String builderName = element.getSimpleName().toString() + "ServicesConverter";

                String builderGenName = packageElement.getQualifiedName().toString() + "." + builderName;

                builderClass = processingEnv.getFiler().createSourceFile(builderGenName);
                bufferedWriter = new BufferedWriter(builderClass.openWriter());
                bufferedWriter.append("package ");
                bufferedWriter.append(packageElement.getQualifiedName().toString());
                bufferedWriter.append(";");
                bufferedWriter = imports(bufferedWriter);
                bufferedWriter.newLine();
                bufferedWriter.append("@ViewScoped\n");
                bufferedWriter.append("@Named\n");

                // bufferedWriter.append("@FacesConverter(forClass =" + element.getSimpleName().toString() + ".class, managed = true)");
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.append("\npublic class ");
                bufferedWriter.append(builderName);
                bufferedWriter.append("  implements Serializable");
                bufferedWriter.append("{");
                bufferedWriter = inject(bufferedWriter, element.getSimpleName().toString());
                bufferedWriter = fields(bufferedWriter, element.getSimpleName().toString());

                bufferedWriter.newLine();

                /**
                 * Imprime los set/get de todos los campos Falta mejorarlo
                 */
//                 bufferedWriter = setGet(bufferedWriter, element,builderName);
                /**
                 * Encuentra el Id
                 *
                 *
                 */
                IdInformation idInformation = analizeId(element);
                bufferedWriter = get(bufferedWriter, element.getSimpleName().toString(), idInformation);
                bufferedWriter = add(bufferedWriter, element.getSimpleName().toString(), idInformation);
                bufferedWriter = destroyed(bufferedWriter, element.getSimpleName().toString(), idInformation);

                bufferedWriter.newLine();
                bufferedWriter.append("}");
                bufferedWriter.newLine();
                bufferedWriter.newLine();

                bufferedWriter.close();
            } catch (IOException e) {
                resultGeneration.setMessage(e.toString());
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }
        return resultGeneration;
    }

    // <editor-fold defaultstate="collapsed" desc="BufferedWriter imports(BufferedWriter bufferedWriter)">
    public BufferedWriter imports(BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.append("import jakarta.inject.Inject;\n");
            bufferedWriter.append("import jakarta.faces.convert.Converter;\n");
            bufferedWriter.append("import jakarta.faces.convert.FacesConverter;\n");
            bufferedWriter.append("import jakarta.inject.Named;\n");
            bufferedWriter.append("import jakarta.faces.component.UIComponent;\n");
            bufferedWriter.append("import jakarta.faces.context.FacesContext;\n");
            bufferedWriter.append("import jakarta.faces.application.FacesMessage;\n");
            bufferedWriter.append("import java.util.Optional;\n");
            bufferedWriter.append("import java.io.Serializable;\n");
            bufferedWriter.append("import java.util.ArrayList;\n");
            bufferedWriter.append("import java.util.List;\n");
            bufferedWriter.append("import com.avbravo.jmoordbcorecomponent.utils.FacesUtil;\n");
            

            bufferedWriter.newLine();
            bufferedWriter.newLine();

        } catch (Exception e) {
            System.out.println("Error imports()" + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="BufferedWriter get(BufferedWriter bufferedWriter,IdInformation idInformation)">

    public BufferedWriter get(BufferedWriter bufferedWriter, String nameOfClass, IdInformation idInformation) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.append("\t// <editor-fold defaultstate=\"collapsed\" desc=\"void Optional<"+nameOfClass+">get("+idInformation.getType() + " "+idInformation.getName() +")\">\n");
            bufferedWriter.append("\tpublic Optional<"+nameOfClass+"> get("+idInformation.getType() + " "+idInformation.getName() +"){\n");
            bufferedWriter.append("\t    Optional<"+nameOfClass+"> result;\n");
            bufferedWriter.append("\t    try {\n");
            bufferedWriter.append("\t        result = "+ProcessorTools.toLowercaseFirstLetter(nameOfClass)+pluralName+".stream().filter(x -> x.get" +idInformation.getName() + "().equals("+idInformation.getName() +")).findFirst();\n");
            bufferedWriter.append("\t          if (!result.isPresent()) {\n");
            bufferedWriter.append("\t              Optional<"+nameOfClass+"> "+ProcessorTools.toLowercaseFirstLetter(nameOfClass) +" = " + ProcessorTools.toLowercaseFirstLetter(nameOfClass)+"Services.findBy" + idInformation.getName()+"(" + idInformation.getName()+");\n");
            bufferedWriter.append("\t              if ("+ProcessorTools.toLowercaseFirstLetter(nameOfClass)+".isPresent()) {\n");
            bufferedWriter.append("\t                  "+ProcessorTools.toLowercaseFirstLetter(nameOfClass)+pluralName+".add("+ProcessorTools.toLowercaseFirstLetter(nameOfClass) +".get());\n");
            bufferedWriter.append("\t                    return "+ProcessorTools.toLowercaseFirstLetter(nameOfClass)+";\n");
            bufferedWriter.append("\t              }\n");
            bufferedWriter.append("\t              result = Optional.empty();\n");
            bufferedWriter.append("\t           }\n");
            bufferedWriter.append("\t           return result;\n");
            bufferedWriter.append("\t    } catch (Exception e) {\n");
            bufferedWriter.append("\t       FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + \" \" + e.getLocalizedMessage());\n");
            bufferedWriter.append("\t    }\n");
            bufferedWriter.append("\t    return Optional.empty();\n");
            bufferedWriter.append("\t}\n");
             bufferedWriter.append("\t// </editor-fold>\n\n");
            bufferedWriter.newLine();
        } catch (Exception e) {
            System.out.println("Error add() " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
   
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BufferedWriter add(BufferedWriter bufferedWriter,IdInformation idInformation)">

    public BufferedWriter add(BufferedWriter bufferedWriter, String nameOfClass, IdInformation idInformation) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.append("\t// <editor-fold defaultstate=\"collapsed\" desc=\"void add(List<"+nameOfClass+"> "+ProcessorTools.toLowercaseFirstLetter(nameOfClass)+pluralName +")\">\n");
            bufferedWriter.append("\tpublic void add(List<"+nameOfClass+"> "+ProcessorTools.toLowercaseFirstLetter(nameOfClass)+pluralName +"){\n");
            bufferedWriter.append("\t    try {\n");
            bufferedWriter.append("\t         destroyed();\n");
            bufferedWriter.append("\t    this."+ProcessorTools.toLowercaseFirstLetter(nameOfClass)+pluralName +" = " + ProcessorTools.toLowercaseFirstLetter(nameOfClass)+pluralName +";\n");
            bufferedWriter.append("\t    } catch (Exception e) {\n");
            bufferedWriter.append("\t       FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + \" \" + e.getLocalizedMessage());\n");
            bufferedWriter.append("\t    }\n");
            bufferedWriter.append("\t}\n");
             bufferedWriter.append("\t// </editor-fold>\n\n");
            bufferedWriter.newLine();
        } catch (Exception e) {
            System.out.println("Error add() " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
   
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BufferedWriter destroyed(BufferedWriter bufferedWriter,IdInformation idInformation)">

    public BufferedWriter destroyed(BufferedWriter bufferedWriter, String nameOfClass, IdInformation idInformation) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.append("\t// <editor-fold defaultstate=\"collapsed\" desc=\"void destroyed()\">\n");
            bufferedWriter.append("\tpublic void destroyed() {\n");
            bufferedWriter.append("\t    try {\n");
            bufferedWriter.append("\t    this."+ProcessorTools.toLowercaseFirstLetter(nameOfClass)+pluralName +" = new ArrayList<>();\n");
            bufferedWriter.append("\t    } catch (Exception e) {\n");
            bufferedWriter.append("\t       FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + \" \" + e.getLocalizedMessage());\n");
            bufferedWriter.append("\t    }\n");
            bufferedWriter.append("\t    return \"\";\n");
            bufferedWriter.append("\t}\n");
            bufferedWriter.append("\t// </editor-fold>\n\n");
            
            bufferedWriter.newLine();
        } catch (Exception e) {
            System.out.println("Error destroyed() " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BufferedWriter inject(BufferedWriter bufferedWriter)">
    public BufferedWriter inject(BufferedWriter bufferedWriter, String nameOfClass) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.append("\t@Inject");
            bufferedWriter.newLine();
            bufferedWriter.append("\t " + nameOfClass + "Services " + ProcessorTools.toLowercaseFirstLetter(nameOfClass) + "Services;");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
        } catch (Exception e) {
            System.out.println("Error getAsString()" + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BufferedWriter fields(BufferedWriter bufferedWriter)">
    public BufferedWriter fields(BufferedWriter bufferedWriter, String nameOfClass) {
        try {
            
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.append("\t List<" + nameOfClass + "> " + ProcessorTools.toLowercaseFirstLetter(nameOfClass) +pluralName + " = new ArrayList<>();\n");
            bufferedWriter.append("\t public List<" + nameOfClass + "> get" + nameOfClass +pluralName+ "(){\n");
            bufferedWriter.append("\t     return " + ProcessorTools.toLowercaseFirstLetter(nameOfClass) +pluralName+ ";\n");
            bufferedWriter.append("\t}\n\n");
            
            bufferedWriter.append("\t public void set" + nameOfClass+pluralName + "(List<" + nameOfClass + "> "+ ProcessorTools.toLowercaseFirstLetter(nameOfClass)+pluralName + "){\n");
            bufferedWriter.append("\t     this." + ProcessorTools.toLowercaseFirstLetter(nameOfClass) +pluralName+" = "+ ProcessorTools.toLowercaseFirstLetter(nameOfClass) +pluralName+";\n");
            bufferedWriter.append("\t}\n");
            
            
            bufferedWriter.newLine();
            bufferedWriter.newLine();
        } catch (Exception e) {
            System.out.println("Error getAsString()" + e.getLocalizedMessage());
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
            System.out.println("Error setGet" + e.getLocalizedMessage());
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
            System.out.println("Error setGet" + e.getLocalizedMessage());
        }
        return idInformation;
    }
    // </editor-fold>
}
