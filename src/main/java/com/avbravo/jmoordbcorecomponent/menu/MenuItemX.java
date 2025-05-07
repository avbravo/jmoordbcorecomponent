/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class MenuItemX {

    private String action;
    private String text;
    private String minText;
    private String imageLibrary;
    private String imageName;
    private String badgeSpanLabel;
    private String badgeSpanType;

//    private ImageInfo imageInfo;
    private List<String> roles = new ArrayList<>();

    public MenuItemX() {
    }

    public MenuItemX(String action, String text, String minText, String imageLibrary, String imageName, String badgeSpanLabel, String badgeSpanType) {
        this.action = action;
        this.text = text;
        this.minText = minText;
        this.imageLibrary = imageLibrary;
        this.imageName = imageName;
        this.badgeSpanLabel = badgeSpanLabel;
        this.badgeSpanType = badgeSpanType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMinText() {
        return minText;
    }

    public void setMinText(String minText) {
        this.minText = minText;
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

    public String getBadgeSpanLabel() {
        return badgeSpanLabel;
    }

    public void setBadgeSpanLabel(String badgeSpanLabel) {
        this.badgeSpanLabel = badgeSpanLabel;
    }

    public String getBadgeSpanType() {
        return badgeSpanType;
    }

    public void setBadgeSpanType(String badgeSpanType) {
        this.badgeSpanType = badgeSpanType;
    }

    public List<String> getRoles() {
        return roles;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    // <editor-fold defaultstate="collapsed" desc="BoxMenu toBoxMenu()">
    public BoxMenu toBoxMenu() {
       return new BoxMenu().add(this);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Builder">
    public static class Builder {

        private String action;
        private String text;
        private String minText;
        private String imageLibrary;
        private String imageName;
        private String badgeSpanLabel;
        private String badgeSpanType;
        private List<String> roles = new ArrayList<>();

        public Builder action(String action) {
            this.action = action;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder minText(String minText) {
            this.minText = minText;
            return this;
        }

        public Builder imageLibrary(String imageLibrary) {
            this.imageLibrary = imageLibrary;
            return this;
        }

        public Builder imageName(String imageName) {
            this.imageName = imageName;
            return this;
        }

        public Builder badgeSpanLabel(String badgeSpanLabel) {
            this.badgeSpanLabel = badgeSpanLabel;
            return this;
        }

        public Builder badgeSpanType(String badgeSpanType) {
            this.badgeSpanType = badgeSpanType;
            return this;
        }

        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public MenuItemX build() {
            return new MenuItemX(action, text, minText, imageLibrary, imageName, badgeSpanLabel, badgeSpanType);

        }

    }
    // </editor-fold>
}
