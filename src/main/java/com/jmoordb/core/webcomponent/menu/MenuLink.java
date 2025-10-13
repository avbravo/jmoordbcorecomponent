/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.core.webcomponent.menu;

/**
 *
 * @author avbravo
 */
public class MenuLink {
    private final String text;
    private final String url;
    private final boolean isActive;

    /**
     * @param texto El texto visible en el menú.
     * @param url La URL a la que apunta.
     * @param isActive Si se debe marcar como activo (para Bootstrap).
     */
    public MenuLink(String text, String url, boolean isActive) {
        this.text = text;
        this.url = url;
        this.isActive = isActive;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public boolean isActive() {
        return isActive;
    }
}
