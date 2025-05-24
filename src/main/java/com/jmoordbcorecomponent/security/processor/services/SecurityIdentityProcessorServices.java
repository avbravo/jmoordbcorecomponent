/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcorecomponent.security.processor.services;

import com.avbravo.jmoordbcorecomponent.utils.ProcessorUtil;

/**
 *
 * @author avbravo
 */
public class SecurityIdentityProcessorServices {

    // <editor-fold defaultstate="collapsed" desc="String imports(String packagePath)">
    public String imports(String packagePath) {
        String result = "";
        try {

            result = """
 import com.avbravo.jmoordbcorecomponent.utils.FacesUtil;
 import com.avbravo.jmoordbcorecomponent.utils.JmoordbCoreResourcesFiles;
 import com.avbravo.jmoordbcorecomponent.utils.JmoordbCoreContext
 import jakarta.inject.Named;
 import jakarta.enterprise.context.ApplicationScoped;
 import jakarta.inject.Inject;
 import jakarta.security.enterprise.credential.Credential;
 import jakarta.security.enterprise.credential.UsernamePasswordCredential;
 import jakarta.security.enterprise.identitystore.CredentialValidationResult;
 import jakarta.security.enterprise.identitystore.IdentityStore;
 import java.util.Arrays;
 import java.util.HashSet;
                           """;
   result += "import " + ProcessorUtil.getPackageNameModel(packagePath) + ".*;\n";
        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="String header()">
    public String header() {
        String result = "";
        try {
            result = """
                     @Named
                     @ApplicationScoped
                    """;
        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

   

    // <editor-fold defaultstate="collapsed" desc="inject()">
    public String inject() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="@Inject()">
    @Inject
    JmoordbCoreResourcesFiles rf;
    private String roleForWebSecurity = " ";                 
// </editor-fold>                  
                     """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

     // <editor-fold defaultstate="collapsed" desc="constructor(String nameOfClass)">
    public String constructor(String nameOfClass) {
        StringBuilder result = new StringBuilder();
        try {
            result.append("\n// <editor-fold defaultstate=\"collapsed\" desc=\""+  nameOfClass+"()\">");
            result.append("\n/**");
            result.append("\n* * Creates a new instance of " + nameOfClass);
            result.append("\n*/");
            result.append("\n public " + nameOfClass + "(){");
            result.append("}\n");
            result.append("// </editor-fold>\n");

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="validate()">
    public String validate() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="CredentialValidationResult validate(Credential credential)">

    @Override
    public CredentialValidationResult validate(Credential credential) {

        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
        String username = login.getCaller();
        String password = login.getPasswordAsString();

        if (!isValidData(username, password)) {

            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }
        /**
         * Obtiene el rol que se obtuvo en el login
         */
        Profile profile = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");
        if (profile == null || profile.getId() == null) {      
           return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }
       roleForWebSecurity = profile.getRole().getRole();

      return new CredentialValidationResult(username, new HashSet<>(Arrays.asList(roleForWebSecurity)));
//        return new CredentialValidationResult(username, new HashSet<>(Arrays.asList("admin")));

    }
//
// </editor-fold>               
                     """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
     // <editor-fold defaultstate="collapsed" desc="isValidData()">
    public String isValidData() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="Boolean isValidData(String username, String password)">
    private Boolean isValidData(String username, String password) {
        try {
            if (username.isEmpty() || username.equals("") || username == null) {
                FacesUtil.showWarn(rf.fromCore("warning.usernameisempty"));
                return false;
            }
            if (password.isEmpty() || password.equals("") || password == null) {
                FacesUtil.showWarn(rf.fromCore("warning.passwordisempty"));
                return false;
            }
            return true;
        } catch (Exception e) {
            FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return false;
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
