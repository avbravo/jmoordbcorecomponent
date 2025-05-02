/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.template;

/**
 *
 * @author avbravo
 */
public class Canva {

    private String settings;
    private String scheme;
    private String auto;
    private String dark;
    private String light;
    private String colorCustomizer;
    private String sidebarColor;
    private String defaultLabel;
    private String color;
    private String transparent;

    public Canva() {
    }

    public Canva(String settings, String scheme, String auto, String dark, String light, String colorCustomizer, String sidebarColor, String defaultLabel, String color, String transparent) {
        this.settings = settings;
        this.scheme = scheme;
        this.auto = auto;
        this.dark = dark;
        this.light = light;
        this.colorCustomizer = colorCustomizer;
        this.sidebarColor = sidebarColor;
        this.defaultLabel = defaultLabel;
        this.color = color;
        this.transparent = transparent;
    }
// <editor-fold defaultstate="collapsed" desc="set/get">

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getDark() {
        return dark;
    }

    public void setDark(String dark) {
        this.dark = dark;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getColorCustomizer() {
        return colorCustomizer;
    }

    public void setColorCustomizer(String colorCustomizer) {
        this.colorCustomizer = colorCustomizer;
    }

    public String getSidebarColor() {
        return sidebarColor;
    }

    public void setSidebarColor(String sidebarColor) {
        this.sidebarColor = sidebarColor;
    }

    public String getDefaultLabel() {
        return defaultLabel;
    }

    public void setDefaultLabel(String defaultLabel) {
        this.defaultLabel = defaultLabel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransparent() {
        return transparent;
    }

    public void setTransparent(String transparent) {
        this.transparent = transparent;
    }

// </editor-fold>
    public static class Builder {

        private String settings;
        private String scheme;
        private String auto;
        private String dark;
        private String light;
        private String colorCustomizer;
        private String sidebarColor;
        private String defaultLabel;
        private String color;
        private String transparent;

        public Builder settings(String settings) {
            this.settings = settings;
            return this;
        }
        public Builder scheme(String scheme) {
            this.scheme = scheme;
            return this;
        }
        public Builder auto(String auto) {
            this.auto = auto;
            return this;
        }
        public Builder dark(String dark) {
            this.dark = dark;
            return this;
        }
        public Builder light(String light) {
            this.light = light;
            return this;
        }
        public Builder colorCustomizer(String colorCustomizer) {
            this.colorCustomizer = colorCustomizer;
            return this;
        }
        public Builder sidebarColor(String sidebarColor) {
            this.sidebarColor = sidebarColor;
            return this;
        }
        public Builder defaultLabel(String defaultLabel) {
            this.defaultLabel = defaultLabel;
            return this;
        }
        public Builder color(String color) {
            this.color = color;
            return this;
        }
        public Builder transparent(String transparent) {
            this.transparent = transparent;
            return this;
        }

        public Canva build() {
            return new Canva(settings, scheme, auto, dark, light, colorCustomizer, sidebarColor, defaultLabel, color, transparent);

        }

    }

}
