package com.company.Service;

import com.company.Dao.IDao;
import com.company.Model.Odontologo;

import java.util.List;

public class OdontoService {

    private IDao<Odontologo> odontologoIDao;
    public OdontoService(IDao<Odontologo> odontologoIDao){this.odontologoIDao=odontologoIDao;}

    public Odontologo guardar(Odontologo odontologo){return odontologoIDao.guardar(odontologo);}
    public List<Odontologo> listar(){return odontologoIDao.listar();}

    public void mostrarDatos(){ odontologoIDao.mostrarDatos();}
}

