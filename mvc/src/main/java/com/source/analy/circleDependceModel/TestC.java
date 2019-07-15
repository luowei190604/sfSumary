package com.source.analy.circleDependceModel;

import lombok.Data;
import lombok.experimental.Accessors;

public class TestC {

	
	public TestA getTesta() {
		return testa;
	}

	public void setTesta(TestA testa) {
		this.testa = testa;
	}

	private TestA testa;
}
