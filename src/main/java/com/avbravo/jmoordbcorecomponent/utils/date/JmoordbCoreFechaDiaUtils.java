/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcorecomponent.utils.date;

import java.time.LocalDate;

/**
 *
 * @author avbravo
 */
public class JmoordbCoreFechaDiaUtils {
    private LocalDate date;
    private String letter;
    private String name;

    public JmoordbCoreFechaDiaUtils() {
    }

    public JmoordbCoreFechaDiaUtils(LocalDate date, String letter, String name) {
        this.date = date;
        this.letter = letter;
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
