/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.domains;

/**
 *
 * @author avbravo
 */
public class IdInformation {

    String name;
    String type;
    String simpleName;

    public IdInformation() {
    }

    public IdInformation(String name, String type, String simpleName) {
        this.name = name;
        this.type = type;
        this.simpleName = simpleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public static class Builder {

        String name;
        String type;
        String simpleName;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }
        public Builder simpleName(String simpleName) {
            this.simpleName = simpleName;
            return this;
        }

        public IdInformation build() {
            return new IdInformation(name, type, simpleName);

        }

    }
}
