/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.utils;

/**
 *
 * @author avbravo
 */
public class MenuContextRoot {
    private String imageContextRoot;

    public MenuContextRoot() {
    }

    public MenuContextRoot(String imageContextRoot) {
        this.imageContextRoot = imageContextRoot;
    }

    
    
    public String getImageContextRoot() {
        try {
//                    this.imageContextRoot =PomXMLReader.findProperty("final.name");
                    this.imageContextRoot =FacesUtil.contextPath();
        } catch (Exception e) {
        }

        return imageContextRoot;
    }

    public void setImageContextRoot(String imageContextRoot) {
        this.imageContextRoot = imageContextRoot;
    }
        
}
