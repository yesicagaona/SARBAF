/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.conn;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fernando
 */
public class SentenciaSQL {

    private Statement st;
    private ConectarDB conn;

    public SentenciaSQL() {
        st = null;
        conn = new ConectarDB();
        conn.conectar();
    }

    public int ejecutarSql(String SQL) {
        if(conn.getConexion()!=null) {
            try {
                st = (Statement) conn.getConexion().createStatement();
                return st.executeUpdate(SQL);
            } catch (SQLException ex) {
                System.out.println("|----> Error en SentenciaSQL.ejecutarSql() \n"+ex);
                return -1;
            }
        }else{
            return 0;
        }
    }

    public ResultSet ejecutarSelect(String SQL) {
        try {
            //conn.conectar();
            st = (Statement) conn.getConexion().createStatement();
            return st.executeQuery(SQL);
            //conn.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("|----> Error en SentenciaSQL.ejecutarSelect() \n"+ex);
        }
        return null;
    }

    public void closeSentencia() {
        try {
            st.close();
            System.out.println("|----> Cerrando Statement . . . . OK");
        } catch (SQLException ex) {
            System.out.println("|----> Error en SentenciaSQL.closeSentencia() \n"+ex);
        }
    }

    public void closeConexion() {
        conn.cerrarConexion();
    }
}