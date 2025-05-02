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

    public MenuItem(ImageInfo imageInfo, List<String> roles,BadgeSpanInfo badgeSpanInfo) {
        this.imageInfo = imageInfo;
        this.roles = roles;
        this.badgeSpanInfo = badgeSpanInfo;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">

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
    public static class Builder {

        private ImageInfo imageInfo;
        private List<String> roles = new ArrayList<>();
        private BadgeSpanInfo badgeSpanInfo;

        public Builder badgeSpanInfo(BadgeSpanInfo badgeSpanInfo) {
            this.badgeSpanInfo= badgeSpanInfo;
            return this;
        }
       
        public Builder imageInfo(ImageInfo imageInfo) {
            this.imageInfo = imageInfo;
            return this;
        }
        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public MenuItem build() {
            return new MenuItem(imageInfo, roles, badgeSpanInfo);

        }

    }
}
