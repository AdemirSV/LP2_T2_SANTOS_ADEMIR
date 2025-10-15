package com.T2.LP2_T2_SANTOS_ADEMIR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T2.LP2_T2_SANTOS_ADEMIR.dto.ResultadoResponse;
import com.T2.LP2_T2_SANTOS_ADEMIR.model.OrdenCompra;
import com.T2.LP2_T2_SANTOS_ADEMIR.repository.OrdenCompraRepository;

@Service

public class OrdenCompraService {
	
	@Autowired
	private OrdenCompraRepository ordenCompraRepository;
	
	public List<OrdenCompra>getAll(){
		return ordenCompraRepository.findByOrderByOrdenDesc();
	}

	public ResultadoResponse create(OrdenCompra orden) {
		try {
			OrdenCompra ordenRegistrado = ordenCompraRepository.save(orden);
			
			String mensaje = String.format("Orden registrado con ID %s", ordenRegistrado.getOrden());
			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Error en InventarioService: "+e.getMessage());
		}
	}
}
