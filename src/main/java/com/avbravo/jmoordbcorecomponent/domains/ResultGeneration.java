/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.domains;

/**
 *
 * @author avbravo
 * Devuelve el estado de metodos que tiene varios procesos.
 */
public class ResultGeneration {
    Boolean successful;
    String message;


    public ResultGeneration() {
    }

    public ResultGeneration(Boolean successful, String message) {
        this.successful = successful;
        this.message = message;

    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    public static class Builder {

          Boolean successful;
    String message;

        public Builder successful(Boolean successful) {
            this.successful= successful;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }
       
        public ResultGeneration build() {
            return new ResultGeneration(successful, message);

        }

    }
}
