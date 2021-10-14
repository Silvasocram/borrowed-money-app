package com.borrowed.money.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/juros")
public class JurosController {

	/**
	 * Abre o html do fomulário para que possamos preencher e posteriormente
	 * salvarmos.
	 * 
	 * @return formulario.html
	 */
	@GetMapping("/formulario")
	public String formulario() {
		return "/formulario";
	}

}
