package com.T2.LP2_T2_SANTOS_ADEMIR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T2.LP2_T2_SANTOS_ADEMIR.model.OrdenCompra;
import com.T2.LP2_T2_SANTOS_ADEMIR.repository.OrdenCompraRepository;

@Service

public class OrdenCompraService {
	
	@Autowired
	private OrdenCompraRepository ordenCompraRepository;
	
	public List<OrdenCompra>getAll(){
		return ordenCompraRepository.findByOrderByOrdenDesc();
	}

}
