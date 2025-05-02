/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import com.avbravo.jmoordbcorecomponent.ImageInfo;
import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class Menu {

    private String label;
    private ImageInfo imageInfo;
    private List<MenuItem> menuItems = new ArrayList<>();
    private List<SubMenu> subMenus = new ArrayList<>();
    private List<String> roles = new ArrayList<>();
    private String action;

    public Menu() {
    }

    public Menu(String label, ImageInfo imageInfo, List<SubMenu> subMenus, List<MenuItem> menuItems, List<String> roles, String action) {
        this.label = label;
        this.imageInfo = imageInfo;
        this.menuItems = menuItems;
        this.roles = roles;
        this.action = action;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">
    public List<SubMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SubMenu> subMenus) {
        this.subMenus = subMenus;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    // </editor-fold>
    public static class Builder {

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

        public Menu build() {
            return new Menu(label, imageInfo, subMenus, menuItems, roles, action);

        }

    }
}
