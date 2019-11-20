package com.zcrbend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Geradora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id	
	private Integer id;

	@NotBlank(message="{notblank}")
	@Column
	private String nome;
	
}
