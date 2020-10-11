package br.com.aulaspring.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aulaspring.mvc.mudi.model.Pedido;
import br.com.aulaspring.mvc.mudi.model.StatusPedido;
import br.com.aulaspring.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping
	public String home(Model model) {
		
		List<Pedido> list = repository.findAll();
		
		model.addAttribute("pedidos",list);
		return "home";
	}
	@GetMapping("/{status}")
	public String perStatus(@PathVariable("status") String status, Model model) {
		
		List<Pedido> list = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		
		model.addAttribute("pedidos",list);
		model.addAttribute("status", status);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
