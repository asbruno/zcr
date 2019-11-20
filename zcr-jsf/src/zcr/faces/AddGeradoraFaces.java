package zcr.faces;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import zcr.model.Geradora;
import zcr.service.GeradoraService;

@Named(value = "addGeradora")
@RequestScoped
public class AddGeradoraFaces extends GenericFaces {

	@Getter	@Setter
	private Geradora geradora;
	
	@Inject
	private GeradoraService service;
	
	@PostConstruct
	void setup() {
		setGeradora(new Geradora()); 
	}

	public void buttonAction() {
		service.gravar(geradora);
        addMessage("Geradora cadastrada com sucesso!!!");
    }    
	
	public List<Geradora> getListagem() {
		return service.getListagem();
	}
}
