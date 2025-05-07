/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

import com.avbravo.jmoordbcorecomponent.utils.Messages;

/**
 *
 * @author avbravo
 */
public class BoxMenu {

    private String typeMenu;

    private GroupMenu groupMenu = new GroupMenu();
    private MenuItem menuItem = new MenuItem();
    private MenuItemX menuItemX = new MenuItemX();
    private SeparatorMenu separatorMenu = new SeparatorMenu();
    private SubMenu subMenu = new SubMenu();
    private String draw = new String();

    public BoxMenu() {
    }

    public BoxMenu(GroupMenu groupMenu, MenuItem menuItem, MenuItemX menuItemX,SeparatorMenu separatorMenu, SubMenu subMenu, String typeMenu, String draw) {
        this.typeMenu = typeMenu;
        this.menuItem = menuItem;
        this.groupMenu = groupMenu;
        this.separatorMenu = separatorMenu;
        this.subMenu = subMenu;
        this.draw = draw;
    }

    // <editor-fold defaultstate="collapsed" desc="set/get()">
    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    public GroupMenu getGroupMenu() {
        return groupMenu;
    }

    public void setGroupMenu(GroupMenu groupMenu) {
        this.groupMenu = groupMenu;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public SeparatorMenu getSeparatorMenu() {
        return separatorMenu;
    }

    public void setSeparatorMenu(SeparatorMenu separatorMenu) {
        this.separatorMenu = separatorMenu;
    }

    public SubMenu getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(SubMenu subMenu) {
        this.subMenu = subMenu;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="add(GroupMenu groupMenu)">
    public BoxMenu add(GroupMenu groupMenu) {
        try {
            this.groupMenu = groupMenu;
            this.typeMenu = "GROUPMENU";
            StringBuilder sb = new StringBuilder();
            sb.append("   <li class=\"nav-item static-item\">\n");
            sb.append("        <a class=\"nav-link static-item disabled\" href=\"" + groupMenu.getAction() + "\" tabindex=\"-1\">\n");
            sb.append("            <span class=\"default-icon\">" + groupMenu.getText() + "</span>\n");
            sb.append("            <span class=\"mini-icon\">" + groupMenu.getMiniText() + "</span>\n");
            sb.append("        </a>\n");
            sb.append("   </li>\n");
            this.draw = sb.toString();

        } catch (Exception e) {
            Messages.error(e.getLocalizedMessage());
        }
        return this;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="add(MenuItem menuItem)">
    public BoxMenu add(MenuItem menuItem) {
        try {
            this.menuItem = menuItem;
            this.typeMenu = "MENUITEM";
            StringBuilder sb = new StringBuilder();
            sb.append(" <li class=\"nav-item\">\n");
            sb.append("     <a class=\"nav-link \" href=\"" + menuItem.getHrefInfo().getHref() + "\">\n");
            sb.append("        <i class=\"icon\">\n");
            sb.append("            " + Draw.image(menuItem.getImageInfo()));
            sb.append("        </i>\n");
            sb.append("        <i class=\"sidenav-mini-icon\"> " + menuItem.getHrefInfo().getMinText() + " </i>\n");
            if (menuItem.getBadgeSpanInfo() == null || menuItem.getBadgeSpanInfo().getLabel().equals("")) {
                sb.append("        <span class=\"item-name\"> " + menuItem.getHrefInfo().getText() + "</span>\n");
            } else {
                sb.append("        <span class=\"item-name\"> " + menuItem.getHrefInfo().getText() + " <span class=\"badge rounded-pill " + menuItem.getBadgeSpanInfo().getType() + " item-name\">" + menuItem.getBadgeSpanInfo().getLabel() + "</span> </span>\n");
            }
            sb.append("     </a>\n");
            sb.append(" </li>\n");
            this.draw = sb.toString();
        } catch (Exception e) {
            Messages.error(e.getLocalizedMessage());
        }
        return this;
    }
    // <editor-fold defaultstate="collapsed" desc="add(MenuItemX menuItemX)">
    public BoxMenu add(MenuItemX menuItemX) {
        try {
            this.menuItemX = menuItemX;
            this.typeMenu = "MENUITEM";
            StringBuilder sb = new StringBuilder();
            sb.append(" <li class=\"nav-item\">\n");
            sb.append("     <a class=\"nav-link \" href=\"" + menuItemX.getAction()+ "\">\n");
            sb.append("        <i class=\"icon\">\n");
            sb.append("            " + Draw.image(menuItemX.getImageLibrary(),menuItemX.getImageName()));
            sb.append("        </i>\n");
            sb.append("        <i class=\"sidenav-mini-icon\"> " + menuItemX.getMinText() + " </i>\n");
            if (menuItemX.getBadgeSpanLabel()== null || menuItemX.getBadgeSpanLabel().equals("")) {
                sb.append("        <span class=\"item-name\"> " + menuItemX.getText() + "</span>\n");
            } else {
                sb.append("        <span class=\"item-name\"> " + menuItemX.getText() + " <span class=\"badge rounded-pill " + menuItemX.getBadgeSpanType() + " item-name\">" + menuItemX.getBadgeSpanLabel() + "</span> </span>\n");
            }
            sb.append("     </a>\n");
            sb.append(" </li>\n");
            this.draw = sb.toString();
        } catch (Exception e) {
            Messages.error(e.getLocalizedMessage());
        }
        return this;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="add(SubMenu subMenu)">
    public BoxMenu add(SubMenu subMenu) {
        try {
            this.subMenu = subMenu;
            this.typeMenu = "SUBMENU";
            StringBuilder sb = new StringBuilder();
            sb.append("<li class=\"nav-item\">\n");
            sb.append("     <a class=\"nav-link\" data-bs-toggle=\"collapse\" href=\""+subMenu.getHrefInfo().getHref()+"\" role=\"button\" aria-expanded=\"false\" aria-controls=\""+subMenu.getAriaControls()+"\">\n");
            sb.append("        <i class=\"icon\">\n");
            sb.append("            " + Draw.image(subMenu.getImageInfo()));
                  sb.append("        </i>\n");
            sb.append("       <i class=\"sidenav-mini-icon\"> "+subMenu.getHrefInfo().getMinText()+" </i>\n");
            sb.append("        <span class=\"item-name\">"+subMenu.getHrefInfo().getText()+"</span>\n");
            sb.append("          <i class=\"right-icon\">\n");
            sb.append("       <svg class=\"icon-18\" xmlns=\"http://www.w3.org/2000/svg\" width=\"18\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">\n");
            sb.append("            <path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M9 5l7 7-7 7\" />\n");
            sb.append("      </svg>\n");
            sb.append("     </i>\n");
            sb.append("    </a>\n");
            sb.append("    <ul class=\"sub-nav collapse\" id=\""+subMenu.getAriaControls()+"\" data-bs-parent=\"#sidebar-menu\">\n");
            this.draw = sb.toString();

            
        } catch (Exception e) {
            Messages.error(e.getLocalizedMessage());
        }
        return this;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="String endSubMenu()">
    public String endSubMenu(){
        StringBuilder result = new StringBuilder();
          try {
              result.append("</ul>\n");
              result.append("</li>\n");
            
        } catch (Exception e) {
               Messages.error(e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="add(SeparatorMenu separatorMenu)">
    public BoxMenu add(SeparatorMenu separatorMenu) {
        try {
            this.separatorMenu = separatorMenu;
            this.typeMenu = "SEPARATORMENU";
            StringBuilder sb = new StringBuilder();
            sb.append("   <li><hr class=\"hr-horizontal\"/></li>\n");
            this.draw = sb.toString();
        } catch (Exception e) {
            Messages.error(e.getLocalizedMessage());
        }
        return this;
    }
    // </editor-fold>
    
    

}
