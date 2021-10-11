package com.borrowed.money.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.borrowed.money.app.dto.Content;
import com.borrowed.money.app.dto.EmprestimoDto;
import com.borrowed.money.app.service.EmprestimoService;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
	
	@Autowired
	EmprestimoService emprestimoService;

	@GetMapping("/")
	public String home(Model model) {
		
		/*
		 * EmprestimoDto emprestimo = new EmprestimoDto(); emprestimo.setNome("Samuel");
		 * emprestimo.setValor(new BigDecimal(20000.00));
		 * emprestimo.setData(LocalDate.now()); emprestimo.setValorDevido(new
		 * BigDecimal(5000.00));
		 * 
		 * List<EmprestimoDto> emprestimos = Arrays.asList(emprestimo, emprestimo,
		 * emprestimo, emprestimo, emprestimo, emprestimo);
		 * 
		 * model.addAttribute("emprestimos", emprestimos);
		 * 
		 * model.addAttribute("nome", "Marcos Silva");
		 */
		  
		 
		EmprestimoDto emprestimoDto = emprestimoService.listar();
		
		/*
		 * List<Content> content = new ArrayList<Content>();
		 * 
		 * for (Content emprestimo : emprestimoDto.getContent()) { Content c = new
		 * Content(); c.setId(emprestimo.getId()); c.setNome(emprestimo.getNome());
		 * c.setData(emprestimo.getData()); c.setPercentual(emprestimo.getPercentual());
		 * c.setValorDevido(emprestimo.getValorDevido());
		 * 
		 * content.add(emprestimo); }
		 * 
		 * emprestimoDto.setContent(content);
		 */
		 
		model.addAttribute("emprestimos", emprestimoDto);
		
		for (Content content2 : emprestimoDto.getContent()) {
			System.out.println(content2.getNome());
		}

		return "emprestimo/home";
	}
	
	
	@GetMapping("/novo")
	public String novo () {
		return "emprestimo/novo";
	}

}
