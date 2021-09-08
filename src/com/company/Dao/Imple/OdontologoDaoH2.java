package com.company.Dao.Imple;

import com.company.Dao.Config.ConfigJDBC;
import com.company.Dao.IDao;
import com.company.Model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private ConfigJDBC configJDBC;
    Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    public OdontologoDaoH2(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = configJDBC.conectarConBD();
        Statement stmt;
        String insertar = "INSERT INTO ODONTOLOGOS(MATRICULA, NOMBRE, APELLIDO) VALUES ("+
        odontologo.getMatricula()+", '"+odontologo.getNombre()+"', '"+odontologo.getApellido()+
                "');";
        try {
            stmt = connection.createStatement();
            stmt.execute(insertar);
            logger.info("agregar el odontologo: "+odontologo);
            stmt.close();
        }catch (SQLException exception){
            logger.error("a ocurrido un error",exception);
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        Connection connection = configJDBC.conectarConBD();
        Statement stmt;
        String select = "SELECT * FROM ODONTOLOGOS";
        List<Odontologo> odontos = new ArrayList<>();
        try{
            logger.info("La lista de datoes es:");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next()){
                odontos.add(new Odontologo(rs.getInt("MATRICULA"), rs.getString("NOMBRE"), rs.getString("APELLIDO")));
            }
            logger.info("La lista de Ods son: "+ odontos);
        }catch (SQLException exception){
            logger.error("ocurrio un error", exception);
        }
        return odontos;
    }

    @Override
    public void mostrarDatos(){
        String query="SELECT * FROM ODONTOLOGOS";
        Connection connection = configJDBC.conectarConBD();
        Statement stmt;
    try{
        logger.info("Mostrando datos");
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println( "Matricula Nombre Apellido");
        while (rs.next()){
            System.out.println(rs.getInt("MATRICULA")+" "+ rs.getString("NOMBRE")+" "+ rs.getString("APELLIDO"));
        }
    }catch (SQLException exception){
        logger.error("ocurrio un error", exception);
    }
}

}
