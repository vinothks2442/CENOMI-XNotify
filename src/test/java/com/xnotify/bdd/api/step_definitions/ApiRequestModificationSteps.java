package com.xnotify.bdd.api.step_definitions;

import java.io.File;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.xnotify.bdd.api.base.TestContext;
import com.xnotify.bdd.ccl.WS_PayloadsHeaders;
import com.xnotify.bdd.integrations.common_utils.ConfigReader;
import com.xnotify.bdd.integrations.common_utils.Constants;
import com.xnotify.bdd.integrations.common_utils.JsonUtils;
import com.xnotify.bdd.integrations.common_utils.RandomGenerator;
import com.xnotify.bdd.integrations.common_utils.ResourceURIS;
import com.xnotify.bdd.integrations.common_utils.RestAssuredUtils;
import com.xnotify.bdd.integrations.common_utils.TestUtils;
import com.xnotify.bdd.integrations.report_utils.ReportManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/*
 * All type of request body, request parameters modification methods should be present in this class 
 */
public class ApiRequestModificationSteps {
	public static String str_data;
	public static String quote_id;

	private TestContext apiTestContext;

	public ApiRequestModificationSteps(TestContext apiTestContext) {
		this.apiTestContext = apiTestContext;
	}

	/*
	 * Gets the payload by payload name if already not loaded Upadate or replace
	 * payload content from data table based on the payload name Input - Request
	 * Name,DataTable containing JPath of fields to be replaced
	 */
	@When("^(?:I update the|I replace the) \"([^\"]*)\" payload$")
	public void replacePayLoad(String fileName, DataTable dataTable) {
		// Gets the sample payload form database if request data is not empty
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  ReportManager.logInfoAPI("The request body is - "+ request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));

