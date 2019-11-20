package com.zcrbend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.zcrbend.enums.TipoRota;

import lombok.Data;

@Entity
@Data
public class Rota implements Serializable, Comparable<Rota> {

	private static final long serialVersionUID = 1L;

	@Id	
    //@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; 

	/*
	 * Validação sendo realizada no rest
	 * 
	 
	 {
	    "data": null,
	    "errors": [
	        "Campo obrigatorio"
	    ]
	 }	 
	 */
	@NotBlank(message="{notblank}")
	@Column(nullable=false)
	private String descricao;

	@Column
	private String obs;
	
	@Enumerated(EnumType.STRING)
	private TipoRota tipoRota = TipoRota.POS_COLETA;
	
	@PreUpdate
    public void preUpdate() {
    }
     
    @PrePersist
    public void prePersist() {
    }

	@Override
	public int compareTo(Rota obj) {
		return this.id.compareTo(obj.getId());
	}
}
