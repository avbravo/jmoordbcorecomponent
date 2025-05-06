/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import com.avbravo.jmoordbcorecomponent.BadgeSpanInfo;
import com.avbravo.jmoordbcorecomponent.HrefInfo;
import com.avbravo.jmoordbcorecomponent.ImageInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class MenuItem {

    private BadgeSpanInfo badgeSpanInfo;
    private HrefInfo hrefInfo;
    private ImageInfo imageInfo;
    private List<String> roles = new ArrayList<>();

    public MenuItem() {
    }

    public MenuItem(ImageInfo imageInfo, List<String> roles, BadgeSpanInfo badgeSpanInfo, HrefInfo hrefInfo) {
        this.imageInfo = imageInfo;
        this.roles = roles;
        this.badgeSpanInfo = badgeSpanInfo;
        this.hrefInfo = hrefInfo;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">
    public HrefInfo getHrefInfo() {
        return hrefInfo;
    }

    public void setHrefInfo(HrefInfo hrefInfo) {
        this.hrefInfo = hrefInfo;
    }

    public BadgeSpanInfo getBadgeSpanInfo() {
        return badgeSpanInfo;
    }

    public void setBadgeSpanInfo(BadgeSpanInfo badgeSpanInfo) {
        this.badgeSpanInfo = badgeSpanInfo;
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
       return new BoxMenu().add(this);
    }
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Builder">

    public static class Builder {

        private ImageInfo imageInfo;
        private HrefInfo hrefInfo;
        private List<String> roles = new ArrayList<>();
        private BadgeSpanInfo badgeSpanInfo;

        public Builder badgeSpanInfo(BadgeSpanInfo badgeSpanInfo) {
            this.badgeSpanInfo = badgeSpanInfo;
            return this;
        }

        public Builder imageInfo(ImageInfo imageInfo) {
            this.imageInfo = imageInfo;
            return this;
        }

        public Builder hrefInfo(HrefInfo hrefInfo) {
            this.hrefInfo = hrefInfo;
            return this;
        }

        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public MenuItem build() {
            return new MenuItem(imageInfo, roles, badgeSpanInfo, hrefInfo);

        }

    }
    // </editor-fold>
}
