/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent;

/**
 *
 * @author avbravo
 */
public class ImageInfo {

    private String library;
    private String name;
    private String imageContextRoot;

    public ImageInfo() {
    }

    public ImageInfo(String library, String name, String imageContextRoot) {
        this.library = library;
        this.name = name;
        this.imageContextRoot = imageContextRoot;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">

    public String getImageContextRoot() {
        return imageContextRoot;
    }

    public void setImageContextRoot(String imageContextRoot) {
        this.imageContextRoot = imageContextRoot;
    }
    
    
    
    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// </editor-fold>

    public static ImageInfo imageInfoMenuItem() {
        ImageInfo imageInfo = new ImageInfo();
        try {
            imageInfo.setLibrary("jmoordbcoreui");
            imageInfo.setName("images/svg/botones/menuitem.svg");

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return imageInfo;
    }
    // <editor-fold defaultstate="collapsed" desc="Builder ">

    public static class Builder {

        private String library;
        private String name;
        private String imageContextRoot;

        public Builder imageContextRoot(String imageContextRoot) {
            this.imageContextRoot = imageContextRoot;
            return this;
        }
        public Builder library(String library) {
            this.library = library;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public ImageInfo build() {
            return new ImageInfo(library, name, imageContextRoot);

        }
    }

    // </editor-fold>
}
