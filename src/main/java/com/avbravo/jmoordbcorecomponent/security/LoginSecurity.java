/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.security;

/**
 *
 * @author avbravo
 */
public interface LoginSecurity {
    public String login();
    public String logout();
    public String next();
    public String back();
    public String reset();
    
}
