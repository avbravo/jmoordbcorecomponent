/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.jmoordb.core.processor.fields;

import com.jmoordb.core.annotation.enumerations.ParamType;

/**
 *
 * @author avbravo
 * Se utiliza para almacenar los parametros de los métodos
 */
public class Parametro {


    private String type;
    private String name;
    public Parametro() {
    }

    public Parametro( String type, String name) {

        this.type = type;
        this.name = name;
      
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parametro{");
        sb.append("type=").append(type);
        sb.append(", name=").append(name);     
        sb.append('}');
        return sb.toString();
    }

    
    
    
   
  

    
    
    
    
    public static class Builder {


        private String name;
        private String type;
        

      
        public Builder name(String name){
            this.name= name;
            return this;
        }
        public Builder type(String type){
            this.type= type;
            return this;
        }
        
        public  Parametro build(){
            return new Parametro( type, name);
        }

    }
}
