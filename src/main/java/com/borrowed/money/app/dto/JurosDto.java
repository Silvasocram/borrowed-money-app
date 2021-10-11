package com.borrowed.money.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class JurosDto {

	private BigDecimal valor;
	private LocalDate data;

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

}
