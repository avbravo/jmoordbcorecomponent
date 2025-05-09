/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import com.avbravo.jmoordbcorecomponent.HrefInfo;
import com.avbravo.jmoordbcorecomponent.ImageInfo;
import com.avbravo.jmoordbcorecomponent.enumerations.TypeMenu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class SubMenu {

    private String action;
    private String text;
    private String minText;
    private String imageLibrary;
    private String imageName;
    private String imageContextRoot;
    private String ariaControls;

    private List<BoxMenu> boxMenus = new ArrayList<>();
    private List<String> roles = new ArrayList<>();

    public SubMenu() {
    }

    public SubMenu(String action, String text, String minText, String imageLibrary, String imageName, List<BoxMenu> boxMenus, List<String> roles, String ariaControls,String imageContextRoot) {
       this.action = action;
        this.text = text;
        this.minText = minText;
        this.imageLibrary = imageLibrary;
        this.imageName = imageName;
        this.boxMenus = boxMenus;
        this.roles = roles;
        this.ariaControls = ariaControls;
        this.imageContextRoot = imageContextRoot;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">

    public String getImageContextRoot() {
        return imageContextRoot;
    }

    public void setImageContextRoot(String imageContextRoot) {
        this.imageContextRoot = imageContextRoot;
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

    public String getAriaControls() {
        return ariaControls;
    }

    public void setAriaControls(String ariaControls) {
        this.ariaControls = ariaControls;
    }

    public List<BoxMenu> getBoxMenus() {
        return boxMenus;
    }

    public void setBoxMenus(List<BoxMenu> boxMenus) {
        this.boxMenus = boxMenus;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="BoxMenu toBoxMenu()">
    public BoxMenu toBoxMenu() {
       return new BoxMenu().add(this);
    }
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Builder()">

    public static class Builder {
    private String action;
    private String text;
    private String minText;
    private String imageLibrary;
    private String imageName;
        private String ariaControls;
        private String imageContextRoot;

        private List<BoxMenu> boxMenus = new ArrayList<>();
        List<String> roles = new ArrayList<>();

        public Builder action(String action) {
            this.action = action;
            return this;
        }
        public Builder imageContextRoot(String imageContextRoot) {
            this.imageContextRoot = imageContextRoot;
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

        public Builder ariaControls(String ariaControls) {
            this.ariaControls = ariaControls;
            return this;
        }

      

        public Builder boxMenus(List<BoxMenu> boxMenus) {
            this.boxMenus = boxMenus;
            return this;
        }

        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public SubMenu build() {
            return new SubMenu(action, text, minText, imageLibrary, imageName, boxMenus, roles, ariaControls, imageContextRoot);

        }

    }

    // </editor-fold>
}
