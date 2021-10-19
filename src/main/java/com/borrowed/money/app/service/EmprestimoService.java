package com.borrowed.money.app.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.borrowed.money.app.dto.EmprestimoDetalhesDto;
import com.borrowed.money.app.dto.EmprestimoDto;
import com.borrowed.money.app.form.EmprestimoForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class EmprestimoService {

	WebClient webClient = WebClient
			.builder()
			.baseUrl("https://borrowed-money-api.herokuapp.com/")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.build();


	public EmprestimoDto listar() {

		String retorno = this.webClient
				.get()
				.uri("/emprestimo/")
				.retrieve()
				.bodyToMono(String.class).block();


		EmprestimoDto emprestimo = new EmprestimoDto();
		ObjectMapper mapper = new ObjectMapper();

		// Adicionado para ignorar o atributo [content] retornado no Json
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// Adicionado para tratar LocalDate
		mapper.registerModule(new JavaTimeModule());

		try {
			JsonNode rootNode = mapper.readTree(retorno);

			if (rootNode instanceof JsonNode) {
				emprestimo = mapper.readValue(rootNode.toString(), EmprestimoDto.class);
			}

		} catch (JsonProcessingException e) {
			System.out.println("Deu ruim, cai na exception");
			e.printStackTrace();
		}

		return emprestimo;
	}

	public void salvar(EmprestimoForm emprestimo) {
		webClient
		.post()
		.uri("/emprestimo/")
		.bodyValue(emprestimo)
		.retrieve()
		.bodyToMono(EmprestimoForm.class)
		.block();
	}

	public void deletar(long id) {
		webClient
		.delete()
		.uri("/emprestimo/" + id)
		.retrieve()
		.bodyToMono(Void.class)
		.block();
		
	}

	public EmprestimoDetalhesDto detalhes(long id) {
		
		EmprestimoDetalhesDto emprestimoDetalhesDto = webClient
		.get()
		.uri("/emprestimo/" + id)
		.retrieve()
		.bodyToMono(EmprestimoDetalhesDto.class)
		.block();
		
		return emprestimoDetalhesDto;
	}

	public void alterar(Long id, EmprestimoForm emprestimo) {
		webClient
		.put()
		.uri("/emprestimo/" + id)
		.bodyValue(emprestimo)
		.retrieve()
		.bodyToMono(Void.class)
		.block();	
	}

	public void alterar(EmprestimoDetalhesDto emprestimoDetalhesDto) {
		webClient
		.put()
		.uri("/emprestimo/" + emprestimoDetalhesDto.getId())
		.bodyValue(emprestimoDetalhesDto)
		.retrieve()
		.bodyToMono(Void.class)
		.block();		
	}

}
