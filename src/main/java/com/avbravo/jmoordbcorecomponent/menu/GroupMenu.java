/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

/**
 *
 * @author avbravo
 */
public class GroupMenu {

    private String miniText;
    private String text;
    private String action;



    public GroupMenu() {
    }

    public GroupMenu(String miniText, String text, String action) {
        this.miniText = miniText;
        this.text = text;
        this.action = action;
    }


    
        // <editor-fold defaultstate="collapsed" desc="set/get">
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
    public static class Builder {

    private String miniText;
    private String text;
    private String action;



        public Builder miniText(String miniText) {
            this.miniText = miniText;
            return this;
        }
      
        public Builder text(String text) {
            this.text = text;
            return this;
        }
        public Builder action(String action) {
            this.action= action;
            return this;
        }

        public GroupMenu build() {
            return new GroupMenu(miniText, text, action);

        }

    }
}
