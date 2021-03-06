package com.borrowed.money.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.borrowed.money.app.form.JurosForm;
import com.borrowed.money.app.service.JurosService;

@Controller
@RequestMapping("/juros")
public class JurosController {

	@Autowired
	private JurosService jurosService;

	private Long emprestimoId;

	/**
	 * Abre o html do fomulário para que possamos preencher e posteriormente
	 * salvarmos.
	 * 
	 * @return formulario.html
	 */
	@GetMapping("/formulario")
	public String formulario(@RequestParam(name = "id") String id) {

		this.emprestimoId = Long.parseLong(id);

		return "juros/formulario";
	}

	@PostMapping("/salvar")
	public String salvar(JurosForm jurosForm) {

		jurosForm.setEmprestimoId(this.emprestimoId);

		jurosService.salvar(jurosForm);

		return "redirect:/emprestimo/detalhes/?id=" + this.emprestimoId;
	}
	
	@GetMapping("/apagar")
	private String apagar(@RequestParam(name = "id") String id, @RequestParam(name = "emprestimo_id") String emprestimo_id) {
		
		//System.out.println("Deletar ID: " + id + " EmprestimoId: " + emprestimo_id);
		
		jurosService.deletar(Long.parseLong(id));
		
		
		return "redirect:/emprestimo/detalhes/?id=" + emprestimo_id; 
	}

}
