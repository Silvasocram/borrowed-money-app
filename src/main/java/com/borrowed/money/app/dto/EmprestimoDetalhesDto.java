package com.borrowed.money.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class EmprestimoDetalhesDto {

	private Long id;
	private String nome;
	private BigDecimal valor;
	private LocalDate data;
	private Double percentual;
	private BigDecimal valorDevido;
	private String observacao;
	private List<Juros> juros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public BigDecimal getValorDevido() {
		return valorDevido;
	}

	public void setValorDevido(BigDecimal valorDevido) {
		this.valorDevido = valorDevido;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Juros> getJuros() {
		return juros;
	}

	public void setJuros(List<Juros> juros) {
		this.juros = juros;
	}

}
