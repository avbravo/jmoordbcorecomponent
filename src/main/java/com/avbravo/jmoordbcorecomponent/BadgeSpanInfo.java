/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent;

/**
 *
 * @author avbravo
 */
public class BadgeSpanInfo {

    /*
    Para colocar un BadgeSpan adicional al texto
   label =""/>
       type ="bg-success"/
     */
    private String label;
    private String type;

    public BadgeSpanInfo() {
    }

    public BadgeSpanInfo(String label, String type) {
        this.label = label;
        this.type = type;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
// </editor-fold>

    public static class Builder {

        private String label;
        private String type;

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public BadgeSpanInfo build() {
            return new BadgeSpanInfo(label, type);

        }
    }

}
