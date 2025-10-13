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
        Element tabla = new Element("table")
            .withClass("table table-striped table-hover table-responsive"); 
        
        // Encabezados
        Element thead = new Element("thead");
        Element trHead = new Element("tr");
        headers.forEach(h -> trHead.withChild(new Element("th").withText(h)));
        thead.withChild(trHead);
        tabla.withChild(thead);

        // Cuerpo (Datos)
        Element tbody = new Element("tbody");
        datos.forEach(fila -> {
            Element trBody = new Element("tr");
            fila.forEach(celda -> {
                // Generar un campo de entrada (input) para simular la edición
                Element input = new Element("input")
                    .withAttribute("type", "text")
                    .withAttribute("value", celda)
                    // Clase de Bootstrap para inputs pequeños
                    .withClass("form-control form-control-sm"); 
                
                trBody.withChild(new Element("td").withChild(input));
            });
            tbody.withChild(trBody);
        });
        tabla.withChild(tbody);

        return tabla.render();
    }
}