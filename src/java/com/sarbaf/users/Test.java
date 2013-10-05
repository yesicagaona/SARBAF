/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.users;

import com.sarbaf.conn.SentenciaSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UsuarioBean usuariobean=new UsuarioBean();
        Usuario usuario=new Usuario();
        
        usuariobean.setNombre_completo("Fernando Carvajal Cuéllar");
        usuariobean.setCorreo_electronico("ferchop10@hotmail.com");
        usuariobean.setPassword("pass1");
        
//        usuario.borrarUsuario(usuariobean);
        usuario.registrarUsuario(usuariobean);
    }
}
