package com.borrowed.money.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.borrowed.money.app.dto.EmprestimoDetalhesDto;
import com.borrowed.money.app.dto.EmprestimoDto;
import com.borrowed.money.app.form.EmprestimoForm;
import com.borrowed.money.app.service.EmprestimoService;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {

	/**
	 * Injetamos a service responsável por consumir nossa API Rest.
	 */
	@Autowired
	EmprestimoService emprestimoService;

	/**
	 * Método responsável por carregar todos os emprestimos.
	 * 
	 * @param model
	 * @return home.html
	 */
	@GetMapping("/")
	public String home(Model model) {

		EmprestimoDto emprestimoDto = emprestimoService.listar();

		model.addAttribute("emprestimos", emprestimoDto);

		return "emprestimo/home";
	}

	/**
	 * Abre o html do fomulário para que possamos preencher e posteriormente
	 * salvarmos.
	 * 
	 * @return formulario.html
	 */
	@GetMapping("/formulario")
	public String formulario() {
		return "emprestimo/formulario";
	}

	/**
	 * Método responsável por salvar um novo emprestimo, após salvar, retorna para
	 * página principal listando todos os empréstimos.
	 * 
	 * @param emprestimo
	 * @return home.html
	 */
	@PostMapping("/salvar")
	private String salvar(EmprestimoForm emprestimo) {

		emprestimoService.salvar(emprestimo);

		return "redirect:/emprestimo/";
	}

	/**
	 * Método responsável por exlcuir um determinado empréstimo.
	 * 
	 * @param id
	 * @return home.html
	 */
	@GetMapping("/apagar")
	private String deletar(@RequestParam(name = "id") String id) {

		emprestimoService.deletar(Long.parseLong(id));

		return "redirect:/emprestimo/";
	}

	@GetMapping("/detalhes")
	private String detalhes(@RequestParam(name = "id") String id, Model model) {

		EmprestimoDetalhesDto emprestimoDetalhesDto = emprestimoService.detalhes(Long.parseLong(id));

		model.addAttribute("emprestimoDetalhesDto", emprestimoDetalhesDto);

		return "emprestimo/detalhe";
	}

	@GetMapping("/alterar")
	private String alterar(@RequestParam(name = "id") String id, Model model) {

		EmprestimoDetalhesDto emprestimoDetalhesDto = emprestimoService.detalhes(Long.parseLong(id));

		model.addAttribute("emprestimoDetalhesDto", emprestimoDetalhesDto);

		return "emprestimo/alterar";

	}

	@PostMapping("/salvarAlteracao")
	private String salvarAlteracao(EmprestimoDetalhesDto emprestimo) {

		
		  System.out.println("ID: " + emprestimo.getId() + " Nome: " +
		  emprestimo.getNome() + " Valor: " + emprestimo.getValor() + " Data: " +
		  emprestimo.getData() + " Percentual: " + emprestimo.getPercentual() +
		  " Amortizado: " + emprestimo.getValorDevido() + " Observação: " +
		  emprestimo.getObservacao());
		 

		/*
		 * EmprestimoDetalhesDto emprestimoDetalhesDto =
		 * emprestimoService.detalhes(emprestimo.getId());
		 * 
		 * emprestimoDetalhesDto.setNome(emprestimo.getNome());
		 * emprestimoDetalhesDto.setData(emprestimo.getData());
		 * emprestimoDetalhesDto.setObservacao(emprestimo.getObservacao());
		 * emprestimoDetalhesDto.setPercentual(emprestimo.getPercentual());
		 * emprestimoDetalhesDto.setValor(emprestimo.getValor());
		 * emprestimoDetalhesDto.setValorDevido(emprestimo.getValorDevido());
		 * 
		 * emprestimoService.alterar(emprestimoDetalhesDto);
		 */

		
		  EmprestimoForm emprestimoForm = new EmprestimoForm();
		  emprestimoForm.setNome(emprestimo.getNome());
		  emprestimoForm.setData(emprestimo.getData());
		  emprestimoForm.setObservacao(emprestimo.getObservacao());
		  emprestimoForm.setPercentual(emprestimo.getPercentual());
		  emprestimoForm.setValor(emprestimo.getValor());
		  emprestimoForm.setValorDevido(emprestimo.getValorDevido());
		  
		  emprestimoService.alterar(emprestimo.getId(), emprestimoForm);
		 

		  return null;
		//return "redirect:/emprestimo/";
	}
}
