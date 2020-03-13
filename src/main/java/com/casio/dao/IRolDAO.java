package com.casio.dao;

import java.util.List;

import javax.ejb.Local;

import com.casio.model.Rol;
import com.casio.model.Usuario;
import com.casio.model.UsuarioRol;

@Local
public interface IRolDAO extends ICRUD<Rol> {
	
	Integer asignar(Usuario us, List<UsuarioRol> roles);

}
