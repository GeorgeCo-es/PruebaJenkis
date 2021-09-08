package com.company.Tests;

import com.company.Dao.Config.ConfigJDBC;
import com.company.Dao.Imple.OdontologoDaoH2;
import com.company.Model.Odontologo;
import com.company.Service.OdontoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontoServiceTest {

    Logger logger = Logger.getLogger(OdontoServiceTest.class);


    @Test
    void testearListas() {
        OdontoService odontoService=new OdontoService(new OdontologoDaoH2(new ConfigJDBC()));
        odontoService.guardar(new Odontologo(123,"PruebaNombre01","PruebaApellido01"));
        odontoService.guardar(new Odontologo(345,"PruebaNombre02","PruebaApellido02"));
        odontoService.guardar(new Odontologo(678,"PruebaNombre03","PruebaApellido03"));

        logger.debug(odontoService.listar().size());
        assertEquals(3,odontoService.listar().size());
    }
}