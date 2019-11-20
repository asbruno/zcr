package zcr.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import zcr.model.Geradora;

@Named
@ApplicationScoped
public class GeradoraService {

	@Getter	@Setter
	private List<Geradora> listagem = new ArrayList<Geradora>();

	public void gravar(Geradora pModel) {
		listagem.add(pModel);
	}
	
}
