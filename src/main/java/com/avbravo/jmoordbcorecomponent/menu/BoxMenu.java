/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import com.avbravo.jmoordbcorecomponent.ImageInfo;
import com.avbravo.jmoordbcorecomponent.enumerations.TypeMenu;
import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class BoxMenu <T>{
  private T item;
    private String typeMenu;
  
    

    public BoxMenu() {
    }

    public BoxMenu(T item, String typeMenu) {
        this.item = item;
        this.typeMenu = typeMenu;
    }

   
    
   

    // <editor-fold defaultstate="collapsed" desc="set/get">

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

   
   

    
}
