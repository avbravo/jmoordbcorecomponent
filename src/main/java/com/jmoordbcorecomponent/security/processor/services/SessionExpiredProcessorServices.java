/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcorecomponent.security.processor.services;

/**
 *
 * @author avbravo
 */
public class SessionExpiredProcessorServices {

    // <editor-fold defaultstate="collapsed" desc="String imports(String packagePath)">
    public String imports(String packagePath) {
        String result = "";
        try {

            result = """
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
                           """;

        } catch (Exception e) {
            System.out.println(" " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

     // <editor-fold defaultstate="collapsed" desc="doFilter()">
    public String doFilter() {
        String result = "";
        try {
            result = """
// <editor-fold defaultstate="collapsed" desc="CredentialValidationResult validate(Credential credential)">

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
        throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    HttpSession session = req.getSession(false);

    if (session == null || session.getAttribute("user") == null) {
        // Sesión expirada o usuario no autenticado
        String ajaxHeader = req.getHeader("Faces-Request");

        if ("partial/ajax".equals(ajaxHeader)) {
            // Para peticiones AJAX
            res.setContentType("text/xml");
            res.getWriter()
                .append("<?xml version=\\"1.0\\" encoding=\\"UTF-8\\"?>")
                .printf("<partial-response><redirect url=\\"%s\\"></redirect></partial-response>", 
                        req.getContextPath() + "/session-expired.xhtml");
        } else {
            // Para peticiones normales
            res.sendRedirect(req.getContextPath() + "/session-expired.xhtml");
        }
    } else {
        chain.doFilter(request, response);
    }
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
