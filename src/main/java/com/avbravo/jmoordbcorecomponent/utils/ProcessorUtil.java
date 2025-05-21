/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.util.ElementFilter;


/**
 *
 * @author avbravo
 */
public class ProcessorUtil {

  // <editor-fold defaultstate="collapsed" desc="String getPackageName(Element element)">
    public static String getPackageName(Element element) {
        List<PackageElement> packageElements
                = ElementFilter.packagesIn(Arrays.asList(element.getEnclosingElement()));

        Optional<PackageElement> packageElement = packageElements.stream().findAny();
        return packageElement.isPresent()
                ? packageElement.get().getQualifiedName().toString() : null;

    }
// </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="String getPackageNameConfiguration(String packagePath)">
    public static String getPackageNameConfiguration(String packagePath) {
        String result ="";
        try {
              result = packagePath.substring(0,packagePath.lastIndexOf("."))+".configuration";
        } catch (Exception e) {
        }
        return result;
     
    }
// </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="String getPackageNameModel(String packagePath)">
    public static String getPackageNameModel(String packagePath) {
        String result ="";
        try {
              result = packagePath.substring(0,packagePath.lastIndexOf("."))+".model";
        } catch (Exception e) {
        }
        return result;
     
    }
// </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="String getPackageNameServices(String packagePath)">
    public static String getPackageNameServices(String packagePath) {
         String result ="";
        try {
              result = packagePath.substring(0,packagePath.lastIndexOf("."))+".services";
        } catch (Exception e) {
        }
        return result;
    }
// </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="String getPackageNameRestClient(String packagePath)">
    public static String getPackageNameRestClient(String packagePath) {
        String result ="";
        try {
              result = packagePath.substring(0,packagePath.lastIndexOf("."))+".restclient";
        } catch (Exception e) {
        }
        return result;

    }
// </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="String getPackageNameConverter(String packagePath)">
    public static String getPackageNameConverter(String packagePath) {
        String result ="";
        try {
              result = packagePath.substring(0,packagePath.lastIndexOf("."))+".converter";
        } catch (Exception e) {
        }
        return result;

    }
// </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="String getPackageNameFaces(String packagePath)">
    public static String getPackageNameFaces(String packagePath) {
        String result ="";
        try {
              result = packagePath.substring(0,packagePath.lastIndexOf("."))+".faces";
        } catch (Exception e) {
        }
        return result;

    }
// </editor-fold>
}
