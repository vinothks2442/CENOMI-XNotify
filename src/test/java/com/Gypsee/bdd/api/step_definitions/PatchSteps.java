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


public class PatchSteps {

	private TestContext apiTestContext;

	public PatchSteps(TestContext apiTestContext) {
		this.apiTestContext = apiTestContext;
	}

	@And("hit the patch request to endpoint with path parameters")
	public void patchWithPathParams(DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			pathParams.put(table.get(i).get("Path"), table.get(i).get("Value"));
		}
		apiTestContext.getApiTestBase().response = RestAssuredUtils.patch(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.PAYLOAD.name()), pathParams,
				apiTestContext.getApiTestBase().requestData.get(0).get(WS_PayloadsHeaders.RESOURCE_URI.name()));
	}
	
	 @When("^I hit the patch request for \"([^\"]*)\" Endpoint with path params$")
	    public void i_hit_the_patch_request_to_something_endpoint_with_path_params(String requestName,DataTable dataTable) throws Throwable {
		  List<Map<String, String>> table = dataTable.asMaps();
			Map<String, Object> pathParams = new HashMap<String, Object>();
			for (int i = 0; i < table.size(); i++) {
				pathParams.put(table.get(i).get("Path"), table.get(i).get("Value"));
			}
			apiTestContext.getApiTestBase().response = RestAssuredUtils.patch(apiTestContext.getApiTestBase().specification,
					apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()), pathParams,
					apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
	    }

}