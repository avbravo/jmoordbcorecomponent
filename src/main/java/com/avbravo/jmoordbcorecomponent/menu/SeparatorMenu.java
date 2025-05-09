/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

/**
 *
 * @author avbravo
 */
public class SeparatorMenu {


 
    public SeparatorMenu() {
    }

  
    
    // <editor-fold defaultstate="collapsed" desc="BoxMenu toBoxMenu()">
    public BoxMenu toBoxMenu() {
       return new BoxMenu().add(this);
    }
   // </editor-fold>

 
    
    // <editor-fold defaultstate="collapsed" desc="Builder">

    public static class Builder{


        public SeparatorMenu build() {
            return new SeparatorMenu();

        }

    }
    // </editor-fold>
}
