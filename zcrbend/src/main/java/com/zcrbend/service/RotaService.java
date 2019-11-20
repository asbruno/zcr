package com.zcrbend.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zcrbend.dao.RotaDAO;
import com.zcrbend.model.Rota;

@Service
public class RotaService extends ServiceAbstract<Rota, RotaDAO> {
	
	private static final Logger log = LoggerFactory.getLogger(RotaService.class);

	//Caso precise de alguma logica especifica....
	public Optional<Rota> recuperarPorDescricao(Rota pRota) {
		log.info("RotaServiceo.recuperarPorDescricao({})", pRota.getDescricao());
		return Optional.ofNullable(dao.findByDescricao(pRota.getDescricao()));
	}
	 
}