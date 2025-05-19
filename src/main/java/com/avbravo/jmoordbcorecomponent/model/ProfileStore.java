/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.model;

import jakarta.enterprise.inject.Model;

/**
 *
 * @author avbravo
 */
@Model
public  record ProfileStore(Integer id,Integer idrole, Integer iddepartament, String role){      

}
