/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.template;

import com.avbravo.jmoordbcorecomponent.ImageInfo;
import com.avbravo.jmoordbcorecomponent.menu.MenuBar;

/**
 *
 * @author avbravo
 */
public class Template {

    private Footer footer;
    private String logoTitle;
//Images Logo
    private ImageInfo imageInfoLogoNormal;
    private ImageInfo imageInfoLogoMini;

    private String logoMiniImageSize;
    //NavHeader Section
    private NavHeader navHeader;
    // Canva
    private Canva canva;
    // Menu
    private MenuBar menuBar;
    
// TopHeader
    private TopHeader topHeader;

    public Template() {
    }

    public Template(Footer footer, String logoTitle, ImageInfo imageInfoLogoNormal, ImageInfo imageInfoLogoMini, String logoMiniImageSize, NavHeader navHeader, Canva canva, MenuBar menuBar,TopHeader topHeader) {
        this.footer = footer;
        this.logoTitle = logoTitle;
        this.imageInfoLogoNormal = imageInfoLogoNormal;
        this.imageInfoLogoMini = imageInfoLogoMini;
        this.logoMiniImageSize = logoMiniImageSize;
        this.navHeader = navHeader;
        this.canva = canva;
        this.menuBar = menuBar;
        this.topHeader = topHeader;

    }


// <editor-fold defaultstate="collapsed" desc="set/get">

    public TopHeader getTopHeader() {
        return topHeader;
    }

    public void setTopHeader(TopHeader topHeader) {
        this.topHeader = topHeader;
    }

   
    
    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }
   
    
    

    public Canva getCanva() {
        return canva;
    }

    public void setCanva(Canva canva) {
        this.canva = canva;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public String getLogoTitle() {
        return logoTitle;
    }

    public void setLogoTitle(String logoTitle) {
        this.logoTitle = logoTitle;
    }

    public ImageInfo getImageInfoLogoNormal() {
        return imageInfoLogoNormal;
    }

    public void setImageInfoLogoNormal(ImageInfo imageInfoLogoNormal) {
        this.imageInfoLogoNormal = imageInfoLogoNormal;
    }

    public ImageInfo getImageInfoLogoMini() {
        return imageInfoLogoMini;
    }

    public void setImageInfoLogoMini(ImageInfo imageInfoLogoMini) {
        this.imageInfoLogoMini = imageInfoLogoMini;
    }

    public String getLogoMiniImageSize() {
        return logoMiniImageSize;
    }

    public void setLogoMiniImageSize(String logoMiniImageSize) {
        this.logoMiniImageSize = logoMiniImageSize;
    }

    public NavHeader getNavHeader() {
        return navHeader;
    }

    public void setNavHeader(NavHeader navHeader) {
        this.navHeader = navHeader;
    }

// </editor-fold>
    public static class Builder {

        private Footer footer;
        private String logoTitle;
//Images Logo
        private ImageInfo imageInfoLogoNormal;
        private ImageInfo imageInfoLogoMini;

        private String logoMiniImageSize;

        //NavHeader Section
        private NavHeader navHeader;

        private Canva canva;
        // Menu
        private MenuBar menuBar;
//TopHeader
        TopHeader topHeader;

        public Builder canva(Canva canva) {
            this.canva = canva;
            return this;
        }
        public Builder topHeader(TopHeader topHeader) {
            this.topHeader = topHeader;
            return this;
        }
       

        public Builder menuBar(MenuBar menuBar) {
            this.menuBar = menuBar;
            return this;
        }

        public Builder imageInfoLogoNormal(ImageInfo imageInfoLogoNormal) {
            this.imageInfoLogoNormal = imageInfoLogoNormal;
            return this;
        }

        public Builder imageInfoLogoMini(ImageInfo imageInfoLogoMini) {
            this.imageInfoLogoMini = imageInfoLogoMini;
            return this;
        }

        public Builder logoMiniImageSize(String logoMiniImageSize) {
            this.logoMiniImageSize = logoMiniImageSize;
            return this;
        }

        /**
         * NavHeader
         *
         * @param navHeaderTitle
         * @return
         */
        public Builder navHeader(NavHeader navHeader) {
            this.navHeader = navHeader;
            return this;
        }

        public Builder footer(Footer footer) {
            this.footer = footer;
            return this;
        }

        public Builder logoTitle(String logoTitle) {
            this.logoTitle = logoTitle;
            return this;
        }

        public Template build() {
            return new Template(footer, logoTitle, imageInfoLogoNormal, imageInfoLogoMini, logoMiniImageSize, navHeader, canva, menuBar,topHeader);

        }

    }
}
