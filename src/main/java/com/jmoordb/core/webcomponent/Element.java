/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.core.webcomponent;

import java.util.*;

public class Element implements Component {

    private final String name;
    private final List<Component> childs = new ArrayList<>();
    private final Map<String, String> attributes = new HashMap<>();

    public Element(String name) {
        this.name = name;
    }

    // --- Métodos de Chaining Fluido (El "Framework") ---
    public Element withChild(Component child) {
        childs.add(child);
        return this;
    }

    public Element withText(String text) {
        return withChild(new Text(text));
    }

    public Element withClass(String className) {
        attributes.merge("class", className, (actual, nueva) -> actual + " " + nueva);
        return this;
    }

    public Element withAttribute(String name, String value) {
        attributes.put(name, value);
        return this;
    }

    // --- Implementación del Renderizado ---
    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();

        // 1. Apertura de la etiqueta: <div class="...">
        sb.append("<").append(name);
        attributes.forEach((key, value)
                -> sb.append(" ").append(key).append("=\"").append(value).append("\"")
        );
        sb.append(">");

        // 2. Contenido recursivo (Hijos)
        childs.forEach(child -> sb.append(child.render()));

        // 3. Cierre de la etiqueta: </div>
        sb.append("</").append(name).append(">");

        return sb.toString();
    }

    // Clase interna simple para manejar texto
    private static class Text implements Component {

        private final String content;

        public Text(String content) {
            this.content = content;
        }

        @Override
        public String render() {
            return content;
        }
    }
}
