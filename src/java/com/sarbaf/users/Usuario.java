/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.users;

import com.sarbaf.conn.SentenciaSQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fernando
 */
public class Usuario {

    private SentenciaSQL sent_sql;

    public Usuario() {
        sent_sql = null;
    }

    public void registrarUsuario(UsuarioBean usuario) {
        sent_sql = new SentenciaSQL();
        if (availableCorreousuario(usuario)) {
            int resultado = sent_sql.ejecutarSql("insert into usuario (nombre_completo,correo_electronico,password)"
                    + " values ('" + usuario.getNombre_completo() + "','"
                    + usuario.getCorreo_electronico()
                    + "','" + usuario.getPassword() + "')");
            if (resultado == 1) {
                System.out.println("|----> Usuario registrado . . . . OK");
            } else if(resultado==0){
                System.out.println("|----> Usuario no registrado por causa desconocida . . . . OK");
            }else{
                System.out.println("|----> Se generó un error al intentar ingresar el usuario . . . . FAIL");
            }
        } else {
            System.out.println("|----> El correo electrónico que intenta registrar ya esta en uso.");
        }
        sent_sql.closeSentencia();
        sent_sql.closeConexion();
    }

    public boolean availableCorreousuario(UsuarioBean usuario) {
        ResultSet rs = sent_sql.ejecutarSelect("select correo_electronico from usuario"
                + " where correo_electronico='" + usuario.getCorreo_electronico() + "'");
        if (rs != null) {
            try {
                if (rs.next()) {
                    rs.close(); //cerramos el Resultset.
                    return false;
                }
            } catch (SQLException ex) {
                System.out.println("|----> Error en Usuario.isCorreousuario() \n" + ex);
            }
        }
        return true;
    }

    public void borrarUsuario(UsuarioBean usuario) {
        sent_sql = new SentenciaSQL();
        int resultado = sent_sql.ejecutarSql("delete from usuario where correo_electronico='" + usuario.getCorreo_electronico() + "'");
        if (resultado == 1) {
            System.out.println("|----> Usuario eliminado . . . . OK");
        } else if (resultado == 0) {
            System.out.println("|----> Usuario no encontrado . . . . OK");
        } else {
            System.out.println("|----> Se generó un error al intentar eliminar el usuario . . . . FAIL");
        }
        sent_sql.closeSentencia();
        sent_sql.closeConexion();
    }
}
