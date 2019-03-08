/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.general;

import com.oasys.inventario.Productos;
import com.oasys.inventario.Servicios;

/**
 *
 * @author Julian D Osorio G
 */
public abstract class Item {

    public static Item instance(String simpleName) {
        if (simpleName != null) {
            if (simpleName.equalsIgnoreCase(Productos.class.getSimpleName())) {
                return new Productos();
            } else if (simpleName.equalsIgnoreCase(Servicios.class.getSimpleName())) {
                return new Servicios();
            }
        }
        return null;
    }

}
