package com.Gypsee.bdd.api.step_definitions;

import java.io.File;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Gypsee.bdd.api.base.TestContext;
import com.Gypsee.bdd.ccl.WS_PayloadsHeaders;
import com.Gypsee.bdd.integrations.common_utils.Constants;
import com.Gypsee.bdd.integrations.common_utils.JsonUtils;
import com.Gypsee.bdd.integrations.common_utils.ResourceURIS;
import com.Gypsee.bdd.integrations.common_utils.RestAssuredUtils;
import com.Gypsee.bdd.integrations.report_utils.ReportManager;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class GetSteps {

	private TestContext apiTestContext;
    
	public GetSteps(TestContext apiTestContext) {
		this.apiTestContext = apiTestContext;
	}

	// Gets the resource uri based on request name from DB and sends get request
	@When("^I send the GET request to \"([^\"]*)\" endpoint$")
	public void get(String fileName) {
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(fileName));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));

	}
	/*
	 * Gets the resource uri based on request name from DB, gets path params from
	 * data table and sends get request
	 */

	@When("^I send the GET request to \"([^\"]*)\" endpoint with path parameters$")
	public void getWithPathPrams(String fileName, DataTable dataTable) {

		List<Map<String, String>> table = dataTable.asMaps();

		Map<String, Object> pathParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			String value = table.get(i).get("Value");
			if (value == null)
				value = "";
			pathParams.put(table.get(i).get("Path"), value);
		}
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(fileName));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
				pathParams, apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
//        ReportManager.logInfoAPI(LocalDateTime.now().toString());

	}

	@When("^I send the GET request to \"([^\"]*)\" endpoint with path parameters and without encoded url$")
	public void getWithPathPramswithoutencodedurl(String fileName, DataTable dataTable) {
		System.out.println(LocalDateTime.now());
		List<Map<String, String>> table = dataTable.asMaps();

		Map<String, Object> pathParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			String value = table.get(i).get("Value");
			if (value == null)
				value = "";
			pathParams.put(table.get(i).get("Path"), value);
		}
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(fileName));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(
				apiTestContext.getApiTestBase().specification.urlEncodingEnabled(false), pathParams,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
		ReportManager.logInfoAPI(LocalDateTime.now().toString());
		System.out.println(LocalDateTime.now());
	}

	/*
	 * Gets the resource uri based on request name from DB, gets query params from
	 * data table and sends get request
	 */

	@When("^I send the GET request to \"([^\"]*)\" endpoint with query parameters$")
	public void getWithQueryParams(String fileName, DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> queryParams = new HashMap<String, Object>();

		for (int i = 0; i < table.size(); i++) {
			queryParams.put(table.get(i).get("QueryParamName"), table.get(i).get("QueryParamValue"));
		}
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(fileName));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()), queryParams);
	}

	/*
	 * Gets the resource uri based on request name from DB, gets path and query
	 * params from data table and sends get request
	 */

	@When("^I send the GET request to \"([^\"]*)\" endpoint with query and path parameters$")
	public void getWithQueryAndPathParams(String fileName, DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).get("QueryParamName") != null) {
				queryParams.put(table.get(i).get("QueryParamName"), table.get(i).get("QueryParamValue"));
			}
			if (table.get(i).get("Path") != null) {
				pathParams.put(table.get(i).get("Path"), table.get(i).get("Value"));
			}
		}
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(fileName));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()), queryParams,
				pathParams);

	}

	@When("^I send the GET request to \"([^\"]*)\" endpoint with query and path parameters and without encoded url$")
	public void getWithQueryAndPathParamswithoutencodedurl(String fileName, DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).get("QueryParamName") != null) {
				queryParams.put(table.get(i).get("QueryParamName"), table.get(i).get("QueryParamValue"));
			}
			if (table.get(i).get("Path") != null) {
				pathParams.put(table.get(i).get("Path"), table.get(i).get("Value"));
			}
		}
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(fileName));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(
				apiTestContext.getApiTestBase().specification.urlEncodingEnabled(false),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()), queryParams,
				pathParams);

	}

	@And("hit the Get request to endpoint with query parameters")
	public void putWithQueryParams(DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			queryParams.put(table.get(i).get("QueryParamName"), table.get(i).get("QueryParamValue"));
		}
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()), queryParams);
	}

	/*
	 * GET Method endpoint with query parameters without encoded url
	 */

	@When("^I send the GET request to \"([^\"]*)\" endpoint with query parameters without encoded url$")
	public void getWithQueryParamsWithoutEncodedUrl(String fileName, DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> queryParams = new HashMap<String, Object>();

		for (int i = 0; i < table.size(); i++) {
			queryParams.put(table.get(i).get("QueryParamName"), table.get(i).get("QueryParamValue"));
		}
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(fileName));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(
				apiTestContext.getApiTestBase().specification.urlEncodingEnabled(false),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()), queryParams);
	}

	/*
	 * Gets the resource uri and payload based on request name from DB and sends get
	 * request
	 */
	@When("^I send the GET request to \"([^\"]*)\" endpoint with urlEncoded payload$")
	public void getWithurlEncodedRequestBody(String fileName, DataTable dataTable) {
		List<String> table = dataTable.asList();
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(fileName));
		}

		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()), table.get(0));

	}

	@When("I send the PUT request to {} endpoint with path parameters")
	public void putWithPathPrams(String endPoint, DataTable dataTable) {

		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + endPoint + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			String value = table.get(i).get("Value");
			if (value == null)
				value = "";
			pathParams.put(table.get(i).get("Path"), value);
		}
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), endPoint);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(endPoint));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.put(apiTestContext.getApiTestBase().specification,
				request, apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()),
				pathParams);

