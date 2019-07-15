package com.source.analy.circleDependceModel;

import lombok.Data;
import lombok.experimental.Accessors;

public class TestB {

	private TestC testc;

	public TestC getTestc() {
		return testc;
	}

	public void setTestc(TestC testc) {
		this.testc = testc;
	}
	
	
}
