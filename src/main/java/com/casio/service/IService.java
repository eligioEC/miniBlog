package com.casio.service;

import java.util.List;

import com.casio.model.Persona;

public interface IService <T>{
	Integer registrar(T t) throws Exception;
	Integer modificar(T t) throws Exception;
	Integer eliminar(T t) throws Exception;
	List<T> listar() throws Exception;
	T listarPorId(T t) throws Exception;


}
