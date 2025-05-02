/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent;

/**
 *
 * @author avbravo
 */
public class HrefInfo {

    private String href;
    private String text;
    private String minText;

    public HrefInfo() {
    }

    public HrefInfo(String href, String text,String minText) {
        this.href = href;
        this.text = text;
        this.minText = minText;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">

    public String getMinText() {
        return minText;
    }

    public void setMinText(String minText) {
        this.minText = minText;
    }
    
    
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
// </editor-fold>

    public static class Builder {

        private String href;
        private String text;
          private String minText;

        public Builder href(String href) {
            this.href = href;
            return this;
        }
        public Builder minText(String minText) {
            this.minText = minText;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public HrefInfo build() {
            return new HrefInfo(href, text,minText);

        }
    }

}
