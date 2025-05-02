/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.knob;

/**
 *
 * @author avbravo
 */
//public record Knob (Integer percent, String label, String counter, Boolean uparrow,String color,String id, Integer delay){
public class KnobInfo {

    Integer percent;
    String label;
    String counter;
    String arrow; //up-down
    String color;
    String id;
    Integer delay;

    public KnobInfo() {
    }

    
    
    public KnobInfo(Integer percent, String label, String counter, String arrow, String color, String id, Integer delay) {
        this.percent = percent;
        this.label = label;
        this.counter = counter;
        this.arrow = arrow;
        this.color = color;
        this.id = id;
        this.delay = delay;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getArrow() {
        return arrow;
    }

    public void setArrow(String arrow) {
        this.arrow = arrow;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public static class Builder {

        Integer percent;
        String label;
        String counter;
        String arrow; //up-down
        String color;
        String id;
        Integer delay;

        public Builder percent(Integer percent) {
            this.percent = percent;
            return this;
        }

        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder counter(String counter) {
            this.counter = counter;
            return this;
        }
        public Builder arrow(String arrow) {
            this.arrow = arrow;
            return this;
        }
        public Builder color(String color) {
            this.color = color;
            return this;
        }
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder delay(Integer delay) {
            this.delay = delay;
            return this;
        }

        public KnobInfo build() {
            return new KnobInfo(percent, label, counter, arrow, color, id, delay);

        }

    }
}
