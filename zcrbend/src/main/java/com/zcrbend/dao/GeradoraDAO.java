package com.zcrbend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zcrbend.model.Geradora;

public interface GeradoraDAO extends JpaRepository<Geradora, Integer> {

	//Podemos considerar o mesmo principio de implementação de RotaDAO....

}