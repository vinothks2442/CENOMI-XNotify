package com.Gypsee.bdd.api.step_definitions;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import com.Gypsee.bdd.api.base.TestContext;
import com.Gypsee.bdd.ccl.WS_PayloadsHeaders;
import com.Gypsee.bdd.integrations.common_utils.RestAssuredUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class PutSteps {

	private TestContext apiTestContext;

	public PutSteps(TestContext apiTestContext) {
		this.apiTestContext = apiTestContext;
	}

	/*
	 * Gets the uri and payload from db using request name and sends the put request
	 */
	@When("I put the request with {string} payload")
	public void postwithPayload(String requestName) {
		apiTestContext.getApiTestBase().specification
				.baseUri(RestAssuredUtils.baseURI);
		String request = apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(),requestName);
		if (!apiTestContext.getApiTestBase().requestData.isEmpty()) {
			apiTestContext.getApiTestBase().response = RestAssuredUtils.put(
					apiTestContext.getApiTestBase().specification, request,
					apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));

		} else {
			throw new RuntimeException(
					"No relevant rows found for " + requestName + " file");
		}

	}
	
	@When("^I hit the put request to \"([^\"]*)\" Endpoint with path params$")
	public void putwithPayloadwithPathparam(String requestName,DataTable dataTable) {
		
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			pathParams.put(table.get(i).get("Path"), table.get(i).get("Value"));
		}
		String request = apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());
//		apiTestContext.getApiTestBase().specification
//		.baseUri(apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.BASE_URI.name()));
		apiTestContext.getApiTestBase().response = RestAssuredUtils.put(apiTestContext.getApiTestBase().specification,
				request,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()),
				pathParams);
	}

	/*
	 * Gets the uri and payload from db using request name, get path params from
	 * data table and sends the put request
	 */
	@And("hit the put request to endpoint with path parameters")
	public void putWithPathParams(DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
						pathParams.put(table.get(i).get("Path"),
								(table.get(i).get("Value") == null) ? "" : table.get(i).get("Value"));
		}
		apiTestContext.getApiTestBase().response = RestAssuredUtils.put(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.RESOURCE_URI.name()),
				pathParams);
	}

	/*
	 * Gets the uri and payload from db using request name, get query params from
	 * data table and sends the put request
	 */
	@And("hit the put request to endpoint with query parameters")
	public void putWithQueryParams(DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			queryParams.put(table.get(i).get("QueryParamName"), table.get(i).get("QueryParamValue"));
		}
		apiTestContext.getApiTestBase().response = RestAssuredUtils.put(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.PAYLOAD.name()), queryParams,
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.RESOURCE_URI.name()));
	}

	/*
	 * Gets the uri and payload from db using request name, get query and path
	 * params from data table and sends the put request
	 */
	@And("hit the put request to endpoint with query and path parameters")
	public void putWithQueryAndPathParams(DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			queryParams.put(table.get(i).get("QueryParamName"), table.get(i).get("QueryParamValue"));
			pathParams.put(table.get(i).get("Path"), table.get(i).get("Value"));
		}
		apiTestContext.getApiTestBase().response = RestAssuredUtils.put(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.PAYLOAD.name()), queryParams,
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.RESOURCE_URI.name()),
				pathParams);
	}

	/*
	 * sends the post request to endpoint received from previous steps
	 */
	@And("^(?:hit the put request to endpoint|hit the put request)$")
	public void put() {
		apiTestContext.getApiTestBase().response = RestAssuredUtils.put(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.RESOURCE_URI.name()));
	}

}
