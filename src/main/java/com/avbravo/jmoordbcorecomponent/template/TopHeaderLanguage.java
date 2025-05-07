/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.template;

/**
 *
 * @author avbravo
 */
public class TopHeaderLanguage {

    private String text;
    private String action;
    private String imageLibrary;
    private String imageName;

    public TopHeaderLanguage() {
    }

    public TopHeaderLanguage(String text, String action, String imageLibrary, String imageName) {
        this.text = text;
        this.action = action;
        this.imageLibrary = imageLibrary;
        this.imageName = imageName;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get()">
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getImageLibrary() {
        return imageLibrary;
    }

    public void setImageLibrary(String imageLibrary) {
        this.imageLibrary = imageLibrary;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Builder()">
    public static class Builder {

       private String text;
    private String action;
    private String imageLibrary;
    private String imageName;

        public Builder text(String text) {
            this.text= text;
            return this;
        }
        public Builder action(String action) {
            this.action= action;
            return this;
        }
        public Builder imageLibrary(String imageLibrary) {
            this.imageLibrary= imageLibrary;
            return this;
        }
        public Builder imageName(String imageName) {
            this.imageName= imageName;
            return this;
        }
       

        public TopHeaderLanguage build() {
            return new TopHeaderLanguage(text, action, imageLibrary, imageName);

        }

    }
    // </editor-fold>
}
