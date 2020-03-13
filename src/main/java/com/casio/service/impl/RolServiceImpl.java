package com.casio.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.casio.dao.IRolDAO;
import com.casio.model.Rol;
import com.casio.model.Usuario;
import com.casio.model.UsuarioRol;
import com.casio.service.IRolService;


@Named
public class RolServiceImpl implements IRolService, Serializable{

	@EJB
	private IRolDAO dao;
	
	@Override
	public Integer registrar(Rol t) throws Exception {
		return dao.registrar(t);
	}

	@Override
	public Integer modificar(Rol t) throws Exception {
		return dao.modificar(t);
	}

	@Override
	public Integer eliminar(Rol t) throws Exception {
		return dao.eliminar(t);
	}

	@Override
	public List<Rol> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Rol listarPorId(Rol t) throws Exception {
		return dao.listarPorId(t);
	}

	@Override
	public Integer asignar(Usuario us, List<Rol> roles) {		
		List<UsuarioRol> usuario_roles = new ArrayList<>();
		
		roles.forEach(r -> {
			UsuarioRol ur = new UsuarioRol();
			ur.setUsuario(us);
			ur.setRol(r);
			usuario_roles.add(ur);
		});
		
		return dao.asignar(us, usuario_roles);
	}

}
