package com.T2.LP2_T2_SANTOS_ADEMIR.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="tbl_rubro")
public class Rubro {
	
	@Id
	@Column(name="id_rubro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRubro;
	
	@Column(name="denominacion")
	private String denominacion;
	
	public String tosString() {
		return denominacion;
	}

}
