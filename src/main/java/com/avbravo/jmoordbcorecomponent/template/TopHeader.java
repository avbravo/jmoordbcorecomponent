/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.template;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class TopHeader {

    private String username;
    private String nombre;
    private String perfil;
    private String action;
    private String profileMenu;
    private String profileMenuAction;
    private String privacySettingMenu;
    private String privacySettingMenuAction;
    private String logoutMenu;
    private String logoutMenuAction;
    private String searchText;
    private String searchValue;
    private TopHeaderLanguage topHeaderLanguageDefault;
    private List<TopHeaderLanguage> topHeaderLanguages = new ArrayList<>();
    private String imageLibraryNotificacion;
    private String imageNameNotificacion;
    private String textNotificacion;
    private List<TopHeaderNotificacion> topHeaderNotificacions;
     private String textMessage;
       private String imageLibraryMessage;
    private String imageNameMessage;
    private List<TopHeaderMessage> topHeaderMessages;

    public TopHeader() {
    }

    public TopHeader(String username, String nombre, String perfil, String action, String profileMenu, String profileMenuAction, String privacySettingMenu, String privacySettingMenuAction, String logoutMenu, String logoutMenuAction, String searchText, String searchValue, TopHeaderLanguage topHeaderLanguageDefault, List<TopHeaderLanguage> topHeaderLanguages,String imageLibraryNotificacion, String imageNameNotificacion, String textNotificacion, List<TopHeaderNotificacion> topHeaderNotificacions, String textMessage, String imageLibraryMessage, String imageNameMessage, List<TopHeaderMessage> topHeaderMessages) {
        this.username = username;
        this.nombre = nombre;
        this.perfil = perfil;
        this.action = action;
        this.profileMenu = profileMenu;
        this.profileMenuAction = profileMenuAction;
        this.privacySettingMenu = privacySettingMenu;
        this.privacySettingMenuAction = privacySettingMenuAction;
        this.logoutMenu = logoutMenu;
        this.logoutMenuAction = logoutMenuAction;
        this.searchText = searchText;
        this.searchValue = searchValue;
        this.topHeaderLanguageDefault = topHeaderLanguageDefault;
        this.imageLibraryNotificacion = imageLibraryNotificacion;
        this.imageNameNotificacion = imageNameNotificacion;
        this.textNotificacion = textNotificacion;
        this.topHeaderNotificacions = topHeaderNotificacions;
        this.textMessage = textMessage;
        this.imageLibraryMessage = imageLibraryMessage;
        this.imageNameMessage = imageNameMessage;
        this.topHeaderMessages = topHeaderMessages;
        this.topHeaderLanguages = topHeaderLanguages;
    }

   
    
  

    // <editor-fold defaultstate="collapsed" desc="set/get()">
  public String getTextMessage() {
        return textMessage;
    }
    public String getImageLibraryMessage() {
        return imageLibraryMessage;
    }

    public void setImageLibraryMessage(String imageLibraryMessage) {
        this.imageLibraryMessage = imageLibraryMessage;
    }

    public String getImageNameMessage() {
        return imageNameMessage;
    }

    public void setImageNameMessage(String imageNameMessage) {
        this.imageNameMessage = imageNameMessage;
    }
    
    
    
    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public List<TopHeaderMessage> getTopHeaderMessages() {
        return topHeaderMessages;
    }

    public void setTopHeaderMessages(List<TopHeaderMessage> topHeaderMessages) {
        this.topHeaderMessages = topHeaderMessages;
    }

    public List<TopHeaderNotificacion> getTopHeaderNotificacions() {
        return topHeaderNotificacions;
    }

    public void setTopHeaderNotificacions(List<TopHeaderNotificacion> topHeaderNotificacions) {
        this.topHeaderNotificacions = topHeaderNotificacions;
    }

    public String getImageLibraryNotificacion() {
        return imageLibraryNotificacion;
    }

    public void setImageLibraryNotificacion(String imageLibraryNotificacion) {
        this.imageLibraryNotificacion = imageLibraryNotificacion;
    }

    public String getImageNameNotificacion() {
        return imageNameNotificacion;
    }

    public void setImageNameNotificacion(String imageNameNotificacion) {
        this.imageNameNotificacion = imageNameNotificacion;
    }

    public String getTextNotificacion() {
        return textNotificacion;
    }

    public void setTextNotificacion(String textNotificacion) {
        this.textNotificacion = textNotificacion;
    }

    public List<TopHeaderLanguage> getTopHeaderLanguages() {
        return topHeaderLanguages;
    }

    public void setTopHeaderLanguages(List<TopHeaderLanguage> topHeaderLanguages) {
        this.topHeaderLanguages = topHeaderLanguages;
    }

    public TopHeaderLanguage getTopHeaderLanguageDefault() {
        return topHeaderLanguageDefault;
    }

    public void setTopHeaderLanguageDefault(TopHeaderLanguage topHeaderLanguageDefault) {
        this.topHeaderLanguageDefault = topHeaderLanguageDefault;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getProfileMenuAction() {
        return profileMenuAction;
    }

    public void setProfileMenuAction(String profileMenuAction) {
        this.profileMenuAction = profileMenuAction;
    }

    public String getPrivacySettingMenuAction() {
        return privacySettingMenuAction;
    }

    public void setPrivacySettingMenuAction(String privacySettingMenuAction) {
        this.privacySettingMenuAction = privacySettingMenuAction;
    }

    public String getLogoutMenuAction() {
        return logoutMenuAction;
    }

    public void setLogoutMenuAction(String logoutMenuAction) {
        this.logoutMenuAction = logoutMenuAction;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return perfil;
    }

    public void setRol(String perfil) {
        this.perfil = perfil;
    }

    public String getProfileMenu() {
        return profileMenu;
    }

    public void setProfileMenu(String profileMenu) {
        this.profileMenu = profileMenu;
    }

    public String getPrivacySettingMenu() {
        return privacySettingMenu;
    }

    public void setPrivacySettingMenu(String privacySettingMenu) {
        this.privacySettingMenu = privacySettingMenu;
    }

    public String getLogoutMenu() {
        return logoutMenu;
    }

    public void setLogoutMenu(String logoutMenu) {
        this.logoutMenu = logoutMenu;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Builder()">
    public static class Builder {

        private String username;
        private String nombre;
        private String perfil;
        private String action;
        private String profileMenu;
        private String profileMenuAction;
        private String privacySettingMenu;
        private String privacySettingMenuAction;
        private String logoutMenu;
        private String logoutMenuAction;
        private String searchText;
        private String searchValue;
        private TopHeaderLanguage topHeaderLanguageDefault;
        private List<TopHeaderLanguage> topHeaderLanguages = new ArrayList<>();
        private String imageLibraryNotificacion;
        private String imageNameNotificacion;
        private String textNotificacion;
        private List<TopHeaderNotificacion> topHeaderNotificacions;
            private String textMessage;
                private String imageLibraryMessage;
    private String imageNameMessage;
        private List<TopHeaderMessage> topHeaderMessages;

        public Builder topHeaderMessages(List<TopHeaderMessage> topHeaderMessages) {
            this.topHeaderMessages =topHeaderMessages;
            return this;
        }
        public Builder searchText(String searchText) {
            this.searchText = searchText;
            return this;
        }
        public Builder textMessage(String textMessage) {
            this.textMessage=textMessage;
            return this;
        }
 public Builder imageLibraryMessage(String imageLibraryMessage) {
            this.imageLibraryMessage = imageLibraryMessage;
            return this;
        }

        public Builder imageNameMessage(String imageNameMessage) {
            this.imageNameMessage = imageNameMessage;
            return this;
        }

        public Builder imageLibraryNotificacion(String imageLibraryNotificacion) {
            this.imageLibraryNotificacion = imageLibraryNotificacion;
            return this;
        }

        public Builder imageNameNotificacion(String imageNameNotificacion) {
            this.imageNameNotificacion = imageNameNotificacion;
            return this;
        }

        public Builder textNotificacion(String textNotificacion) {
            this.textNotificacion = textNotificacion;
            return this;
        }

        public Builder topHeaderNotificacions(List<TopHeaderNotificacion> topHeaderNotificacions) {
            this.topHeaderNotificacions = topHeaderNotificacions;
            return this;
        }

        public Builder topHeaderLanguageDefault(TopHeaderLanguage topHeaderLanguageDefault) {
            this.topHeaderLanguageDefault = topHeaderLanguageDefault;
            return this;
        }

        public Builder topHeaderLanguages(List<TopHeaderLanguage> topHeaderLanguages) {
            this.topHeaderLanguages = topHeaderLanguages;
            return this;
        }

        public Builder action(String action) {
            this.action = action;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder searchValue(String searchValue) {
            this.searchValue = searchValue;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder perfil(String perfil) {
            this.perfil = perfil;
            return this;
        }

        public Builder profileMenu(String profileMenu) {
            this.profileMenu = profileMenu;
            return this;
        }

        public Builder profileMenuAction(String profileMenuAction) {
            this.profileMenuAction = profileMenuAction;
            return this;
        }

        public Builder privacySettingMenu(String privacySettingMenu) {
            this.privacySettingMenu = privacySettingMenu;
            return this;
        }

        public Builder privacySettingMenuAction(String privacySettingMenuAction) {
            this.privacySettingMenuAction = privacySettingMenuAction;
            return this;
        }

        public Builder logoutMenu(String logoutMenu) {
            this.logoutMenu = logoutMenu;
            return this;
        }

        public Builder logoutMenuAction(String logoutMenuAction) {
            this.logoutMenuAction = logoutMenuAction;
            return this;
        }

        public TopHeader build() {
            return new TopHeader(username, nombre, perfil, action, profileMenu, profileMenuAction, privacySettingMenu, privacySettingMenuAction, logoutMenu, logoutMenuAction, searchText, searchValue, topHeaderLanguageDefault, topHeaderLanguages, imageLibraryNotificacion, imageNameNotificacion, textNotificacion, topHeaderNotificacions, textMessage, imageLibraryMessage, imageNameMessage, topHeaderMessages);

        }

    }
    // </editor-fold>

}
