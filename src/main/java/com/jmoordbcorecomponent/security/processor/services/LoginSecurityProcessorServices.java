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
public class LoginSecurityProcessorServices {

    // <editor-fold defaultstate="collapsed" desc="String imports(String packagePath)">
    public String imports(String packagePath) {
        String result = "";
        try {
            result = """
import com.avbravo.jmoordbcorecomponent.model.*;
import com.avbravo.jmoordbcorecomponent.utils.*;
import com.avbravo.jmoordbcorecomponent.utils.media.*;
import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
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
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
                           """;
            result += "import " + ProcessorUtil.getPackageNameModel(packagePath) + ".*;\n";
            result += "import " + ProcessorUtil.getPackageNameServices(packagePath) + ".*;\n";
            result += "import " + ProcessorUtil.getPackageNameConfiguration(packagePath) + ".*;\n";
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
    private Boolean isValidApplicative = Boolean.FALSE;
    private Boolean isValidRoles = Boolean.FALSE;
    private Integer contadorIntentos = 0;
    UserCredential userCredential = new UserCredential();
    ProfileStore profie;
    private String selectedOption;
    private String name = "";
    private Profile profileLogged = new Profile();
    private List<Profile> profileLoggeds = new ArrayList<>();
    private Applicativerole applicativeroleLogged = new Applicativerole();
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
    // <editor-fold defaultstate="collapsed" desc="expired()()">

    public String expired() {
        String result = "";
        try {
            result = """
                     // <editor-fold defaultstate="collapsed" desc="String expired()">
                         public String expired() {
                     
                             return "errors/sessionexpired.xhtml?faces-redirect=true";
                     
                         }// </editor-fold>
                     
                    """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="inicializar()">

    public String inicializar() {
        String result = "";
        try {
            result = """

                         // <editor-fold defaultstate="collapsed" desc="String inicializar()">
                         public String inicializar() {
                             contadorIntentos = 0;
                             isLogged = Boolean.FALSE;
                             isValidRoles = Boolean.FALSE;
                     
                             isValidUser = Boolean.FALSE;
                             profileLoggeds = new ArrayList<>();
                             profileLogged = new Profile();
                             HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                             if (session != null) {
                                 session.invalidate();
                             }
                             return "";
                         }
                     // </editor-fold>
                    """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="secretKey()">
    public String secretKey() {
        String result = "";
        try {
            result = """
                     // <editor-fold defaultstate="collapsed" desc="SecretKey()">
                         private String secretKey = "SCox1jmWrkma$*opne2Amwz";
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
                 
                   // <editor-fold defaultstate="collapsed" desc="MicroprofileConfigReader()">
                         @Inject
                         MicroprofileConfigReader mcr;
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
                           public Profile getProfileLogged() {
                                 return profileLogged;
                             }
                         
                             public void setProfileLogged(Profile profileLogged) {
                                 this.profileLogged = profileLogged;
                             }
                         
                             public List<Profile> getProfileLoggeds() {
                                 return profileLoggeds;
                             }
                         
                             public void setProfileLoggeds(List<Profile> profileLoggeds) {
                                 this.profileLoggeds = profileLoggeds;
                             }
                         
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
            result.append("// <editor-fold defaultstate=\"collapsed\" desc=\"set/get()\">");
            result.append("\n/**");
            result.append("\n* * Creates a new instance of " + nameOfClass);
            result.append("\n*/");
            result.append("\n public " + nameOfClass + "(){");
            result.append("}");
            result.append("// </editor-fold>");

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
       try {
           username="";
           password ="";
           userCredential = new UserCredential();
           isLogged = Boolean.FALSE;
           isValidUser = Boolean.FALSE;
           userLogged = new User();
           applicativeroleLogged = new Applicativerole();
           var seconds = Long.parseLong(String.valueOf(facesContext.getExternalContext().getSessionMaxInactiveInterval()));
       } catch (Exception e) {
           FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
       }

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

// <editor-fold defaultstate="collapsed" desc="next()">
    public String next() {
        String result = new String();
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="void next()">

       public String next() {
           try {
               isValidUser = Boolean.FALSE;
               isLogged = Boolean.FALSE;
               profileLogged = new Profile();

               contadorIntentos = 0;
               isLogged = Boolean.FALSE;
               profileLogged = new Profile();
               profileLoggeds = new ArrayList<>();
               /**
                * Busca applicative
                */
               isValidApplicative = searchApplicative();

               if (!isValidApplicative) {
                   FacesUtil.showWarn(rf.fromCore("applicativeconfiguration.restrictivelogin"));
                   return "";
               }

               /**
                * Carga el app configuration
                */
               isValidRoles = validateRoles(rf, applicativeLogged);
               if (!isValidRoles) {
                   return "";
               }

               if (username == null || username.equals("")) {
                   FacesUtil.showWarn(rf.fromCore("warning.usernameisempty"));
                   return "";
               }
               Optional<User> userOptional = userServices.findByUsername(username);
               if (!userOptional.isPresent()) {
                   FacesUtil.showWarn(rf.fromCore("login.usernamenotvalid"));
                   return "";
               }

               userLogged = userOptional.get();
               if (!userLogged.getActive()) {
                   FacesUtil.showWarn(rf.fromCore("login.inactive"));
                   return "";
               }

               profileLoggeds = new ArrayList<>();
               isValidUser = validateProfileUser(profileLoggeds, userLogged, rf, applicativeLogged);
               if (!isValidUser) {
                   return "";
               }
               /**
                * Guarda el contexto de la lista de Profiles
                */
               JmoordbCoreContext.put("LoginFaces.profileLoggeds", profileLoggeds);
               profileLogged = profileLoggeds.get(0);
               return "index.xhtml";

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

    // <editor-fold defaultstate="collapsed" desc="login()">
    public String login() {
        String result = new String();
        try {
            result = """
  // <editor-fold defaultstate="collapsed" desc="String login()">


      public String login() {
          try {
              if (isLogged) {
                  JmoordbCoreContext.put("pageInView", "index.xhtml");
                  return "/" + applicativeLogged.getPath() + "/" + "index.xhmtl";
              }
              isLogged = Boolean.FALSE;
              isLogged = Boolean.FALSE;
              if (password == null || password.equals("")) {
                  FacesUtil.showWarn(rf.fromCore("warning.passwordisempty"));
                  return "";
              }

              if (profileLogged == null || profileLogged.getRole() == null) {
                  FacesUtil.showWarn(rf.fromCore("warning.profilenotselected"));
                  return "";
              }

              /**
               * Validar el password
               */
              // Desencriptar el password de la base de datos
              String encripter = Encryptor.encrypt(password, secretKey);

              String passwordDecrypter = Encryptor.decrypt(userLogged.getPassword(), secretKey, FacesUtil.nameOfClassAndMethod());

              if (passwordDecrypter.equals(password)) {
                  //AplicarIdentityStore
              } else {
                  FacesUtil.showWarn(rf.fromCore("warning.passwordnotmatch"));
                  if (contadorIntentos >= 3) {
                      FacesUtil.showWarn(rf.fromCore("warning.warning"), rf.fromCore("warning.demasiadosintentosfallidoscambiepassword"));

                      return "/olvidopassword.xhtml";
                  }
                  contadorIntentos++;
                  return "";
              }
              JmoordbCoreContext.put("LoginFaces.profileLogged", profileLogged);
              /**
               * Guarda el role en el Context
               */
              if (!validateApplicativeRole(rf, applicativeLogged, profileLogged)) {
                  return "";
              }
         
              JmoordbCoreContext.put("LoginFaces.applicativeroleLogged", applicativeLogged);
              JmoordbCoreContext.put("LoginFaces.applicative", applicativeLogged);

              AuthenticationStatus status = continueAuthentication();
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
                      FacesUtil.showError("Authentication failed");
                      break;
                  case SUCCESS:
                      //Aplica el tema del usuario
                      FacesUtil.showInfo("SUCCESS");
                      isLogged = Boolean.TRUE;
                      JmoordbCoreContext.put("LoginFaces.userLogged", userLogged);
                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(username + " Welcome :" + password + " " + selectedOption));
  //                    return "/" + applicativeroleLogged.getPath() + "/" + "dashboard.xhmtl";
                      return "/" + "dashboard.xhmtl";

                  //    return new CredentialValidationResult(username, new HashSet<>(Arrays.asList(roleForWebSecurity)));
                  //  JmoordbCoreContext.put("LoginFaces.userLogged", userLogged);
                  case NOT_DONE:
                      FacesUtil.showInfo("NOT_DONE");
              }

  //            return "dashboard.xhtml";
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

  public String logout() {
          String path = mcr.getApplicativePath();
          isLogged = Boolean.FALSE;
          System.out.println("[]: " + path);
          return logout(path + "/index.xhtml?faces-redirect=true");

      }
// </editor-fold>
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="logoutPath()">
    public String logoutPath() {
        String result = new String();
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="logout(String path)">
public String logout(String path) {
              Boolean loggedIn = false;
              try {
                  //     String ip = FacesUtil.getIp() == null ? "" : FacesUtil.getIp();
                  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                  if (session != null) {
                      session.invalidate();
                  }

      //            String url = (path);
      //            FacesContext fc = FacesContext.getCurrentInstance();
      //            ExternalContext ec = fc.getExternalContext();
      //            ec.redirect(url);
                  /**
                   *
                   */
                  init();
                  return path;
              } catch (Exception e) {
                  FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
              }
              return path;
}
// </editor-fold>
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="back()">
    public String back() {
        String result = new String();
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="back()">                  
 public String back() {
      try {

          isValidUser = Boolean.FALSE;
      } catch (Exception e) {
          FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
      }
      return "/index.xhtml";
}                          
// </editor-fold>
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="reset()">

    public String reset() {
        String result = new String();
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="reset()">                  
public String reset() {
    try {
        if (emailRecovery == null || emailRecovery.isEmpty() || emailRecovery.isBlank()) {
            FacesUtil.showWarn(rf.getMrb().getString("warning.ingreseemailrecuperacion"));
            return "";
        }
        return "confirmemail.xhtml";
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
    // <editor-fold defaultstate="collapsed" desc="searchApplicative()">

    public String searchApplicative() {
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
                applicativeLogged = applicativeServices.findByIdapplicative(mcr.getIdapplicative().longValue()).get();
                if (applicativeLogged == null || applicativeLogged.getIdapplicative() == null) {
                    applicativeLogged = new Applicative();
                } else {
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
        return result.toString();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="goDashboard()">

    public String goDashboard() {
        String result = new String();
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="Boolean goDashboard()">
    public String goDashboard() {
                try {

                } catch (Exception e) {
                    FacesUtil.showError(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
                }
                return "dashboard";
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
    public String validateApplicativeRole() {
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
public Boolean validateApplicativeRole(JmoordbCoreResourcesFiles rf, Applicative applicativeLogged, Profile profileLogged) {
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
                FacesUtil.showWarn(rf.fromCore("warning.roleapplicativepathempty"));
                result = Boolean.FALSE;
            }
        } else {
            FacesUtil.showWarn(rf.fromCore("warning.roleapplicativenotvalido"));
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
        return result.toString();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="continueAuthentication()">
    public String continueAuthentication() {
        String result = new String();
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="AuthenticationStatus continueAuthentication()">
private AuthenticationStatus continueAuthentication() {
    return securityContext.authenticate(
            (HttpServletRequest) externalContext.getRequest(),
            (HttpServletResponse) externalContext.getResponse(),
            AuthenticationParameters.withParams()
                    .credential(new UsernamePasswordCredential(username, password))
    );
}
// </editor-fold>
                            
                   """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result.toString();
    }
// </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="validateProfileUser()">
    public String validateProfileUser() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="Boolean validateProfileUser(List<Profile> profileLoggeds, User userLogged, JmoordbResourcesFiles rf, Applicative applicative)">
public Boolean validateProfileUser(List<Profile> profileLoggeds, User userLogged, JmoordbCoreResourcesFiles rf, Applicative applicative) {
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
public Boolean validateRoles(JmoordbCoreResourcesFiles rf, Applicative applicativeLogged) {
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
