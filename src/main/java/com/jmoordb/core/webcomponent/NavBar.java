/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.core.webcomponent;

import com.jmoordb.core.webcomponent.menu.MenuLink;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class NavBar implements Component {

    private final String usuario;
    private final HttpServletRequest request;
    private final List<MenuLink> menuLinks; // ⬅️ Nuevo atributo para las opciones del menú

    /**
     * Constructor para generar el Navbar con opciones de menú.
     *
     * @param usuario El nombre del usuario logeado.
     * @param request El objeto HttpServletRequest para obtener el ContextPath.
     * @param menuLinks La lista de MenuLink a renderizar en el menú principal.
     */
    public NavBar(String usuario, HttpServletRequest request, List<MenuLink> menuLinks) {
        this.usuario = usuario;
        this.request = request;
        this.menuLinks = menuLinks;
    }

    @Override
    public String render() {
        String contextPath = request.getContextPath();

        // 1. Estructura principal del Navbar
        Element navBar = new Element("nav")
                .withClass("navbar navbar-expand-lg navbar-dark bg-dark")
                .withChild(new Element("div").withClass("container-fluid"));

        // Contenedor interno
        Element container = new Element("div").withClass("container-fluid");

        // Marca principal y logo
        container.withChild(new Element("a").withClass("navbar-brand ms-5")
                .withAttribute("href", contextPath + "/dashboard")
                .withText("App Java Puro"));

        // Contenedor para el menú de navegación (ul)
        Element menuUl = new Element("ul").withClass("navbar-nav me-auto mb-2 mb-lg-0");

        // 2. Generar dinámicamente las opciones del menú
        menuLinks.forEach(link -> {
            String activeClass = link.isActive() ? "active" : "";
            Element anchor = new Element("a").withClass("nav-link " + activeClass)
                    .withAttribute("href", contextPath + link.getUrl())
                    .withText(link.getText());

            menuUl.withChild(new Element("li").withClass("nav-item").withChild(anchor));
        });

        container.withChild(menuUl);

        // 3. Elementos de la Derecha (Sesión y Logout)
        container.withChild(new Element("span").withClass("navbar-text ms-auto")
                .withText("Sesión: " + usuario));

        container.withChild(new Element("a").withClass("btn btn-outline-danger ms-3")
                .withAttribute("href", contextPath + "/logout")
                .withText("Salir"));

        navBar.withChild(container);

        return navBar.render();
    }
}
