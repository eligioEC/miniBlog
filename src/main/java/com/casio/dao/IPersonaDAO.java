package com.casio.dao;

import java.util.List;

import javax.ejb.Local;

import com.casio.model.Persona;

@Local //  @remove para trabajar con servicios web
public interface IPersonaDAO extends ICRUD<Persona> {
	
}
