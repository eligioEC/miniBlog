package com.casio.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.casio.dao.IPersonaDAO;
import com.casio.model.Persona;

@Stateless//Named simple jpa
public class PersonaDAOImpl implements IPersonaDAO, Serializable{
	
	@PersistenceContext(unitName = "miniblogPU")
	private EntityManager em;
	
	//private EntityManagerFactory emf;
	//private EntityManager em;
	
	/*@PostConstruct
	public void init() {
		emf = Persistence.createEntityManagerFactory("blogDS");
		em = emf.createEntityManager();
	}*/
	

	@Override
	public Integer registrar(Persona per) throws Exception {
		try {
			//em.getTransaction().begin();
			em.persist(per);	
			//em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//em.getTransaction().rollback();
		}
		
		return per.getIdPersona();
	}

	@Override
	public Integer modificar(Persona per) throws Exception {
		em.merge(per);
		return 1;
	}

	@Override
	public Integer eliminar(Persona per) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> listar() throws Exception {
		List<Persona> lista = new ArrayList<Persona>();
		
		try {
			Query query = em.createQuery("SELECT p FROM Persona p");
			lista = (List<Persona>)query.getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return lista;
		
	}

	@Override
	public Persona listarPorId(Persona per) throws Exception {
		Persona persona = new Persona();
		List<Persona> lista = new ArrayList<>();
		try {
			Query query = em.createQuery("FROM Persona p WHERE p.idPersona = ?1");
			query.setParameter(1,per.getIdPersona());
			lista = (List<Persona>)query.getResultList();
			
			if(lista != null && !lista.isEmpty()) {
				persona = lista.get(0);
			}
			
		}catch(Exception e) {
			throw e;
		}
		
		return persona;
	}

}
