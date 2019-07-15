package com.source.analy.circleDependceModel;

import lombok.Data;
import lombok.experimental.Accessors;

public class TestA {

	
	private TestB testb;

	public TestB getTestb() {
		return testb;
	}

	public void setTestb(TestB testb) {
		this.testb = testb;
	}
	
	
}
