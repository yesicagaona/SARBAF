/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.lugar;

import com.sarbaf.conn.SentenciaSQL;
import com.sarbaf.conn.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class Lugar {
    
    public Lugar() {
    }

    public void ingresarLugar(LugarBean lugar) {
        SentenciaSQL st = new SentenciaSQL();
        
        int resultado = st.ejecutarSql("insert into lugar (descripcion,fecha,hora,direccion,coordenada)"
                + " values ('"+lugar.getDescripcion()+"','"+lugar.getFecha()
                + "','"+lugar.getHora()+"','"+lugar.getDireccion()+"','"+lugar.getCoordenada()+"')");
        st.closeSentencia();
        st.closeConexion();
        if (resultado != 0) {
            System.out.println("Elemento insertado en la BD . . . . . OK");
        } else {
            System.out.println("El elemento no se ha sido insertado . . . . . 2");
        }
    }
}
