package com.T2.LP2_T2_SANTOS_ADEMIR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T2.LP2_T2_SANTOS_ADEMIR.model.Proveedor;
import com.T2.LP2_T2_SANTOS_ADEMIR.repository.ProveedorRepository;

@Service

public class ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	public List<Proveedor>getAll(){
		return proveedorRepository.findAll();
	}

}
