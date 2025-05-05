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
//    private List<SubMenu> subMenus = new ArrayList<>();
    private List<String> roles = new ArrayList<>();
    private String action;

    public MenuBar() {
    }

    public MenuBar(String action,List<BoxMenu> boxMenus ) {
        this.action = action;
        this.boxMenus  = boxMenus;
    }

    
    
  
    // <editor-fold defaultstate="collapsed" desc="set/get">
    
//    public List<SubMenu> getSubMenus() {
//        return subMenus;
//    }
//
//    public void setSubMenus(List<SubMenu> subMenus) {
//        this.subMenus = subMenus;
//    }

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
        private String label;
        private String action;
        private ImageInfo imageInfo;
        private List<SubMenu> subMenus = new ArrayList<>();
        private List<MenuItem> menuItems = new ArrayList<>();
        List<String> roles = new ArrayList<>();

        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder boxMenus(List<BoxMenu> boxMenus) {
            this.boxMenus = boxMenus;
            return this;
        }

        public Builder imageInfo(ImageInfo imageInfo) {
            this.imageInfo = imageInfo;
            return this;
        }

        public Builder menuItems(List<MenuItem> menuItems) {
            this.menuItems = menuItems;
            return this;
        }

        public Builder subMenus(List<SubMenu> subMenus) {
            this.subMenus = subMenus;
            return this;
        }

        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public MenuBar build() {
            return new MenuBar(action, boxMenus);

        }

    }
}
