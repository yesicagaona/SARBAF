/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.conn;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class SentenciaSQL {

    private Statement sentencia;
    private ConectarDB conn;

    public SentenciaSQL() {
        conn=new ConectarDB();
        conn.conectar();
    }

    public void ejecutarSql(String SQL) {
        try {
            //conn.conectar();
            sentencia = (Statement) conn.getConexion().createStatement();
            sentencia.executeUpdate(SQL);
            //conn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(SentenciaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet ejecutarSelect(String SQL) {
        try {
            //conn.conectar();
            sentencia = (Statement) conn.getConexion().createStatement();
            return sentencia.executeQuery(SQL);
            //conn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(SentenciaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void closeSentencia(){
        try {
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(SentenciaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConexion(){
        conn.cerrarConexion();
    }
}