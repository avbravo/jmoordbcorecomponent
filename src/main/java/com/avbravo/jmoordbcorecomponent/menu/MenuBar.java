/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import com.avbravo.jmoordbcorecomponent.ImageInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class MenuBar {

    private List<BoxMenu> boxMenus = new ArrayList<>();
    private List<String> roles = new ArrayList<>();
    private String action;
    

    public MenuBar() {
    }

    public MenuBar(String action, List<BoxMenu> boxMenus,List<String> roles) {
        this.action = action;
        this.boxMenus = boxMenus;
        this.roles = roles;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">

    public List<BoxMenu> getBoxMenus() {
        return boxMenus;
    }

    public void setBoxMenus(List<BoxMenu> boxMenus) {
        this.boxMenus = boxMenus;
    }
    
    
    
    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    // </editor-fold>
    public static class Builder {

        private List<BoxMenu> boxMenus = new ArrayList<>();
        private String action;

        List<String> roles = new ArrayList<>();

        public Builder boxMenus(List<BoxMenu> boxMenus) {
            this.boxMenus = boxMenus;
            return this;
        }

        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }
        public Builder action(String action) {
            this.action = action;
            return this;
        }

        public MenuBar build() {
            return new MenuBar(action, boxMenus, roles);

        }

    }
}
