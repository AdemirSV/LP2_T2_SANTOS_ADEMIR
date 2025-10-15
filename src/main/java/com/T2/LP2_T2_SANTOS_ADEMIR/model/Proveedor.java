package com.T2.LP2_T2_SANTOS_ADEMIR.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="tbl_proveedor")

public class Proveedor {
	
	@Id
	@Column(name="id_proveedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProveedor;
	
	@Column(name="ruc")
	private String ruc;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	@Column(name="fecha_registro")
	private LocalDate fecReg;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="pagina_web")
	private String web;
	
	@ManyToOne
	@JoinColumn(name="id_rubro")
	private Rubro rubro;
	
	
		
}
