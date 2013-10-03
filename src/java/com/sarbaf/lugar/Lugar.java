/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.lugar;

import com.sarbaf.conn.SentenciaSQL;

/**
 *
 * @author fernando
 */
public class Lugar {

    private SentenciaSQL sent_sql;

    public Lugar() {
        sent_sql = null;
    }

    public void ingresarLugar(LugarBean lugar) {
        sent_sql = new SentenciaSQL();

        int resultado = sent_sql.ejecutarSql("insert into lugar (descripcion,fecha,hora,direccion,coordenada)"
                + " values ('" + lugar.getDescripcion() + "','" + lugar.getFecha()
                + "','" + lugar.getHora() + "','" + lugar.getDireccion() + "','" + lugar.getCoordenada() + "')");
        sent_sql.closeSentencia();
        sent_sql.closeConexion();
        if (resultado == 1) {
            System.out.println("|----> El lugar ha sido registrado . . . . OK");
//            System.out.println("|----> Elemento insertado en la BD . . . . . OK");
        } else if (resultado == 0) {
            System.out.println("|----> El lugar no ha sido registrado . . . . .");
        } else {
            System.out.println("|----> Se generó un error al intentar registrar el lugar . . . . FAIL");
        }
    }
}
