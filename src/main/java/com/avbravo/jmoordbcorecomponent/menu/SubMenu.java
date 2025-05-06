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

    private HrefInfo hrefInfo;
    private String ariaControls;
    private ImageInfo imageInfo;
    private List<BoxMenu> boxMenus = new ArrayList<>();
    private List<String> roles = new ArrayList<>();

    public SubMenu() {
    }

    public SubMenu(HrefInfo hrefInfo, ImageInfo imageInfo, List<BoxMenu> boxMenus, List<String> roles, String ariaControls) {
        this.hrefInfo = hrefInfo;
        this.imageInfo = imageInfo;
        this.boxMenus = boxMenus;
        this.roles = roles;
        this.ariaControls = ariaControls;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">
    public String getAriaControls() {
        return ariaControls;
    }

    public void setAriaControls(String ariaControls) {
        this.ariaControls = ariaControls;
    }

    public HrefInfo getHrefInfo() {
        return hrefInfo;
    }

    public void setHrefInfo(HrefInfo hrefInfo) {
        this.hrefInfo = hrefInfo;
    }

    public List<BoxMenu> getBoxMenus() {
        return boxMenus;
    }

    public void setBoxMenus(List<BoxMenu> boxMenus) {
        this.boxMenus = boxMenus;
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
    // <editor-fold defaultstate="collapsed" desc="BoxMenu toBoxMenu()">
    public BoxMenu toBoxMenu() {

        return new BoxMenu<>(this, TypeMenu.SUBMENU);
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Builder()">

    public static class Builder {

        private String ariaControls;
        private HrefInfo hrefInfo;
        private ImageInfo imageInfo;
        private List<BoxMenu> boxMenus = new ArrayList<>();
        List<String> roles = new ArrayList<>();

        public Builder hrefInfo(HrefInfo hrefInfo) {
            this.hrefInfo = hrefInfo;
            return this;
        }
        public Builder ariaControls(String ariaControls) {
            this.ariaControls = ariaControls;
            return this;
        }

        public Builder imageInfo(ImageInfo imageInfo) {
            this.imageInfo = imageInfo;
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
            return new SubMenu(hrefInfo, imageInfo, boxMenus, roles,ariaControls);

        }

    }

    // </editor-fold>
}
