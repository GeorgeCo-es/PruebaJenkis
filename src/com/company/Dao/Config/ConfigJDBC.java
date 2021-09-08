package com.company.Dao.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigJDBC {
    private String jdbcDriver;
    private String url;
    private String usuario;
    private String contrasenia;
    private static Connection connection;


    public ConfigJDBC(String jdbcDriver, String url, String usuario, String contrasenia) {
        this.jdbcDriver = jdbcDriver;
        this.url = url;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public ConfigJDBC() {
        jdbcDriver = "org.h2.Driver";
//        url = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'createTable.sql'";
        url = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'createTable.sql'";
        usuario = "sa";
        contrasenia = "";
    }

    public Connection conectarConBD(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection(url, usuario, contrasenia);
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return connection;
    }

}
