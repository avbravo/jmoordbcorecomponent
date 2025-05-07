/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import com.avbravo.jmoordbcorecomponent.BadgeSpanInfo;
import com.avbravo.jmoordbcorecomponent.ImageInfo;
import com.avbravo.jmoordbcorecomponent.utils.Messages;

/**
 *
 * @author avbravo
 */
public class Draw {

// <editor-fold defaultstate="collapsed" desc="String image(ImageInfo imageInfo)">
    public static String image(ImageInfo imageInfo) {
        String result = "";
        try {
            if (imageInfo.getLibrary().equals("primefaces")) {
                result = "<i class=\"" + imageInfo.getName() + "\"></i>\n ";
            } else {
                result = "<img src=\"/jakarta.faces.resource/" + imageInfo.getName() + ".xhtml?ln=" + imageInfo.getLibrary() + "\">\n";
            }

        } catch (Exception e) {
            Messages.error(e.getLocalizedMessage());
        }
        return result;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="String image(String library, String name)">
    public static String image(String library, String name) {
        String result = "";
        try {
            if (library.equals("primefaces")) {
                result = "<i class=\"" + name + "\"></i>\n ";
            } else {
                result = "<img src=\"/jakarta.faces.resource/" + name+ ".xhtml?ln=" + library+ "\">\n";
            }

        } catch (Exception e) {
            Messages.error(e.getLocalizedMessage());
        }
        return result;
    }

// </editor-fold>
}