		// updates or replaces payload content from data table
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(),
				dataTable.asMaps().get(0).get("PayLoad"));
	}

	@When("I modify quote_ID in {string} payload")
	public void modifyQuote_IDPayload(String fileName, DataTable dataTable) {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, String>> table = dataTable.asMaps();
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));
	}

	@And("I fetch OTP from response in jpath {string}")
	public void fetchStringValue(String jPaths) {
		String response = apiTestContext.getApiTestBase().response.asString();
		Map<String, Object> contextMap = new HashMap<String, Object>();
		apiTestContext.getApiTestBase().contextMap = contextMap;
	}

	/*
	 * Gets the request from DB based on request name and Modifies payload based on
	 * the field Jpaths and values from Data Table Input - Request Name,DataTable
	 * containing JPath of fields to be modified
	 * 
	 */

	@When("^(?:I modify the fields in|I modify the field values in|I update the fields in|"
			+ "I set null value to the fields in|I set the field values in) \"([^\"]*)\" payload$")
	public void modifyPayload(String fileName, DataTable dataTable) {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, String>> table = dataTable.asMaps();
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(),
				TestUtils.modifyJsonPayLoadFromDataTable(request, table));
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		System.out.println(LocalDateTime.now());
	}

	@When("^I modify the fields in same payload$")
	public void modifyPayload(DataTable dataTable) {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();

		String request = apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());

		List<Map<String, String>> table = dataTable.asMaps();
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);

		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(),
				TestUtils.modifyJsonPayLoadFromDataTable(request, table));

		System.out.println(LocalDateTime.now());
	}

	@When("^I modify fields with random values in \"([^\"]*)\" payload$")
	public void modifyPayloadByRandomValues(String fileName, DataTable dataTable) {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, String>> table = dataTable.asMaps();
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));

		for (int i = 0; i < table.size(); i++) {
			String value = RandomGenerator.randomInteger(ConfigReader.getIntValue("AccountNumberLength"));
			request = JsonUtils.ModifyJSON(request, table.get(i).get("JPath"), value);
		}

		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		System.out.println(LocalDateTime.now());
	}

	/*
	 * removes single field in the payload received as inline param Input - Request
	 * Name, JPath of field to be removed
	 */

	@When("^I remove the \"([^\"]*)\" from \"([^\"]*)\" payload$")
	public void removeFieldFromPayLoad(String fieldJPath, String fileName) {
		// List<Map<String, String>> table = dataTable.asMaps();
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));
		if (!apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			request = apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());
			request = JsonUtils.removeJsonObject(request, fieldJPath);
		} else {
			throw new RuntimeException(fileName + " not such sample payload json file");
		}
		// }
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(), request);

	}

	/*
	 * Removes fields from payload loaded in previous steps or removes fields in the
	 * payload after fetching from DB in case not loaded in previous steps Input -
	 * Request Name, DataTable containing JPath of fields to be removed
	 */
	@When("^I remove the fields from \"([^\"]*)\" payload$")
	public void removeFieldFromPayLoad(String fileName, DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));
		for (int i = 0; i < table.size(); i++) {
			request = JsonUtils.removeJsonObject(request, table.get(i).get("JPath"));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(), request);
	}

	/*
	 * Removes fields from payload loaded in previous steps Input - DataTable
	 * containing JPath of fields to be removed
	 */
	@And("^(?:I remove the fields)$")
	public void removeFieldFromPayLoad(DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		String request = apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());
		for (int i = 0; i < table.size(); i++) {
			request = JsonUtils.removeJsonObject(request, table.get(i).get("JPath"));
		}
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(), request);

	}

	@When("^I modify the json fields in \"([^\"]*)\" payload$")
	public void modifyJsonFieldInPayload(String fileName, DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(),
				TestUtils.updateJsonFieldsFromDataTable(request, table));
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
	}

	@When("^I modify the field values$")
	public void modifyPayloadFromRequestData(DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		String request = apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(),
				TestUtils.modifyJsonPayLoadFromDataTable(request, table));
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
	}

	@And("I send request with same  Productid")
	public String returnStringValue(String jPath) {
		String key = jPath.substring(jPath.lastIndexOf("\\."), jPath.length());
		return apiTestContext.getApiTestBase().requestMap.get("key");

	}

	@And("I create subProduct with \"([^\"]*)\" with same Id \"([^\"]*)\"")
	public void modifyPayloadWithChainData(String fileName, String jPaths, DataTable dataTable) {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, String>> table = dataTable.asMaps();
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));
		request = TestUtils.modifyJsonPayLoadFromDataTable(request, table);
		/*
		 * List<Map<String, String>> chainTable = new ArrayList(); Map<String, String>
		 * chainMap = new HashMap<String,String>();
		 */
		String[] paths = jPaths.split(";");
		for (String path : paths) {
			String key = path.substring(path.lastIndexOf(".") + 1, path.length());
			Object value = apiTestContext.getApiTestBase().contextMap.get(key);
			System.out.println("value is" + String.valueOf(value));
			request = JsonUtils.ModifyJSON(request, path, value);
			System.out.println("I am in 2nd key ->" + key);
			System.out.println("I am in 2nd path ->" + path);
		}
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		System.out.println(LocalDateTime.now());
	}

	@And("I create scanConfiguration with \"([^\"]*)\"")
	public void modifyPayloadWithData(String fileName, DataTable dataTable) {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, String>> table = dataTable.asMaps();
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));
		request = TestUtils.modifyJsonPayLoadFromDataTable(request, table);
		/*
		 * List<Map<String, String>> chainTable = new ArrayList(); Map<String, String>
		 * chainMap = new HashMap<String,String>();
		 */

		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		System.out.println(LocalDateTime.now());
	}

	@And("I capture the value of {string} jpath from {string} filename")
	public void fetchStringValueFromFile(String jPaths, String fileName) { //
		Configuration configuration = Configuration.builder().build();
		File json = new File("./ResponseStore/" + fileName + ".json");
		String responseBody;
		try {
			responseBody = JsonPath.using(configuration).parse(json).jsonString();
			System.out.println(responseBody);
			Map<String, Object> contextMap = new HashMap<String, Object>();
			for (String path : jPaths.split(";")) {
				String key = path.substring(path.lastIndexOf(".") + 1, path.length());
				contextMap.put(key, JsonUtils.getJSonObjectValue(responseBody, path));
				System.out.println("value is " + String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path))); // Constants.ResponseData=
				String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));

				apiTestContext.getApiTestBase().contextMap = contextMap;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Given("I capture the value of {string} jpath as string from {string} filename")
	public void fetchStringValueFromFileAsVariable(String jPaths, String fileName) throws InterruptedException { //
		Configuration configuration = Configuration.builder().build();
		File json = new File("./ResponseStore/" + fileName + ".json");
		String responseBody;
		Thread.sleep(5000);
		try {
			responseBody = JsonPath.using(configuration).parse(json).jsonString();
			System.out.println(responseBody);
			Map<String, Object> contextMap = new HashMap<String, Object>();
			for (String path : jPaths.split(";")) {
				String key = path.substring(path.lastIndexOf(".") + 1, path.length());
				contextMap.put(key, JsonUtils.getJSonObjectValue(responseBody, path));
				System.out.println("value is " + String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path))); // Constants.ResponseData=
				String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
				str_data = String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
				apiTestContext.getApiTestBase().contextMap = contextMap;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Given("I capture the value of quote_id in {string} jpath as string from {string} filename")
	public void fetchStringQuoteIdFromFileAsVariable(String jPaths, String fileName) throws InterruptedException { //
		Configuration configuration = Configuration.builder().build();
		File json = new File("./ResponseStore/" + fileName + ".json");
		String responseBody;
		Thread.sleep(5000);
		try {
			responseBody = JsonPath.using(configuration).parse(json).jsonString();
			System.out.println(responseBody);
			Map<String, Object> contextMap = new HashMap<String, Object>();
			for (String path : jPaths.split(";")) {
				String key = path.substring(path.lastIndexOf(".") + 1, path.length());
				contextMap.put(key, JsonUtils.getJSonObjectValue(responseBody, path));
				System.out.println("value is " + String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path))); // Constants.ResponseData=
				String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
				quote_id = String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
				apiTestContext.getApiTestBase().contextMap = contextMap;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("I store the response as {string} name")
	public void postApplication(String name) throws InterruptedException {
		try {
			System.out.println("I am starting to store it in file");
			FileWriter file = new FileWriter("./ResponseStore/" + name + ".json");
			file.write(apiTestContext.getApiTestBase().response.prettyPrint());
			file.flush();
			file.close();
		} catch (IOException e) {
			System.out.println("failed");
		}
	}

	@And("I add request headers with {string} japth value from {string} file")
	public void setUpSpecificationWithFile(DataTable dataTable, String jPaths, String fileName) throws Throwable {
		Configuration configuration = Configuration.builder().build();
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, String> HeaderMaps = new HashMap<String, String>();
		File json = new File("./ResponseStore/" + fileName + ".json");
		String responseBody;
		try {
			responseBody = JsonPath.using(configuration).parse(json).jsonString();
			System.out.println(responseBody);
			Map<String, Object> contextMap = new HashMap<String, Object>();
			for (String path : jPaths.split(";")) {
				String key = path.substring(path.lastIndexOf(".") + 1, path.length());
				contextMap.put(key, JsonUtils.getJSonObjectValue(responseBody, path));
				System.out.println("value is " + String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path))); // Constants.ResponseData=
				String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
				String Jpathvalue = String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
				apiTestContext.getApiTestBase().contextMap = contextMap;

				for (int row = 0; row < table.size(); row++) {
					HeaderMaps.put(table.get(row).get("HeaderName"), Jpathvalue);
				}
				if (apiTestContext.getApiTestBase().specification == null) {
					apiTestContext.getApiTestBase().specification = RestAssuredUtils.getSpec().build();
				}
				apiTestContext.getApiTestBase().specification.headers(HeaderMaps);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("I modify request with {string} body with chain value of {string} jpath")
	public void modifyPayloadWithChainData(String fileName, String jPaths) throws InterruptedException {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));

		/*
		 * List<Map<String, String>> chainTable = new ArrayList(); Map<String, String>
		 * chainMap = new HashMap<String,String>();
		 */
		String[] paths = jPaths.split(";");
		for (String path : paths) {
			String key = path.substring(path.lastIndexOf(".") + 1, path.length());
			Object value = apiTestContext.getApiTestBase().contextMap.get(key);
			System.out.println("value is" + String.valueOf(value));
			request = JsonUtils.ModifyJSON(request, path, value);
			System.out.println("I am in 2nd key ->" + key);
			System.out.println("I am in 2nd path ->" + path);
		}
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		System.out.println(LocalDateTime.now());
	}

	@When("I modify the fields in same payload with chain value of {string} jpath")
	public void modifySamePayloadWithChainData(String jPaths) {

		String request = apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());

		String[] paths = jPaths.split(";");
		for (String path : paths) {
			String key = path.substring(path.lastIndexOf(".") + 1, path.length());
			Object value = apiTestContext.getApiTestBase().contextMap.get(key);
			System.out.println("value is" + String.valueOf(value));
			request = JsonUtils.ModifyJSON(request, path, value);
			System.out.println("I am in 2nd key ->" + key);
			System.out.println("I am in 2nd path ->" + path);
		}
		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		System.out.println(LocalDateTime.now());

	}

	@And("I store the quote_id in {string} request at {string} jpath")
	public void postApplicationStoringQuoteID(String fileName, String jPaths) throws InterruptedException {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
		String request = null;
		try {
			request = JsonPath.using(configuration).parse(json).jsonString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
		apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
				ResourceURIS.getResourceURI(fileName));

		String[] paths = jPaths.split(";");
		for (String path : paths) {
			String key = path.substring(path.lastIndexOf(".") + 1, path.length());
			// Object value = apiTestContext.getApiTestBase().contextMap.get(key);
			// System.out.println("value is"+String.valueOf(value));
			request = JsonUtils.ModifyJSON(request, path, quote_id);
			System.out.println("I am in 2nd key ->" + key);
			System.out.println("I am in 2nd path ->" + path);
		}

		apiTestContext.getApiTestBase().requestMap.replace(WS_PayloadsHeaders.PAYLOAD.name(), request);
		apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name());

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		System.out.println(LocalDateTime.now());

	}

	@And("I Set Up Bearer Token for CureBay from {string} jpath of {string} response file")
	public void setUpBearerToken(String path, String fileName) throws Throwable {
		Configuration configuration = Configuration.builder().build();
		File json = new File("./ResponseStore/" + fileName + ".json");
		String responseBody;
		responseBody = JsonPath.using(configuration).parse(json).jsonString();
		System.out.println(responseBody);
		Map<String, Object> contextMap = new HashMap<String, Object>();
		String key = path.substring(path.lastIndexOf(".") + 1, path.length());
		contextMap.put(key, JsonUtils.getJSonObjectValue(responseBody, path));
		System.out.println("value is " + String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path))); // Constants.ResponseData=
		String Value = String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
		String ApiToken = "Bearer " + Value;
		// ApiTestBase.BearerToken = ApiToken;
		Map<String, String> HeaderMaps = new HashMap<String, String>();
		HeaderMaps.put("Authorization", ApiToken);
		if (apiTestContext.getApiTestBase().specification == null) {
			apiTestContext.getApiTestBase().specification = RestAssuredUtils.getSpec().build();
		}
		apiTestContext.getApiTestBase().specification.headers(HeaderMaps);
	}

	@And("I Set Up Header {string} and Value jpath of {string} from {string} response file")
	public void setUpsBearerToken(String keyName,String path, String fileName) throws Throwable {
		Configuration configuration = Configuration.builder().build();
		File json = new File("./ResponseStore/" + fileName + ".json");
		String responseBody;
		responseBody = JsonPath.using(configuration).parse(json).jsonString();
		System.out.println(responseBody);
		Map<String, Object> contextMap = new HashMap<String, Object>();
		String key = path.substring(path.lastIndexOf(".") + 1, path.length());
		contextMap.put(key, JsonUtils.getJSonObjectValue(responseBody, path));
		System.out.println("value is " + String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path))); // Constants.ResponseData=
		String Value = String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
		String ApiToken = Value;
		// ApiTestBase.BearerToken = ApiToken;
		Map<String, String> HeaderMaps = new HashMap<String, String>();
		HeaderMaps.put(keyName, ApiToken);
		if (apiTestContext.getApiTestBase().specification == null) {
			apiTestContext.getApiTestBase().specification = RestAssuredUtils.getSpec().build();
		}
		apiTestContext.getApiTestBase().specification.headers(HeaderMaps);
	}
	@And("I Add the {string} Header value of {string} jpath from {string} filename")
	public void fetchHeadersFromResponseFile(String Value, String jPaths, String fileName) { //
		Configuration configuration = Configuration.builder().build();
		File json = new File("./ResponseStore/" + fileName + ".json");
		String responseBody;
		try {
			responseBody = JsonPath.using(configuration).parse(json).jsonString();
			System.out.println(responseBody);
			Map<String, Object> contextMap = new HashMap<String, Object>();
			for (String path : jPaths.split(";")) {
				String key = path.substring(path.lastIndexOf(".") + 1, path.length());
				contextMap.put(key, JsonUtils.getJSonObjectValue(responseBody, path));
				System.out.println("value is " + String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path))); // Constants.ResponseData=
				String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
				String HeaderValue = String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
				apiTestContext.getApiTestBase().contextMap = contextMap;
				Map<String, String> HeaderMaps = new HashMap<String, String>();
				HeaderMaps.put(Value, HeaderValue);
				if (apiTestContext.getApiTestBase().specification == null) {
					apiTestContext.getApiTestBase().specification = RestAssuredUtils.getSpec().build();
				}
				apiTestContext.getApiTestBase().specification.headers(HeaderMaps);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}