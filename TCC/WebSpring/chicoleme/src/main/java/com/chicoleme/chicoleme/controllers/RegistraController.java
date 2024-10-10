package com.ChicoLeme.ChicoLeme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistraController {

	@RequestMapping("/")
	public String registra() {
		return "Registra";
	}
	
}
