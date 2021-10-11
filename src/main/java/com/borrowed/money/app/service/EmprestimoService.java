package com.borrowed.money.app.service;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.borrowed.money.app.dto.EmprestimoDto;
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

	// create("https://borrowed-money-api.herokuapp.com/emprestimo");

	public EmprestimoDto listar(){

		
		/*
		 * List<JurosDto> jurosDto = this.webClient .method(HttpMethod.GET)
		 * .uri("/juros/{empresa_id}", empresa_id) .retrieve() .bodyToMono(new
		 * ParameterizedTypeReference<List<JurosDto>>() {}) .block();
		 * 
		 * 
		 * jurosDto.forEach(j ->{ System.out.println("Valor: " + j.getValor() +
		 * " Data: " + j.getData()); });
		 */
		 
				
		
		  String retorno = this.webClient .get() .uri("/emprestimo/") .retrieve()
		  .bodyToMono(String.class) .block();
		  
		  /*
		   * String jsonStr = response.readEntity(String.class);
ObjectMapper mapper = new ObjectMapper();
JsonNode rootNode = mapper.readTree(jsonStr);

// Start by checking if this is a list -> the order is important here:                      
if (rootNode instanceof ArrayNode) {
    // Read the json as a list:
    myObjClass[] objects = mapper.readValue(rootNode.toString(), myObjClass[].class);
    ...
} else if (rootNode instanceof JsonNode) {
    // Read the json as a single object:
    myObjClass object = mapper.readValue(rootNode.toString(), myObjClass.class);
    ...
} else {
    ...
}*/
		  
		  EmprestimoDto emprestimo = new EmprestimoDto();
		  ObjectMapper mapper = new ObjectMapper();
		  
		  // Adicionado para ignorar o atributo [content] retornado no Json
		  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  // Adicionado para tratar LocalDate
		  mapper.registerModule(new JavaTimeModule());
		  
		  try {
			JsonNode rootNode = mapper.readTree(retorno);
			
			if(rootNode instanceof JsonNode) {
				//System.out.println("Entrei no ELSE");
				emprestimo = mapper.readValue(rootNode.toString(), EmprestimoDto.class);
				//System.out.println(emprestimo.getContent().get(0).getNome());
			}
			
		} catch (JsonProcessingException e) {
			System.out.println("Deu ruim, cai na exception");
			e.printStackTrace();
		}
		  
		 
		
		/*
		 * System.out.println("Entrei aqui!");
		 * 
		 * List<EmprestimoDto> emprestimos = this.webClient .get() .uri("/emprestimo")
		 * .retrieve() .bodyToMono(new ParameterizedTypeReference<List<EmprestimoDto>>()
		 * {}) .block();
		 * 
		 * emprestimos.forEach(e-> System.out.println("RESULT: " +
		 * e.getContent().get(0).getNome()));
		 */
		 		
		return emprestimo;
	}

}
