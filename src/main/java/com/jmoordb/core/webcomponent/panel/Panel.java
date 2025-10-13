/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.core.webcomponent.panel;

/**
 *
 * @author avbravo
 */
import com.jmoordb.core.webcomponent.Component;
import com.jmoordb.core.webcomponent.Element;
import java.util.List;

public class Panel implements Component {

    // El componente de tabla es fijo en el layout de inventario.
    private final Component tabla;

    // Una lista de componentes que se inyectarán en la parte superior (e.g., Mensajes).
    private final List<Component> componentesSuperiores;

    /**
     * Constructor para el panel principal del dashboard.
     *
     * @param tabla El componente de tabla editable a incrustar.
     * @param componentesSuperiores Componentes a colocar antes del layout de
     * filas (e.g., alertas).
     */
    public Panel(Component tabla, List<Component> componentesSuperiores) {
        this.tabla = tabla;
        this.componentesSuperiores = componentesSuperiores;
    }

    @Override
    public String render() {

        Element contenedor = new Element("div").withClass("container mt-4");

        // 1. Inyectar Componentes Superiores (e.g., Mensajes/Alertas)
        if (componentesSuperiores != null) {
            componentesSuperiores.forEach(contenedor::withChild);
        }

        // 2. Título Principal
        contenedor.withChild(new Element("h1").withClass("mb-4").withText("Dashboard de Gestión"));

        // 3. Layout de Filas
        Element row = new Element("div").withClass("row")
                // Tarjeta 1: Ventas Totales (Fija en este diseño)
                .withChild(new Element("div").withClass("col-md-4 mb-4")
                        .withChild(new Element("div").withClass("card bg-info text-white")
                                .withChild(new Element("div").withClass("card-body")
                                        .withChild(new Element("h5").withClass("card-title").withText("Ventas Totales"))
                                        .withChild(new Element("p").withClass("card-text fs-3").withText("$5,400.00")))))
                // Tarjeta 2: Inventario Editable (Inyecta el componente de tabla)
                .withChild(new Element("div").withClass("col-md-8")
                        .withChild(new Element("div").withClass("card shadow-sm")
                                .withChild(new Element("div").withClass("card-header").withText("Inventario Editable"))
                                .withChild(new Element("div").withClass("card-body")
                                        .withChild(this.tabla)))); // ⬅️ Tabla inyectada

        contenedor.withChild(row);

        return contenedor.render();
    }
}
