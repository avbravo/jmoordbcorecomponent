/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.domains;

/**
 *
 * @author avbravo
 */
public class RestClientServicesInformation {

    String entity;
    String restClient;
    String restClientVar;

    public RestClientServicesInformation() {
    }

    public RestClientServicesInformation(String entity, String restClient, String restClientVar) {
        this.entity = entity;
        this.restClient = restClient;
        this.restClientVar = restClientVar;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getRestClient() {
        return restClient;
    }

    public void setRestClient(String restClient) {
        this.restClient = restClient;
    }

    public String getRestClientVar() {
        return restClientVar;
    }

    public void setRestClientVar(String restClientVar) {
        this.restClientVar = restClientVar;
    }

    
    public static class Builder {

        String entity;
        String restClient;
        String restClientVar;

        public Builder entity(String entity) {
            this.entity = entity;
            return this;
        }

        public Builder restClient(String restClient) {
            this.restClient = restClient;
            return this;
        }
        public Builder restClientVar(String restClientVar) {
            this.restClientVar = restClientVar;
            return this;
        }

        public RestClientServicesInformation build() {
            return new RestClientServicesInformation(entity, restClient, restClientVar);

        }

    }
}
