/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.utils;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.File;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avbravo
 */
//@Named
//@RequestScoped
public class FacesUtil {

    private static String opertativeSystem = System.getProperty("os.name").toLowerCase();

    /**
     * Creates a new instance of JakartaFacesUtil
     */
    
    
    public static String contextPath(){
        String result ="";
        try {
         result =   FacesContext.getCurrentInstance()
                           .getExternalContext()
                           .getRequestContextPath();
        } catch (Exception e) {
            showError(e.getLocalizedMessage().toString());
        }
        return result;
    }

    public static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public static void showInfo(String msg) {
        addMessage(FacesMessage.SEVERITY_INFO, "Información", msg);
    }

    public static void showWarn(String msg) {
        addMessage(FacesMessage.SEVERITY_WARN, "Advertencia", msg);
    }

    public static void showError(String msg) {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
    }

    public static void showSticky(String msg) {
        FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sticky Message", msg));
    }

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

    // <editor-fold defaultstate="collapsed" desc="nameOfMethod()">
    public static String nameOfMethod() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return e.getMethodName();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="isWindows()">
    /*
    Implementado desde el ejemplo de Mkyong
    https://mkyong.com/java/how-to-detect-os-in-java-systemgetpropertyosname/
     */
    public static boolean isWindows() {

        return (opertativeSystem.indexOf("win") >= 0);

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="isMac()">
    public static boolean isMac() {

        return (opertativeSystem.indexOf("mac") >= 0);

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="boolean isLinux()">
    public static boolean isLinux() {

        return (opertativeSystem.indexOf("nix") >= 0 || opertativeSystem.indexOf("nux") >= 0 || opertativeSystem.indexOf("aix") > 0);

    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="boolean isSolaris()">

    public static boolean isSolaris() {

        return (opertativeSystem.indexOf("sunos") >= 0);

    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String userHome()">
    public static String userHome() {
        return System.getProperty("user.home");

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="isVacio(String texto)()"> 
    /**
     * return true si es null empty equals("")
     *
     * @param texto
     * @return
     */
    public static Boolean isVacio(String texto) {
        texto = texto.trim();
        return texto == null || texto.equals("") || texto.isEmpty();
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="isVacio(Integer texto)"> 

    /**
     * return true si es null empty equals("")
     *
     * @param texto
     * @return
     */
    public static Boolean isVacio(Integer texto) {
        return texto == null || texto.equals("");
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="isVacio(Integer texto)"> 
    /**
     * return true si es null empty equals("")
     *
     * @param texto
     * @return
     */
    public static Boolean isVacio(Double texto) {
        return texto == null || texto.equals("");
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean isNegativo(Double texto)"> 
    /**
     * return true si es null empty equals("")
     *
     * @param texto
     * @return
     */
    public static Boolean isNegativo(Double numero) {
        return numero == null || numero.equals("") || numero < 0;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean isNegativo(Double texto)"> 
    /**
     * return true si es null empty equals("")
     *
     * @param texto
     * @return
     */
    public static Boolean isNegativo(Integer numero) {
        return numero == null || numero.equals("") || numero < 0;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getUUID"> 
    /**
     * genera id
     *
     * @return returna un randomUUID automatico
     */
    public static String getUUID() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString();

    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="void pomXMLFileShowAllProperties()">

    public static void pomXMLFileShowAllProperties(){

        try {
            File pomFile = new File("pom.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;

            builder = factory.newDocumentBuilder();

            org.w3c.dom.Document doc;

            doc = builder.parse(pomFile);

            // Obtener la sección <properties>
            NodeList propertiesNodes = doc.getElementsByTagName("properties");
            if (propertiesNodes.getLength() > 0) {
                Element propertiesElement = (Element) propertiesNodes.item(0);
                NodeList propertyNodes = propertiesElement.getChildNodes();

                for (int i = 0; i < propertyNodes.getLength(); i++) {
                    if (propertyNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        Element property = (Element) propertyNodes.item(i);
                        String nombre = property.getNodeName();
                        String valor = property.getTextContent();
                        System.out.println(nombre + ": " + valor);
                    }
                }
            }
        } catch (Exception ex) {
            System.getLogger(FacesUtil.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String pomXMLFilefindProperty(String propertie)">

    public static String pomXMLFilefindProperty(String propertie){
String result="";
        try {
            File pomFile = new File("pom.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;

            builder = factory.newDocumentBuilder();

           org.w3c.dom.Document doc;

            doc = builder.parse(pomFile);

            // Obtener la sección <properties>
            NodeList propertiesNodes = doc.getElementsByTagName("properties");
            if (propertiesNodes.getLength() > 0) {
                Element propertiesElement = (Element) propertiesNodes.item(0);
                NodeList propertyNodes = propertiesElement.getChildNodes();

                for (int i = 0; i < propertyNodes.getLength(); i++) {
                    if (propertyNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        Element property = (Element) propertyNodes.item(i);
                        String nombre = property.getNodeName();
                        if(nombre.equals(propertie)){
                            result = property.getTextContent();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.getLogger(FacesUtil.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }
    // </editor-fold>
    


}
