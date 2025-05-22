/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcorecomponent.security.processor.services;

/**
 *
 * @author avbravo
 */
public class SecurityListenerProcessorServices {

    // <editor-fold defaultstate="collapsed" desc="String imports(String packagePath)">
    public String imports(String packagePath) {
        String result = "";
        try {

            result = """
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.io.Serializable;
import java.util.Date;
                           """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String fields()">
    public String fields() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="fields">
private static final long serialVersionUID = 1L;                     
                     
// </editor-fold>
                                         """;
        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="sessionCreated()">
    public String sessionCreated() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="void sessionCreated(HttpSessionEvent se)">

@Override
public void sessionCreated(HttpSessionEvent se) {
    System.out.println("********************************************************************");
    System.out.println("Session created : " + se.getSession().getId() + " at " + new Date());
    System.out.println("********************************************************************");
}

// </editor-fold>               
                     """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="sessionDestroyed()">
    public String sessionDestroyed() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="void sessionDestroyed(HttpSessionEvent se)">
 @Override
public void sessionDestroyed(HttpSessionEvent se) {
    HttpSession session = se.getSession();
    System.out.println("********************************************************************");
    System.out.println("session destroyed :" + session.getId() + " Logging out user... at  " + new Date());
    System.out.println("********************************************************************");
}
// </editor-fold>               
                     """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

}
