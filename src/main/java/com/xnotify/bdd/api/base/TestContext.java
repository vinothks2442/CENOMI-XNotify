package com.XNotify.bdd.api.base;

public class TestContext {

	private ApiTestBase apiTestBase;

	public TestContext() {
		apiTestBase = new ApiTestBase();

	}

	public ApiTestBase getApiTestBase() {
		return apiTestBase;
	}

}
