package com.Gypsee.bdd.api.base;

public class TestContext {

	private ApiTestBase apiTestBase;

	public TestContext() {
		apiTestBase = new ApiTestBase();

	}

	public ApiTestBase getApiTestBase() {
		return apiTestBase;
	}

}
