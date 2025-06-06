/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing;

/**
 *
 * @author avbravo
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Anotación para marcar una clase como controlador de endpoints
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface EndpointController {
    
 String basePath() default "";
}
