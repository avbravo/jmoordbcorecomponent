/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.core.webcomponent;

    

import java.util.List;

public class TableEditable implements Component {
    private final List<String> headers;
    private final List<List<String>> datos;

    public TableEditable(List<String> headers, List<List<String>> datos) {
        this.headers = headers;
        this.datos = datos;
    }

    @Override
    public String render() {
        // Clases de Bootstrap: table, table-striped, table-hover, y table-responsive
        Label tabla = new Label("table")
            .withClass("table table-striped table-hover table-responsive"); 
        
        // Encabezados
        Label thead = new Label("thead");
        Label trHead = new Label("tr");
        headers.forEach(h -> trHead.withChild(new Label("th").withText(h)));
        thead.withChild(trHead);
        tabla.withChild(thead);

        // Cuerpo (Datos)
        Label tbody = new Label("tbody");
        datos.forEach(fila -> {
            Label trBody = new Label("tr");
            fila.forEach(celda -> {
                // Generar un campo de entrada (input) para simular la edición
                Label input = new Label("input")
                    .withAttribute("type", "text")
                    .withAttribute("value", celda)
                    // Clase de Bootstrap para inputs pequeños
                    .withClass("form-control form-control-sm"); 
                
                trBody.withChild(new Label("td").withChild(input));
            });
            tbody.withChild(trBody);
        });
        tabla.withChild(tbody);

        return tabla.render();
    }
}