//        ReportManager.logInfoAPI(LocalDateTime.now().toString());

	}

	@And("I hit the Get request to {string} endpoint with query parameters in chain value")
	public void getReqWithQueryChainValue(String fileName, DataTable dataTable) throws InterruptedException {
		
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		for (int i = 0; i < table.size(); i++) {
			queryParams.put(table.get(i).get("QueryParamName"), ApiRequestModificationSteps.quote_id);
			System.out.println("the value for quote id is- " +ApiRequestModificationSteps.quote_id);
		}
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
				 apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()),queryParams);
		ReportManager.logInfoAPI(LocalDateTime.now().toString());
		System.out.println("Get request response: " + apiTestContext.getApiTestBase().response.asString());
	}

	@And("I send get request with {string} requestname and {string} jpath value as path parameter from  {string} response file")
	public void getwithPayloadWithChaindata(String fileName, String jPaths, String responseFileName,
			DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		File responseFile = new File("./ResponseStore/" + responseFileName + ".json");
		String responseBody;
		try {
			responseBody = JsonPath.using(configuration).parse(responseFile).jsonString();
//			System.out.println(responseBody);
			Map<String, Object> contextMap = new HashMap<String, Object>();
			for (String path : jPaths.split(";")) {
				String key = path.substring(path.lastIndexOf(".") + 1, path.length());
				contextMap.put(key, JsonUtils.getJSonObjectValue(responseBody, path));
				System.out.println("value is " + String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path))); // Constants.ResponseData=
				String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));

				apiTestContext.getApiTestBase().contextMap = contextMap;

				for (int i = 0; i < table.size(); i++) {
					String value = String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
					pathParams.put(table.get(i).get("Path"), value);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
				pathParams, apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
		ReportManager.logInfoAPI(LocalDateTime.now().toString());
		System.out.println("Get request response: " + apiTestContext.getApiTestBase().response.asString());
	}
	
	//jpath value in query parameter - Nagalakshmi
	
	@When("I send get request with {string} requestname and {string} jpath value as query parameter from  {string} response file")
	public void getwithPayloadWithChaindataQueryParameter(String fileName, String jPaths, String responseFileName,
			DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		File responseFile = new File("./ResponseStore/" + responseFileName + ".json");
		String responseBody;
		try {
			responseBody = JsonPath.using(configuration).parse(responseFile).jsonString();
//			System.out.println(responseBody);
			Map<String, Object> contextMap = new HashMap<String, Object>();
			for (String path : jPaths.split(";")) {
				String key = path.substring(path.lastIndexOf(".") + 1, path.length());
				contextMap.put(key, JsonUtils.getJSonObjectValue(responseBody, path));
				System.out.println("value is " + String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path))); // Constants.ResponseData=
				String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));

				apiTestContext.getApiTestBase().contextMap = contextMap;

				for (int i = 0; i < table.size(); i++) {
					String value = String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
					queryParams.put(table.get(i).get("Path"), value);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()),queryParams);
		ReportManager.logInfoAPI(LocalDateTime.now().toString());
		System.out.println("Get request response: " + apiTestContext.getApiTestBase().response.asString());
	}
	
	@When("I send get request with {string} requestname and {string} jpath value from {string} response file and {string} jpath value from {string} response file")
	public void getwithPayloadWithChaindata1(String fileName,String path, String fileName0,String path1, String fileName1) {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		
		File json = new File("./ResponseStore/" + fileName0 + ".json");
		String responseBody;
		
		try {
			responseBody = JsonPath.using(configuration).parse(json).jsonString();
			String quote_idValue=String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
			System.out.println("Value is " +quote_idValue); // Constants.ResponseData=
			pathParams.put("session_token", quote_idValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	File json1 = new File("./ResponseStore/" + fileName1 + ".json");
	String responseBody1;
	try {
		responseBody1 = JsonPath.using(configuration).parse(json1).jsonString();
		String otpValue=String.valueOf(JsonUtils.getJSonObjectValue(responseBody1, path1));
		System.out.println("Value is " +otpValue); // Constants.ResponseData=
		pathParams.put("otp", otpValue);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
	apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
			ResourceURIS.getResourceURI(fileName));

apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification,
		pathParams, apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
ReportManager.logInfoAPI(LocalDateTime.now().toString());
//System.out.println("Get request response: "+apiTestContext.getApiTestBase().response.prettyPrint());
ReportManager.logInfoAPI("<details><summary><font color=\"green\"><b>Click to view Response</b></font></summary><p><pre>"+apiTestContext.getApiTestBase().response.prettyPrint()+"</pre></script></p></details>");
	
	
	
	}
	
	@When("I send get request with {string} requestname and {string} jpath value from {string} response file and {string} jpath value from {string} response file as query parameter")
	public void getwithPayloadWithChaindataforQueryParams(String fileName,String path, String fileName0,String path1, String fileName1) {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		
		File json = new File("./ResponseStore/" + fileName0 + ".json");
		String responseBody;
		
		try {
			responseBody = JsonPath.using(configuration).parse(json).jsonString();
			String otpValue=String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
			System.out.println("Value is " +otpValue); // Constants.ResponseData=
			queryParams.put("otp", otpValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	File json1 = new File("./ResponseStore/" + fileName1 + ".json");
	String responseBody1;
	try {
		responseBody1 = JsonPath.using(configuration).parse(json1).jsonString();
		String quote_idValue=String.valueOf(JsonUtils.getJSonObjectValue(responseBody1, path1));
		System.out.println("Value is " +quote_idValue); // Constants.ResponseData=
		queryParams.put("session_token", quote_idValue);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
	apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
			ResourceURIS.getResourceURI(fileName));

apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
apiTestContext.getApiTestBase().response = RestAssuredUtils.get(apiTestContext.getApiTestBase().specification, apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()),queryParams);
ReportManager.logInfoAPI(LocalDateTime.now().toString());
//System.out.println("Get request response: "+apiTestContext.getApiTestBase().response.prettyPrint());
ReportManager.logInfoAPI("<details><summary><font color=\"green\"><b>Click to view Response</b></font></summary><p><pre>"+apiTestContext.getApiTestBase().response.prettyPrint()+"</pre></script></p></details>");
	
	
	
	}


}
