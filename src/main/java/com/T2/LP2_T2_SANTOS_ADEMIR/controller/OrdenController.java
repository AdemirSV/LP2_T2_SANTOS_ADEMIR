package com.T2.LP2_T2_SANTOS_ADEMIR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.T2.LP2_T2_SANTOS_ADEMIR.model.OrdenCompra;
import com.T2.LP2_T2_SANTOS_ADEMIR.service.OrdenCompraService;
import com.T2.LP2_T2_SANTOS_ADEMIR.service.ProveedorService;
import com.T2.LP2_T2_SANTOS_ADEMIR.util.Alert;

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
	
	@Autowired
	private ProveedorService proServ;
	
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProveedor",proServ.getAll());
		model.addAttribute("orden", new OrdenCompra());
		return "orden/nuevo";
	}
	
	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompra orden,Model model,RedirectAttributes flash) {
		var response = ordenServ.create(orden);
		
		if(!response.success) {
			model.addAttribute("alert",Alert.sweetAlertError(response.mensaje));
			model.addAttribute("lstOrden",ordenServ.getAll());
			model.addAttribute("lstProveedor",proServ.getAll());
			return "orden/nuevo";
		}
		flash.addFlashAttribute("toast",Alert.sweetToast(response.mensaje,"success",5000));		
		return "redirect:/orden/listado";
	}
	
	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("lstProducto",proServ.getAll());
		model.addAttribute("lstOrden",ordenServ.getAll());
		model.addAttribute("orden", ordenServ.getOne(id));
		return "orden/edicion";
	}
	
	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompra orden,Model model,RedirectAttributes flash) {
		var response = ordenServ.update(orden);
		
		if(!response.success) {
			model.addAttribute("alert",Alert.sweetAlertError(response.mensaje));
			model.addAttribute("lstOrden",ordenServ.getAll());
			model.addAttribute("lstProveedor",proServ.getAll());
			return "orden/nuevo";
		}
		flash.addFlashAttribute("toast",Alert.sweetToast(response.mensaje,"success",5000));		
		return "redirect:/orden/listado";
	}
}
























