/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.template;

/**
 *
 * @author avbravo
 */
public class TopHeaderMessage {

    private String title;
    private String subtitle;
    private String footer;
    private String action;
    private String imageLibrary;
    private String imageName;
 private String imageContextRoot;


    public TopHeaderMessage() {
    }

   public TopHeaderMessage(String title, String subtitle, String footer, String action, String imageLibrary, String imageName,String imageContextRoot) {
        this.title = title;
        this.subtitle = subtitle;
        this.footer = footer;
        this.action = action;
        this.imageLibrary = imageLibrary;
        this.imageName = imageName;
        this.imageContextRoot = imageContextRoot;
    }

   

    // <editor-fold defaultstate="collapsed" desc="set/get()">
 public String getAction() {
        return action;
    }
    public String getImageContextRoot() {
        return imageContextRoot;
    }

    public void setImageContextRoot(String imageContextRoot) {
        this.imageContextRoot = imageContextRoot;
    }
    
    
    
    public void setAction(String action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

 
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
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

     private String title;
    private String subtitle;
    private String footer;
       private String action;
    private String imageLibrary;
    private String imageName;
     private String imageContextRoot;

        public Builder imageContextRoot(String imageContextRoot) {
            this.imageContextRoot= imageContextRoot;
            return this;
        }
        public Builder action(String action) {
            this.action = action;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }
        public Builder footer(String footer) {
            this.footer = footer;
            return this;
        }
        public Builder imageLibrary(String imageLibrary) {
            this.imageLibrary = imageLibrary;
            return this;
        }
        public Builder imageName(String imageName) {
            this.imageName= imageName;
            return this;
        }

       

        public TopHeaderMessage build() {
            return new TopHeaderMessage(title, subtitle, footer, action, imageLibrary, imageName, imageContextRoot);

        }

    }
    // </editor-fold>

}
