package com.zcrbend.service;

import java.util.List;

/*
 * Alguns métodos não irei implementar, somente irei representa no fonte, via comentário.
 */
public interface IService<MODEL> {

	MODEL gravar(MODEL model);
	
	//MODEL atualizarById(MODEL model);
	
	//MODEL deleteById(MODEL model);
	
	//List<MODEL> atualizar(List<MODEL> model);
	
	List<MODEL> carregarTodos(); //Somente para exemplo......
	
	//Page<MODEL> carregarTodos(List<MODEL> model, PageRequest pageRequest);
	
}
