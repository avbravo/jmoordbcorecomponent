/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.model;

import com.avbravo.jmoordbcorecomponent.model.ProfileStore;
import jakarta.enterprise.inject.Model;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Model
public class UserCredential {

    private String username;
    private String password;
    private String emailRecovery;
    private boolean rememberMe;
    private String name;
    private ProfileStore profile;

    public UserCredential(String username, String password, String emailRecovery, boolean rememberMe, String name, ProfileStore profile) {
        this.username = username;
        this.password = password;
        this.emailRecovery = emailRecovery;
        this.rememberMe = rememberMe;
        this.name = name;
        this.profile = profile;
    }

  

    public UserCredential() {
    }

    
    // <editor-fold defaultstate="collapsed" desc="set/get()">

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailRecovery() {
        return emailRecovery;
    }

    public void setEmailRecovery(String emailRecovery) {
        this.emailRecovery = emailRecovery;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public ProfileStore getProfile() {
        return profile;
    }

    public void setProfile(ProfileStore profile) {
        this.profile = profile;
    }
    
    // </editor-fold>

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + Objects.hashCode(this.password);
        hash = 83 * hash + Objects.hashCode(this.emailRecovery);
        hash = 83 * hash + (this.rememberMe ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.profile);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserCredential other = (UserCredential) obj;
        if (this.rememberMe != other.rememberMe) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.emailRecovery, other.emailRecovery)) {
            return false;
        }
        return Objects.equals(this.profile, other.profile);
    }
    
    
    
    

}
