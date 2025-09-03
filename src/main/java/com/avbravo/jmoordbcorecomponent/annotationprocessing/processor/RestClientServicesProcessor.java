/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor;

/**
 *
 * @author avbravo
 */
import com.avbravo.jmoordbcorecomponent.annotationprocessing.RestClientServices;
import com.avbravo.jmoordbcorecomponent.domains.IdInformation;
import com.avbravo.jmoordbcorecomponent.domains.RestClientServicesInformation;
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
import com.avbravo.jmoordbcorecomponent.model.RestClientServicesMethod;
import com.jmoordb.core.processor.fields.Parametro;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.avbravo.jmoordbcorecomponent.annotationprocessing.RestClientServices")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class RestClientServicesProcessor extends AbstractProcessor {

    ResultGeneration resultGeneration = new ResultGeneration();
    List<RestClientServicesMethod> restClientServicesMethods = new ArrayList<>();
  RestClientServicesInformation  restClientServicesInformation = new RestClientServicesInformation();
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        IdInformation idInformation = new IdInformation();
        for (Element element : roundEnv.getElementsAnnotatedWith(RestClientServices.class)) {

            JavaFileObject builderClass = null;
            PackageElement packageElement = (PackageElement) element.getEnclosingElement();
            BufferedWriter bufferedWriter = null;
            try {
                String builderName = element.getSimpleName().toString() + "Impl";

                String builderGenName = packageElement.getQualifiedName().toString() + "." + builderName;

                builderClass = processingEnv.getFiler().createSourceFile(builderGenName);
                /**
                 * Obtiene el entity y RestClient de la anotacion
                 * RestClientServices
                 */
                RestClientServices restClientServices = element.getAnnotation(RestClientServices.class);
                TypeMirror typeEntity = ProcessorTools.mirror(restClientServices::entity);
                TypeMirror typeRestClient = ProcessorTools.mirror(restClientServices::restClient);
                
                restClientServicesInformation = new RestClientServicesInformation.Builder()
                        .entity(typeEntity.toString())
                        .restClient(typeRestClient.toString())
                        .restClientVar(ProcessorTools.toLowercaseFirstLetter(ProcessorTools.nameOfFileInPath(typeRestClient.toString())))
                        .build();
                
                bufferedWriter = new BufferedWriter(builderClass.openWriter());
                bufferedWriter.append("package ");
                bufferedWriter.append(packageElement.getQualifiedName().toString());
                bufferedWriter.append(";");
                bufferedWriter = imports(bufferedWriter, packageElement);
                bufferedWriter.newLine();
                bufferedWriter.append("@Named");
                bufferedWriter.newLine();
                bufferedWriter.append("@ApplicationScoped");
                bufferedWriter.newLine();
                bufferedWriter.append("\npublic class ");
                bufferedWriter.append(builderName);
                bufferedWriter.append("  implements " + element.getSimpleName().toString() + "");
                bufferedWriter.append("{");
                bufferedWriter = inject(bufferedWriter, element.getSimpleName().toString(),restClientServicesInformation);
                bufferedWriter = config(bufferedWriter);

                bufferedWriter.newLine();

                /**
                 * Imprime los set/get de todos los campos Falta mejorarlo
                 */
//                 bufferedWriter = setGet(bufferedWriter, element,builderName);
                

//                  System.out.println("typeEntity.toString() "+typeEntity.toString());
//                  System.out.println("typeRestClient.toString() "+typeRestClient.toString());
                /**
                 * Encuentra la firma de los metodos
                 *
                 */
                restClientServicesMethods = analizeMethod(element);
                idInformation = analizeId(element);

                if (restClientServicesMethods.isEmpty() || restClientServicesMethods.size() == 0 || restClientServicesMethods == null) {

                } else {
                    for (RestClientServicesMethod rcsm : restClientServicesMethods) {
                        bufferedWriter = generateMethods(bufferedWriter, element.getSimpleName().toString(), rcsm, idInformation, restClientServicesInformation);
                    }

                }

                bufferedWriter.newLine();
                bufferedWriter.append("}");
                bufferedWriter.newLine();
                bufferedWriter.newLine();

                bufferedWriter.close();

            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.toString());
            }
            /**
             * Generar el ConverterServer Se invoca a la clase que lo maneja
             */

        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="BufferedWriter imports(BufferedWriter bufferedWriter,PackageElement packageElement )">
    public BufferedWriter imports(BufferedWriter bufferedWriter, PackageElement packageElement) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.append("import jakarta.inject.Inject;\n");
            bufferedWriter.append("import jakarta.inject.Named;\n");
            bufferedWriter.append("import jakarta.faces.component.UIComponent;\n");
            bufferedWriter.append("import jakarta.faces.context.FacesContext;\n");
            bufferedWriter.append("import jakarta.faces.application.FacesMessage;\n");
            bufferedWriter.append("import java.util.Optional;\n");
            bufferedWriter.append("import com.avbravo.jmoordbcorecomponent.utils.FacesUtil;\n");
            bufferedWriter.append("import jakarta.faces.convert.ConverterException;\n");
            bufferedWriter.append("import jakarta.enterprise.context.ApplicationScoped;\n");
            bufferedWriter.append("import com.avbravo.jmoordbcorecomponent.utils.JmoordbCoreResourcesFiles;\n");
            bufferedWriter.append("import org.eclipse.microprofile.config.Config;\n");
            bufferedWriter.append("import jakarta.ws.rs.core.Response;\n");

        } catch (Exception e) {

            System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BufferedWriter generateMethods(BufferedWriter bufferedWriter,IdInformation idInformation, RestClientServicesInformation  restClientServicesInformation)">
    public BufferedWriter generateMethods(BufferedWriter bufferedWriter, String nameOfClass, RestClientServicesMethod restClientServicesMethod, IdInformation idInformation, RestClientServicesInformation  restClientServicesInformation) {
        try {
            String parameters = "";
            String separator = "";
            if (restClientServicesMethod.getParametros().size() == 0) {

            } else {
                for (Parametro p : restClientServicesMethod.getParametros()) {
                    parameters += separator + p.getType() + " " + p.getName();
                    separator = ", ";
                }
            }
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.append("\t@Override");
            bufferedWriter.newLine();
            bufferedWriter.append("\tpublic " + restClientServicesMethod.getReturnTypeValue() + " " + restClientServicesMethod.getNameOfMethod() + "(" + parameters + "){\n");

            switch (restClientServicesMethod.getNameOfMethod()) {
                case "save":
                    bufferedWriter = generateMethodsSave(bufferedWriter, nameOfClass, restClientServicesMethod, idInformation, restClientServicesInformation);
                    break;

            }

            bufferedWriter.newLine();
            bufferedWriter.append("\t}");

        } catch (Exception e) {
            System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }

    // </editor-fold
    // <editor-fold defaultstate="collapsed" desc="BufferedWriter generateMethodsSave(BufferedWriter bufferedWriter,IdInformation idInformation, RestClientServicesInformation  restClientServicesInformation)">
    public BufferedWriter generateMethodsSave(BufferedWriter bufferedWriter, String nameOfClass, RestClientServicesMethod restClientServicesMethod, IdInformation idInformation, RestClientServicesInformation  restClientServicesInformation) {
        try {
            String nameParameter = restClientServicesMethod.getParametros().size() ==0 ?"":restClientServicesMethod.getParametros().get(0).getName();

            bufferedWriter.newLine();
            bufferedWriter.append("\ttry{\n");
            bufferedWriter.append("\t   Response response = " + restClientServicesInformation.getRestClientVar()+ ".save(" + nameParameter + ");\n");
            bufferedWriter.append("\t   if (response.getStatus() == 400) {\n");
            bufferedWriter.append("\t      String error = (response.readEntity(String.class));\n");
            bufferedWriter.append("\t      return Optional.empty();\n");
            bufferedWriter.append("\t   }\n");
            bufferedWriter.append("\t   " + restClientServicesInformation.getEntity() + " result = (" + restClientServicesInformation.getEntity()+ ") (response.readEntity("+restClientServicesInformation.getEntity() +".class));\n");
            bufferedWriter.append("\t   return Optional.of(result);\n");
            bufferedWriter.append("\t} catch (Exception e) {\n");
            bufferedWriter.append("\t  FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + \" \" + e.getLocalizedMessage());\n");
            bufferedWriter.append("\t}\n");
            bufferedWriter.append("\treturn Optional.empty();\n");
        } catch (Exception e) {
            System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }
    // </editor-fold

    // <editor-fold defaultstate="collapsed" desc="BufferedWriter inject(BufferedWriter bufferedWriter, String nameOfClass, RestClientServicesInformation  restClientServicesInformation)">
    public BufferedWriter inject(BufferedWriter bufferedWriter, String nameOfClass, RestClientServicesInformation  restClientServicesInformation) {
        try {

            bufferedWriter.newLine();
            bufferedWriter.append("// <editor-fold defaultstate=\"collapsed\" desc=\"@Inject\">\n");
            bufferedWriter.append("\t@Inject\n");            
            bufferedWriter.append("\t JmoordbCoreResourcesFiles rf;\n");
            bufferedWriter.append("\t@Inject\n");            
            bufferedWriter.append("\t "+restClientServicesInformation.getRestClient() +" "+restClientServicesInformation.getRestClientVar() + "; \n");
            bufferedWriter.append("// </editor-fold>");
        } catch (Exception e) {
            System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BufferedWriter config(BufferedWriter bufferedWriter)">
    public BufferedWriter config(BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.newLine();
            bufferedWriter.append("// <editor-fold defaultstate=\"collapsed\" desc=\"@Config\">\n");
            bufferedWriter.append("\t@Inject");
            bufferedWriter.newLine();
            bufferedWriter.append("\t private Config config;\n");
            bufferedWriter.append("// </editor-fold>");
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
    // <editor-fold defaultstate="collapsed" desc="IdInformation analizeId()">
    /**
     * Encuentra la información de la llave primaria
     *
     * @return
     */
    public List<RestClientServicesMethod> analizeMethod(Element element) {
        List<RestClientServicesMethod> results = new ArrayList<>();
        List<Parametro> parametros = new ArrayList<>();
        try {

            for (ExecutableElement executableElement : ElementFilter.methodsIn(element.getEnclosedElements())) {
                //metodo que almacena la información del repositorio

                if (executableElement.getKind() != ElementKind.METHOD) {

                    continue;
                }
                /**
                 * Obtiene el nombre del metodo
                 */
                String methodName = ProcessorTools.nameOfMethod(executableElement);

                /**
                 * Obtengo el valor de retorno convierte a ReturnType.
                 */
                TypeMirror returnTypeOfMethod = executableElement.getReturnType();

                /**
                 * Parametros
                 */
                parametros = new ArrayList<>();
                List<? extends VariableElement> parameters = executableElement.getParameters();
                if (parameters.size() <= 0) {

                } else {
                    for (int i = 0; i < parameters.size(); i++) {

                        VariableElement param = parameters.get(i);

                        TypeMirror secondArgumentType = param.asType();

                        /**
                         * Revisa las anotaciones que tiene
                         */
//                        if (parameters.get(i).getAnnotation(IncludeTime.class) != null) {
//                            //    isIncludeTime = Boolean.TRUE;
//                        } else {
//
//                            if (parameters.get(i).getAnnotation(ExcludeTime.class) != null) {
//
//                                //  isExcludeTime = Boolean.TRUE;
//                            } else {
//                                //  isIncludeTime = Boolean.FALSE;
//                                // isExcludeTime = Boolean.FALSE;
//                            }
//                        }
                        Parametro parametro = new Parametro.Builder()
                                .name(param.getSimpleName().toString())
                                .type(param.asType().toString())
                                .build();
                        parametros.add(parametro);

                    }
                }
                RestClientServicesMethod restClientServicesMethod = new RestClientServicesMethod.Builder()
                        .nameOfMethod(methodName)
                        .returnType(returnTypeOfMethod.toString())
                        .parametros(parametros)
                        .build();
                results.add(restClientServicesMethod);
            }

        } catch (Exception e) {
            System.out.println(ProcessorTools.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return results;
    }
    // </editor-fold>
}
