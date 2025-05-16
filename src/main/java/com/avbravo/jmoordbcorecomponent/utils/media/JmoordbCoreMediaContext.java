/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcorecomponent.utils.media;

import com.avbravo.jmoordbcorecomponent.utils.FacesUtil;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;

import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class JmoordbCoreMediaContext  implements Serializable {
// <editor-fold defaultstate="collapsed" desc="field">
        private static final long serialVersionUID = 1L;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void put(String key, Object value)">
    /**
     * guarda en el session
     * @param key
     * @param value 
     */
    public static void put(String key, Object value) {
        try{
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
        }catch(Exception e){
          FacesUtil.showError(FacesUtil.nameOfMethod() + " " + e.getLocalizedMessage());
        }  
      
       
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="putApplication()">
    public static void putApplication(String key, Object value) {
        try{
             FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
        }catch(Exception e){
        FacesUtil.showError(FacesUtil.nameOfMethod() + " " + e.getLocalizedMessage());
        }  
      
       
    }
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Object get(String key)">
    public static Object get(String key) {
        try{
             return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
        }catch(Exception e){
        FacesUtil.showError(FacesUtil.nameOfMethod() + " " + e.getLocalizedMessage());
        }  
      
       return "";
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Object getApplication(String key)">
    /**
     * GetApplication obtiene el valor del application
     * @param key
     * @return 
     */
    public static Object getApplication(String key) {
        try{
             return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
        }catch(Exception e){
           FacesUtil.showError(FacesUtil.nameOfMethod() + " " + e.getLocalizedMessage());
        }  
      
       return "";
    }
    // </editor-fold>
}
