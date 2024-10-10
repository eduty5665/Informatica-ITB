package com.example.projeto2B.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1")
public class IndexController {
	
	private String msg = "Eai Leo, tudo bem com você?";
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("nome", nome);
		return "index";
	}
	
	private String nome = "PIRIQUITINHO";
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("msg", msg);
		return "home";
	}
	//localhost:8080/api/v1/index
	
	@GetMapping("/minha-pagina")
	private String minhaPagina() {
		return "minha-pagina";
}
}