/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcorecomponent.utils.date;

/**
 *
 * Maneja el tiempo de una operacion
 *
 * @author avbravo
 */
public class JmoordbCoreTiempo {

  private  Integer dias = 0;
    private Integer horas = 0;
    private Integer minutos = 0;
    private Integer segundos = 0;

    public JmoordbCoreTiempo() {
    }

    
    
      public JmoordbCoreTiempo(Integer dias, Integer horas, Integer minutos,Integer segundos) {
          this.dias=dias;
          this.horas=horas;
          this.minutos=minutos;
          this.segundos=segundos;
    }

    public Integer getSegundos() {
        return segundos;
    }

    public void setSegundos(Integer segundos) {
        this.segundos = segundos;
    }

    
      
      
    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

}
