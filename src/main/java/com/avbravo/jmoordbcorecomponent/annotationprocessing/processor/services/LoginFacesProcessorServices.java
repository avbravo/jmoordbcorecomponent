/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.annotationprocessing.processor.services;

import javax.tools.Diagnostic;

/**
 *
 * @author avbravo
 */
public class LoginFacesProcessorServices {

    // <editor-fold defaultstate="collapsed" desc="String imports()">
    public String imports() {
        String result = "";
        try {
            result = """
                           import com.avbravo.jmoordbcorecomponent.security.LoginSecurity;
                           import jakarta.security.enterprise.SecurityContext;
                           import jakarta.annotation.PostConstruct;
                           import jakarta.annotation.PreDestroy;
                           import jakarta.inject.Named;
                           import jakarta.enterprise.context.SessionScoped;
                           import jakarta.faces.application.FacesMessage;
                           import jakarta.faces.context.ExternalContext;
                           import jakarta.faces.context.FacesContext;
                           import jakarta.inject.Inject;
                           import jakarta.inject.Provider;
                           import jakarta.security.enterprise.AuthenticationStatus;
                           import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
                           import jakarta.security.enterprise.credential.UsernamePasswordCredential;
                           import jakarta.servlet.http.HttpServletRequest;
                           import jakarta.servlet.http.HttpServletResponse;
                           import jakarta.validation.constraints.NotNull;
                           import java.io.Serializable;
                           import org.eclipse.microprofile.config.Config;
                           import org.eclipse.microprofile.config.inject.ConfigProperty;
                           """;
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
                     @SessionScoped
                    """;
        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="fields()">
    public String fields() {
        String result = "";
        try {
            result = """
                    // <editor-fold defaultstate="collapsed" desc="fields">
                    
                        private static final long serialVersionUID = 1L;
                    
                        private Applicative applicativeLogged = new Applicative();
                    
                        @NotNull
                        private String username;
                        private String password;
                    
                        private String emailRecovery;
                    
                        @NotNull
                        private boolean rememberMe;
                    
                        @NotNull
                        private User userLogged = new User();
                        /**
                         *
                         */
                        private Boolean isLogged = Boolean.FALSE;
                        private Boolean isValidUser = Boolean.FALSE;
                    
                        UserCredential userCredential = new UserCredential();
                        ProfileStore profie;
                        private String selectedOption;
                        private String name = "";
                    // </editor-fold>
                    
                    """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="services()">

    public String services() {
        String result = "";
        try {
            result = """
                      // <editor-fold defaultstate="collapsed" desc="@Services">
                        @Inject
                        ApplicativeServices applicativeServices;
                        @Inject
                        UserServices userServices;
                    // </editor-fold>
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
                   // <editor-fold defaultstate="collapsed" desc="@Inject">
                         @Inject
                         App app;
                     
                         @Inject
                         JmoordbCoreMediaManager jmoordbCoreMediaManager;
                         @Inject
                         JmoordbCoreMediaContext jmoordbCoreMediaContext;
                     
                         @Inject
                         private SecurityContext securityContext;
                     
                         @Inject
                         private FacesContext facesContext;
                     
                         @Inject
                         private ExternalContext externalContext;
                     
                         @Inject
                         JmoordbCoreResourcesFiles rf;
                     // </editor-fold>
                    """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="microprofileConfig()">
    public String microprofileConfig() {
        String result = "";
        try {
            result = """
                 
                     // <editor-fold defaultstate="collapsed" desc="Microprofile Config">
                         @Inject
                         private Config config;
                         @Inject
                         @ConfigProperty(name = "idapplicative")
                         private Provider<Integer> idapplicative;
                     
                         @Inject
                         @ConfigProperty(name = "applicativeURL")
                         private Provider<String> applicativeURL;
                         // </editor-fold>   
                    """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="setGet()">

    public String setGet() {
        String result = "";
        try {
            result = """
                      // <editor-fold defaultstate="collapsed" desc="set/get()">
                             public User getUserLogged() {
                                 return userLogged;
                             }
                         
                             public void setUserLogged(User userLogged) {
                                 this.userLogged = userLogged;
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
                         
                             public Boolean getIsLogged() {
                                 return isLogged;
                             }
                         
                             public void setIsLogged(Boolean isLogged) {
                                 this.isLogged = isLogged;
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
                         
                             public ProfileStore getProfie() {
                                 return profie;
                             }
                         
                             public void setProfie(ProfileStore profie) {
                                 this.profie = profie;
                             }
                         
                             public UserCredential getUserCredential() {
                                 return userCredential;
                             }
                         
                             public void setUserCredential(UserCredential userCredential) {
                                 this.userCredential = userCredential;
                             }
                         
                             public String getSelectedOption() {
                                 return selectedOption;
                             }
                         
                             public void setSelectedOption(String selectedOption) {
                                 this.selectedOption = selectedOption;
                             }
                         
                             public String getName() {
                                 return name;
                             }
                         
                             public void setName(String name) {
                                 this.name = name;
                             }
                         
                             public Boolean getIsValidUser() {
                                 return isValidUser;
                             }
                         
                             public void setIsValidUser(Boolean isValidUser) {
                                 this.isValidUser = isValidUser;
                             }
                         
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
            result.append("\n/**");
            result.append("\n* * Creates a new instance of " + nameOfClass);
            result.append("\n*/");
            result.append("\n public " + nameOfClass + "(){");
            result.append("}");

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="init()">

    public String init() {
        String result = new String();
        try {
            result = """
                    // <editor-fold defaultstate="collapsed" desc="init()">
                    @PostConstruct
                       public void init() {
                           userCredential = new UserCredential();
                           isLogged = Boolean.FALSE;
                           isValidUser = Boolean.FALSE;
                           userLogged = new User();
                           var seconds = Long.parseLong(String.valueOf(facesContext.getExternalContext().getSessionMaxInactiveInterval()));
                           System.out.println("seconds: " + seconds);
                           //var endTime = JmoordbCoreDateUtil.secondsToHourMinuteSecondsTiempo(seconds);
                       }
                   // </editor-fold>
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="preDestroy()">

    public String preDestroy() {
        String result = new String();
        try {
            result = """
                   // <editor-fold defaultstate="collapsed" desc="void preDestroy()">
                           @PreDestroy
                           public void preDestroy() {
                       
                           }
                       
                           // </editor-fold>
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="login()">

    public String login() {
        String result = new String();
        try {
            result = """
                      // <editor-fold defaultstate="collapsed" desc="String login()">
                  
                      @Override
                      public String login() {
                          try {
                  
                              isLogged = Boolean.FALSE;
                              System.out.println("llego al login");
                              System.out.println("<--| username: " + username + " password: " + password + " |-->");
                              // FacesUtil.showWarn(rf.fromCore("warning.usernameisempty"));
                              AuthenticationStatus status = continueAuthentication();
                              System.out.println("status " + status.toString());
                              if (status == null) {
                                  FacesUtil.showWarn("Status es null");
                                  return "";
                              }
                              switch (status) {
                                  case SEND_CONTINUE:
                  
                                      facesContext.responseComplete();
                                      FacesUtil.showWarn("SEND_CONTINUE");
                                      break;
                                  case SEND_FAILURE:
                                      System.out.println("SEND_FAILURE");
                                      FacesUtil.showError("Authentication failed");
                                      break;
                                  case SUCCESS:
                                      //Aplica el tema del usuario
                                      System.out.println("SUCCESS");
                                      FacesUtil.showInfo("SUCCESS");
                                      isLogged = Boolean.TRUE;
                  
                                  //    return new CredentialValidationResult(username, new HashSet<>(Arrays.asList(roleForWebSecurity)));
                                  //  JmoordbCoreContext.put("LoginFaces.userLogged", userLogged);
                                  case NOT_DONE:
                                      FacesUtil.showInfo("NOT_DONE");
                              }
                              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(username + " Welcome :" + password + " " + selectedOption));
                              System.out.println("-----> call dashboard.xhtml");
                              return "dashboard.xhtml";
                  
                          } catch (Exception e) {
                              FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
                          }
                          return "";
                      }
                  // </editor-fold>
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="logout()">
    public String logout() {
        String result = new String();
        try {
            result = """
                    // <editor-fold defaultstate="collapsed" desc="logout()">
                  
                      @Override
                      public String logout() {
                          System.out.println("Logout....");
                          return "";
                      }
                  // </editor-fold>
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="saveToMediaContext()">

    public String saveToMediaContext() {
        String result = new String();
        try {
            result = """
               // <editor-fold defaultstate="collapsed" desc="String saveToMediaContext(String pathOfFile, String... nameOfFile)">
                        public String saveToMediaContext(String pathOfFile, String... nameOfFile) {
                            try {
                                String name = pathOfFile;
                    
                                if (nameOfFile.length != 0) {
                                    name = nameOfFile[0];
                                }
                    
                                if (!pathBaseLinuxAddUserHomeStoreInCollections.get()) {
                                    pathOfFile = FacesUtil.userHome() + pathOfFile;
                    
                                }
                    
                                jmoordbCoreMediaContext.put("pathOfFile", pathOfFile);
                                jmoordbCoreMediaContext.put("nameOfFile", name);
                                jmoordbCoreMediaManager.init();
                            } catch (Exception e) {
                    
                            }
                    
                            return "";
                        }
                        // </editor-fold>
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="repairPathOfFile()">

    public String repairPathOfFile() {
        String result = new String();
        try {
            result = """
                 // <editor-fold defaultstate="collapsed" desc="String repairPathOfFile(String pathOfFile)">
                            public String repairPathOfFile(String pathOfFile) {
                                try {
                                    if (!pathBaseLinuxAddUserHomeStoreInCollections.get()) {
                                        pathOfFile = FacesUtil.userHome() + pathOfFile;
                                    }
                        
                                } catch (Exception e) {
                                    FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
                                }
                        
                                return pathOfFile;
                            }
                        
                            // </editor-fold>
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="onProfileChange()">

    public String onProfileChange() {
        String result = new String();
        try {
            result = """
                 // <editor-fold defaultstate="collapsed" desc=" onProfileChange()">
                                public void onProfileChange() {
                                    try {
                            
                                        if (profileLogged == null || profileLogged.getDepartamentView() == null) {
                                            //No se ha seleccionado departamemto
                                            profileLogged = new Profile();
                                        }
                            
                                    } catch (Exception e) {
                                        FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
                                    }
                            
                                }
                            // </editor-fold>
                            
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="searchApplicative()">

    public String searchApplicative(){
        String result = new String();
        try {
            result = """
                // <editor-fold defaultstate="collapsed" desc="Boolean searchApplicative()">
                                /**
                                 * Consulta medoante un Search
                                 *
                                 * @return
                                 */
                                public Boolean searchApplicative() {
                                    Boolean result = Boolean.FALSE;
                                    try {
                            
                                        applicativeLogged = applicativeServices.findByIdapplicative(idapplicative.get().longValue()).get();
                                        if (applicativeLogged == null || applicativeLogged.getIdapplicative() == null) {
                                            applicativeLogged = new Applicative();
                                        } else {
                                            result = Boolean.TRUE;
                                        }
                                    } catch (Exception e) {
                                        FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
                                    }
                                    return result;
                                }
                                // </editor-fold>
                            
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="validateApplicativeRole()">

    public String validateApplicativeRole(){
        String result = new String();
        try {
            result = """
               // <editor-fold defaultstate="collapsed" desc="Boolean validateApplicativeRole(JmoordbResourcesFiles rf, Applicativerole  applicativeroleLogged, Applicative applicativeLogged, Profile profileLogged)">
                                /**
                                 * Valida el applicative role
                                 *
                                 * @param rf
                                 * @param applicativeroleLogged
                                 * @param applicativeLogged
                                 * @param profileLogged
                                 * @return
                                 */
                                public Boolean validateApplicativeRole(JmoordbResourcesFiles rf, Applicative applicativeLogged, Profile profileLogged) {
                                    Boolean result = Boolean.FALSE;
                                    try {
                            
                                        for (Applicativerole a : applicativeLogged.getApplicativerole()) {
                                            if (a.getIdrole().equals(profileLogged.getRole().getIdrole())) {
                            
                                                if (a.getActive() && profileLogged.getActive()) {
                                                    applicativeroleLogged = a;
                            
                                                    result = Boolean.TRUE;
                            
                                                    break;
                                                }
                                            }
                                        }
                                        if (result) {
                                            if (applicativeLogged.getPath() == null || applicativeLogged.getPath().equals("")) {
                                                FacesUtil.warningMessage(rf.fromCore("warning.roleapplicativepathempty"));
                                                result = Boolean.FALSE;
                                            }
                                        } else {
                                            FacesUtil.warningMessage(rf.fromCore("warning.roleapplicativenotvalido"));
                            
                                        }
                            
                                    } catch (Exception e) {
                                        FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
                            
                                    }
                                    return result;
                                }
                            // </editor-fold>
                            
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
}
