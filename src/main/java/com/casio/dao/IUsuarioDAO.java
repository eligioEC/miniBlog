package com.casio.dao;

import javax.ejb.Local;

import com.casio.model.Usuario;

@Local
public interface IUsuarioDAO extends ICRUD<Usuario>{
	
	String traerPassHashed(String us);
	Usuario leerPorNombreUsuario(String us);

}
