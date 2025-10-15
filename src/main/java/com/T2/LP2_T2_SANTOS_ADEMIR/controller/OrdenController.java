package com.T2.LP2_T2_SANTOS_ADEMIR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.T2.LP2_T2_SANTOS_ADEMIR.service.OrdenCompraService;

@Controller
@RequestMapping("orden")

public class OrdenController {

	@Autowired
	private OrdenCompraService ordenServ;
	
	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstOrden",ordenServ.getAll());
		return "orden/listado";
	}
}
