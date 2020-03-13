package com.casio.service;

import java.util.List;

import com.casio.model.Rol;
import com.casio.model.Usuario;
import com.casio.model.UsuarioRol;

public interface IRolService extends IService<Rol>{

	Integer asignar(Usuario us, List<Rol> roles);

}
