package com.borrowed.money.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmprestimoDto {

	private List<Content> content;

	public List<Content> getContent() {
		return content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}

}
