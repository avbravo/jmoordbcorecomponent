/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.definition;

import java.util.Optional;

/**
 *
 * @author avbravo
 */
public interface ConverterInterface<T> {
     public Optional<T> get(Long id);
     public Optional<T> get(String id);
     public Optional<T> get(Integer id);
}
