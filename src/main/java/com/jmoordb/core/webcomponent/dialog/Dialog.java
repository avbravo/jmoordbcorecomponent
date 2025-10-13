/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.core.webcomponent.dialog;

/**
 *
 * @author avbravo
 */

import com.jmoordb.core.webcomponent.Component;
import com.jmoordb.core.webcomponent.Element;


public class Dialog implements Component {
    private final String mensaje;
    private final String tipo; // success, danger, warning, info
    private final boolean autoCerrar;

    /**
     * Constructor para generar un mensaje de alerta de Bootstrap.
     * @param mensaje El texto del mensaje.
     * @param tipo El tipo de alerta (ej. "success", "danger").
     * @param autoCerrar Si debe incluir el botón de cierre (x).
     */
    public Dialog(String mensaje, String tipo, boolean autoCerrar) {
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.autoCerrar = autoCerrar;
    }

    @Override
    public String render() {
        // Clases de Bootstrap: alert y alert-[tipo]
        Element alerta = new Element("div")
            .withClass("alert alert-" + tipo + " alert-dismissible fade show")
            .withAttribute("role", "alert");
        
        // Contenido del mensaje
        alerta.withText(mensaje);

        // Añadir botón de cierre si se solicita
        if (autoCerrar) {
            Element botonCerrar = new Element("button")
                .withAttribute("type", "button")
                .withClass("btn-close")
                .withAttribute("data-bs-dismiss", "alert")
                .withAttribute("aria-label", "Close");
            
            alerta.withChild(botonCerrar);
        }

        return alerta.render();
    }
}