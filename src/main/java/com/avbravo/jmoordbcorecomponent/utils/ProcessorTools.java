/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.utils;

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

}
