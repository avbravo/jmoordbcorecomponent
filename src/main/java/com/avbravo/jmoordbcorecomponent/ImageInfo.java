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

    public ImageInfo() {
    }

    public ImageInfo(String library, String name) {
        this.library = library;
        this.name = name;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">
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

    public static class Builder {

        private String library;
        private String name;

        public Builder library(String library) {
            this.library = library;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public ImageInfo build() {
            return new ImageInfo(library, name);

        }
    }

}
