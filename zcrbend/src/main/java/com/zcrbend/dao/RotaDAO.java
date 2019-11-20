package com.zcrbend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zcrbend.model.Rota;

//@NamedQueries({
//	@NamedQuery(name = "RotaDAO.nomeMedodo", 
//			query = "SELECT a FROM Rota a WHERE a.id > :cod") })
public interface RotaDAO extends JpaRepository<Rota, Integer> {

	@Transactional(readOnly = true)
	Rota findByDescricao(String descricao);
	
	/*
	 * Se necessario podemos explorar as @NamedQueries.... Conforme exemplo comentado.
	 */
	
	//List<Rota> nomeMedodo (@Param("cod") cod)
	
	//Page<Rota> nomeMedodo (@Param("cod") cod, Pageable pageabl)
	
}