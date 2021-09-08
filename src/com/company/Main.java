package com.company;

import com.company.Dao.Config.ConfigJDBC;
import com.company.Dao.Imple.OdontologoDaoH2;
import com.company.Model.Odontologo;
import com.company.Service.OdontoService;

public class Main {

    public static void main(String[] args) {
        OdontoService odontoService=new OdontoService(new OdontologoDaoH2(new ConfigJDBC()));

        odontoService.guardar(new Odontologo(123,"PruebaNombre01","PruebaApellido01"));
        odontoService.guardar(new Odontologo(345,"PruebaNombre02","PruebaApellido02"));
        odontoService.guardar(new Odontologo(678,"PruebaNombre03","PruebaApellido03"));

        odontoService.listar();

        odontoService.mostrarDatos();
    }
}
