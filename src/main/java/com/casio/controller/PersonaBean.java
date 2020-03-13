package com.casio.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.casio.model.Persona;
import com.casio.service.IPersonaService;

@Named
@ViewScoped
public class PersonaBean implements Serializable {
	
	@Inject
	private IPersonaService service;
	private Persona persona;
	private List<Persona> lista;
	//private UploadedFile foto;
	private String tipoDialog;
    
	/*
	public PersonaBean() {
		this.persona = new Persona();
		//this.service = new PersonaServiceImpl();
		//this.listar();
	}*/
	
	@PostConstruct
	public void init() {
		this.persona = new Persona();
		this.listar();
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		
		
			try {
				if(event.getFile() != null) {
					this.persona.setFoto(event.getFile().getContents());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
    }
	public void operar(String accion) {
		try {
			if(accion.equalsIgnoreCase("R")) {
				this.service.registrar(this.persona);
			}else if(accion.equalsIgnoreCase("M")) {
				this.service.modificar(this.persona);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void listar() {
		try {
			this.lista = this.service.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarData(Persona p) {
		this.persona = p;
		this.tipoDialog = "Modificar Persona";
	}
	
	public void limpiarControles() {
		this.persona = new Persona();
		this.tipoDialog = "Nueva Persona";
	}
	
	public List<Persona> getLista() {
		return lista;
	}

	public void setLista(List<Persona> lista) {
		this.lista = lista;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
/*
	public UploadedFile getFoto() {
		return foto;
	}

	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}*/

	public String getTipoDialog() {
		return tipoDialog;
	}

	public void setTipoDialog(String tipoDialog) {
		this.tipoDialog = tipoDialog;
	}
	
	
	
	
	
	

}
