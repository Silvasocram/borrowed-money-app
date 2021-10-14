package com.borrowed.money.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Juros {

	private Long id;
	private BigDecimal valor;
	private LocalDate data;
	private Long emprestimo_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getEmprestimo_id() {
		return emprestimo_id;
	}

	public void setEmprestimo_id(Long emprestimo_id) {
		this.emprestimo_id = emprestimo_id;
	}

}
