/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.model;

import com.jmoordb.core.processor.fields.Parametro;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class RestClientServicesMethod {

    private String returnTypeValue;
    private String nameOfMethod;
    private List<Parametro> parametros;

    public RestClientServicesMethod() {
    }

    public RestClientServicesMethod(String returnTypeValue, String nameOfMethod, List<Parametro> parametros) {
        this.returnTypeValue = returnTypeValue;
        this.nameOfMethod = nameOfMethod;
        this.parametros = parametros;
    }

    public String getReturnTypeValue() {
        return returnTypeValue;
    }

    public void setReturnTypeValue(String returnTypeValue) {
        this.returnTypeValue = returnTypeValue;
    }

    public String getNameOfMethod() {
        return nameOfMethod;
    }

    public void setNameOfMethod(String nameOfMethod) {
        this.nameOfMethod = nameOfMethod;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }

    @Override
    public String toString() {
        return "RepositoryMethod{" + "returnTypeValue=" + returnTypeValue + ", nameOfMethod=" + nameOfMethod + ", parametros=" + parametros + '}';
    }

    public static class Builder {

        private String returnTypeValue;

        private String nameOfMethod;
        private List<Parametro> parametros;

        public Builder parametros(List<Parametro> parametros) {
            this.parametros = parametros;
            return this;
        }

        public Builder returnType(String returnTypeValue) {
            this.returnTypeValue = returnTypeValue;
            return this;
        }

        public Builder nameOfMethod(String nameOfMethod) {
            this.nameOfMethod = nameOfMethod;
            return this;
        }

        public RestClientServicesMethod build() {
            return new RestClientServicesMethod(returnTypeValue, nameOfMethod, parametros);

        }

    }
}
