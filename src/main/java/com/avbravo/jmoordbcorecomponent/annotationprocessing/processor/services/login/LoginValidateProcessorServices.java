/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.services.login;

import com.avbravo.jmoordbcorecomponent.utils.ProcessorUtil;

/**
 *
 * @author avbravo
 */
public class LoginValidateProcessorServices {

    // <editor-fold defaultstate="collapsed" desc="String imports(String packagePath)">
    public String imports(String packagePath) {
        String result = "";
        try {

            result = """
 import java.util.List;
 import java.util.Optional;
 import jakarta.enterprise.context.ApplicationScoped;
 import com.avbravo.jmoordbcorecomponent.utils.FacesUtil;
 import com.avbravo.jmoordbcorecomponent.utils.JmoordbCoreResourcesFiles;
                           """;
            result += "import " + ProcessorUtil.getPackageNameModel(packagePath) + ".*;\n";

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String methods()">
        public String methods() {
        String result = "";
        try {
            result = """
 public String login();

 public String logout();

 public String next();

 public String back();

 public String reset();
                    """;
        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="validateProfileUser()">
    public String validateProfileUser() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="Boolean validateProfileUser(List<Profile> profileLoggeds, User userLogged, JmoordbResourcesFiles rf, Applicative applicative)">
default Boolean validateProfileUser(List<Profile> profileLoggeds, User userLogged, JmoordbCoreResourcesFiles rf, Applicative applicative) {
    Boolean result = Boolean.FALSE;
    try {
        if (userLogged == null || userLogged.getIduser() == null) {
            FacesUtil.showWarn(rf.fromCore("login.usernamenotvalid"));
            return result;
        } else {
            if (!userLogged.getActive()) {
                FacesUtil.showWarn(rf.fromCore("login.userinactive"));
                return result;
            }
            if (userLogged.getProfile() == null || userLogged.getProfile().isEmpty()) {
                FacesUtil.showWarn(rf.fromCore("login.nothaveprofile"));
                return result;
            }
            /**
             * Recorrer el profile y asignarle un valor secuencial a id
             */
            Long counter = 0L;
            if (applicative.getApplicativerole() == null || applicative.getApplicativerole().isEmpty()) {
            } else {
                for (Applicativerole applicativerole : applicative.getApplicativerole()) {
                    if (applicativerole.getActive()) {
                        for (Profile p : userLogged.getProfile()) {
                            if (p.getApplicativeView().getIdapplicative().equals(applicative.getIdapplicative()) && applicativerole.getIdrole().equals(p.getRole().getIdrole()) && p.getActive()) {
                                counter++;
                                p.setId(counter);
                                profileLoggeds.add(p);
                            }
                        }
                    }
                }
            }
            if (profileLoggeds == null || profileLoggeds.isEmpty()) {
                FacesUtil.showWarn(rf.fromCore("login.usernohaveprofileforthisapplicative"));
                return result;
            }
            result = Boolean.TRUE;
        }
    } catch (Exception e) {
        FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
    }
    return result;
}

// </editor-fold>                   
                     """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="validateRoles()">

    public String validateRoles() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="Boolean validateRoles()">
    /**
     * Valida los roles del applicativo
     *
     * @return
     */
    default Boolean validateRoles(JmoordbCoreResourcesFiles rf, Applicative applicativeLogged) {
        Boolean result = Boolean.FALSE;
        try {
            if (applicativeLogged.getApplicativerole() == null || applicativeLogged.getApplicativerole().isEmpty()) {
                FacesUtil.showWarn(rf.fromCore("applicative.nohaverole"));
                return Boolean.FALSE;
            }
            Optional<Applicativerole> haveActive = applicativeLogged.getApplicativerole().stream()
                    .filter(num -> num.getActive()) // Filtrar números mayores que 10
                    .findFirst();            // Obtener el primer elemento que cumple

            // Verificar si se encontró un resultado
            if (haveActive.isPresent()) {
                result = Boolean.TRUE;
            } else {
                FacesUtil.showWarn(rf.fromCore("applicative.nohaveactiverole"));
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
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
