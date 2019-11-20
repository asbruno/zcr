package com.zcrbend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServiceAbstract<MODEL, DAO extends JpaRepository<MODEL,?>> implements IService<MODEL> {

	@Autowired
	protected DAO dao;
	
	public List<MODEL> carregarTodos() {
		return dao.findAll();
	}

	public MODEL gravar(MODEL pModel) {		
		return dao.save(pModel);
	}
	
}