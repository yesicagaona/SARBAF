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

        lugarbean.setDescripcion("Lugar 5");
        lugarbean.setFecha("20/12/13");
        lugarbean.setHora("10:14 am");
        lugarbean.setDireccion("dir 5");
        lugarbean.setCoordenada("coordenadas5");

        lugar.ingresarLugar(lugarbean);
    }
}
