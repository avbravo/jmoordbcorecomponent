/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import com.avbravo.jmoordbcorecomponent.ImageInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class MenuBar {

    private List<BoxMenu> boxMenus = new ArrayList<>();
    private List<String> roles = new ArrayList<>();
    private String action;
    private String draw;
    

    public MenuBar() {
    }

    public MenuBar(String action, List<BoxMenu> boxMenus,List<String> roles,String draw) {
        this.action = action;
        this.boxMenus = boxMenus;
        this.roles = roles;
        this.draw = draw;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get">

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    
    
    
    public List<BoxMenu> getBoxMenus() {
        return boxMenus;
    }

    public void setBoxMenus(List<BoxMenu> boxMenus) {
        this.boxMenus = boxMenus;
    }
    
    
    
    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    // </editor-fold>
    public static class Builder {

        private List<BoxMenu> boxMenus = new ArrayList<>();
        private String action;
        private String draw;

        List<String> roles = new ArrayList<>();

        public Builder boxMenus(List<BoxMenu> boxMenus) {
            this.boxMenus = boxMenus;
            return this;
        }

        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }
        public Builder action(String action) {
            this.action = action;
            return this;
        }

        public MenuBar build() {
           StringBuilder  leftMenuStringBuilder = new StringBuilder();
           for (BoxMenu boxMenu :boxMenus) {
                leftMenuStringBuilder.append(BoxMenuServices.generateBoxMenu(boxMenu));
            }
           draw = leftMenuStringBuilder.toString();

            return new MenuBar(action, boxMenus, roles,draw);

        }
        
        

    }
}
