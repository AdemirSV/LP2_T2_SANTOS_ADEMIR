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
@Table(name="tbl_orden_compra")

public class OrdenCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="nro_orden")
	private Integer orden;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
	
	@Column(name="monto")
	private Double monto;
	
	@Column(name="direccion_entrega")
	private String direccionEntrega;
	
	@Column(name="fecha_entrega")
	private LocalDate fecEntrega;
	
	@Column(name="estado")
	private String estado;
	
	public String textoEstado() {
		switch (estado) {
		case "P": { return "Pendiente";}
		case "C": { return "Completado";}
		case "A": { return "Anulado";}	
		default:	return "N.A";
		}
	}

}
