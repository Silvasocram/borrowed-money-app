package com.borrowed.money.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.borrowed.money.app.dto.EmprestimoDto;
import com.borrowed.money.app.form.EmprestimoForm;
import com.borrowed.money.app.service.EmprestimoService;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoService;

	@GetMapping
	public String home(Model model) {

		EmprestimoDto emprestimoDto = emprestimoService.listar();

		model.addAttribute("emprestimos", emprestimoDto);

		return "emprestimo/home";
	}

	@GetMapping("/formulario")
	public String formulario() {
		return "emprestimo/formulario";
	}

	@PostMapping("/salvar")
	private String salvar(EmprestimoForm emprestimo) {

		emprestimoService.salvar(emprestimo);

		return "emprestimo/home";
	}

}
