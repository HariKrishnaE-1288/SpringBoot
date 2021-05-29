package com.mobi.test.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RootList {

	@JsonProperty
	private List<Root> root;

	public RootList() {
	}
	
	public List<Root> getRoot() {
		return root;
	}

	public void setRoot(List<Root> root) {
		this.root = root;
	}


}
