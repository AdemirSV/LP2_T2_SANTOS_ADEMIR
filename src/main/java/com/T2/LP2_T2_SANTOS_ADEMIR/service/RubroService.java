package com.T2.LP2_T2_SANTOS_ADEMIR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T2.LP2_T2_SANTOS_ADEMIR.model.Rubro;
import com.T2.LP2_T2_SANTOS_ADEMIR.repository.RubroRepository;

@Service

public class RubroService {
	
	@Autowired
	private RubroRepository rubroRepository;
	
	public List<Rubro> getAll(){
		return rubroRepository.findAll();
	}
	

}
