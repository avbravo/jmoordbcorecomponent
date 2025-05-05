/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import com.avbravo.jmoordbcorecomponent.enumerations.TypeMenu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class GroupMenu {

    private String miniText;
    private String text;
    private String action;
    private List<BoxMenu> boxMenus = new ArrayList<>();
   
    private List<String> roles = new ArrayList<>();

    public GroupMenu() {
    }

    public GroupMenu(String miniText, String text, String action,  List<String> roles,List<BoxMenu> boxMenus) {
        this.miniText = miniText;
        this.text = text;
        this.action = action;
       
        this.roles = roles;
        this.boxMenus = boxMenus;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">

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
    
    
    
    public String getMiniText() {
        return miniText;
    }

    public void setMiniText(String miniText) {
        this.miniText = miniText;
    }

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

    // </editor-fold>
    
    
            // <editor-fold defaultstate="collapsed" desc="BoxMenu toBoxMenu()">
    public BoxMenu toBoxMenu() {

        return new BoxMenu<>(this, TypeMenu.GROUPMENU);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Builder">

    public static class Builder {

        private String miniText;
        private String text;
        private String action;
 private List<BoxMenu> boxMenus = new ArrayList<>();

        private List<String> roles = new ArrayList<>();

        public Builder boxMenus(List<BoxMenu> boxMenus) {
            this.boxMenus = boxMenus;
            return this;
        }

      
        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public Builder miniText(String miniText) {
            this.miniText = miniText;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder action(String action) {
            this.action = action;
            return this;
        }

        public GroupMenu build() {
            return new GroupMenu(miniText, text, action, roles,boxMenus);

        }

    }
    
    // </editor-fold>
}
