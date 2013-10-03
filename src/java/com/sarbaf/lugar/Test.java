/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.lugar;

/**
 *
 * @author fernando
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lugar lugar = new Lugar();
        LugarBean lugarbean = new LugarBean();

        lugarbean.setDescripcion("Lugar 1");
        lugarbean.setFecha("02/10/13");
        lugarbean.setHora("09:14 pm");
        lugarbean.setDireccion("dir 1");
        lugarbean.setCoordenada("coordenadas1");

        lugar.ingresarLugar(lugarbean);
    }
}
