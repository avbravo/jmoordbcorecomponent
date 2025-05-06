/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.menu;

/**
 *
 * @author avbravo
 */
public class BoxMenuServices {
    
    
    
     // <editor-fold defaultstate="collapsed" desc="processBoxMenu(BoxMenu boxMenu)">
    public static String generateBoxMenu(BoxMenu boxMenu) {

        StringBuilder sb = new StringBuilder();
        try {
           
            switch (boxMenu.getTypeMenu()) {
                case "GROUPMENU":
                    sb.append(boxMenu.getDraw());
                    for (BoxMenu bm : boxMenu.getGroupMenu().getBoxMenus()) {
                        switch (bm.getTypeMenu()) {
                            case "GROUPMENU":
                                sb.append(boxMenu.getDraw());
                                break;
                            case "SUBMENU":
                               
                                sb.append(bm.getDraw());
                                for (BoxMenu sbm : bm.getSubMenu().getBoxMenus()) {
                                    sb.append(generateBoxMenu(sbm));
                                }

                                sb.append(bm.endSubMenu());
                                break;
                            case "SEPARATORMENU":
                                sb.append(bm.getDraw());
                                break;
                            case "MENUITEM":
                                sb.append(bm.getDraw());
                                break;
                            default:
                                System.out.println("..valor no determinado " + bm.getTypeMenu());
                        }
                    }
                    break;
                case "SUBMENU":
                  
                    sb.append(boxMenu.getDraw());
                    for (BoxMenu sbm : boxMenu.getSubMenu().getBoxMenus()) {
                        sb.append(generateBoxMenu(sbm));
                    }

                    sb.append(boxMenu.endSubMenu());
                    break;
                case "SEPARATORMENU":
                    sb.append(boxMenu.getDraw());
                    break;
                case "MENUITEM":
                    sb.append(boxMenu.getDraw());
                    break;
                default:
                    System.out.println("valor no determinado " + boxMenu.getTypeMenu());
            }
        } catch (Exception e) {
            System.out.println("createMenuBar() " + e.getLocalizedMessage());
        }

        return sb.toString();
    }
// </editor-fold>
}
