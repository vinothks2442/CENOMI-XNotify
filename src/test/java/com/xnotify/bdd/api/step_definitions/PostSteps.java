package com.xnotify.bdd.api.step_definitions;

import java.io.File;


import java.io.FileReader;
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
import com.xnotify.bdd.integrations.common_utils.Constants;
import com.xnotify.bdd.integrations.common_utils.JsonUtils;
import com.xnotify.bdd.integrations.common_utils.ResourceURIS;
import com.xnotify.bdd.integrations.common_utils.RestAssuredUtils;
import com.xnotify.bdd.integrations.report_utils.ReportManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class PostSteps {

	private TestContext apiTestContext;

	public PostSteps(TestContext apiTestContext) {
		this.apiTestContext = apiTestContext;
	}

	/*
	 * Gets the uri and payload from db using request name and sends the post
	 * request
	 */
	@When("I post the request with {string} payload")
	public void postwithPayload(String fileName) {

		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
			File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
			String request = null;
			try {
				request = JsonPath.using(configuration).parse(json).jsonString();
				System.out.println("request"+request);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(fileName));

			apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		}
		System.out.println("request"+apiTestContext.getApiTestBase().specification);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));

	}
	@When("I post the request with {string} payload with path parameter")
	public void postwithPayloadandPathParam(String fileName, DataTable dataTable) {

		
		List<Map<String, String>> table = dataTable.asMaps();

        Map<String, Object> pathParams = new HashMap<String, Object>();
        for (int i = 0; i < table.size(); i++) {
            String value = table.get(i).get("Value");
            if (value == null)
                value = "";
            pathParams.put(table.get(i).get("Path"), value);
        }
        
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
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

			apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		}

		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,pathParams,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));

	}

	@And("I post the request to endpoint")
	public void postRequest() {
		// apiTestContext.getApiTestBase().specification.auth().oauth2("3b87b2db-f7df-4d18-a3ee-fbc16edac027");
		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
                System.out.println(apiTestContext.getApiTestBase().response.asString());

	}

	@And("^I post the request to endpoint without encoded url$")
	public void postRequestWithoutEncoded() {
		// apiTestContext.getApiTestBase().specification.auth().oauth2("3b87b2db-f7df-4d18-a3ee-fbc16edac027");
		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(
				apiTestContext.getApiTestBase().specification.urlEncodingEnabled(false),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
		System.out.println(apiTestContext.getApiTestBase().response.asString());
		
	}

	@When("I send the POST request with {string} filepath to {string} endpoint with path parameters and with {string} formParameter")
	public void i_send_the_post_request_with_something_file_to_something_endpoint_with_path_parameters(String FilePath,
			String enPointName, String formParameters, DataTable dataTable) {
		
		String path = "src/test/resources/input_files/"+FilePath;
		File file = new File(path);
		
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, Object> pathParams = new HashMap<String, Object>();

		for(Map<String, String> map : table){
			String key = map.get("path");
			String value = map.get("value");
			pathParams.put(key,value);
		}

		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), formParameters);

			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(enPointName));

			apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		}

		//post(RequestSpecification specification, Map<String, Object> pathParam, String formParameter,String resourceURI,
		//			String FilePath)
		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,
				pathParams, formParameters,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()), file.getAbsolutePath());
	}

	@When("I send the POST request to \"([^\"]*)\" endpoint")
	public void postwithEndPoint(String endPointName) {

		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
			Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();

			String request = null;

			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
			apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
					ResourceURIS.getResourceURI(endPointName));

			apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		}

		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,

				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));

	}
	
	
	
	@When("I post the Quote ID with {string} payload with path parameter")
	public void postQuoteidPayloadandPathParam(String fileName, DataTable dataTable) {

		
		List<Map<String, String>> table = dataTable.asMaps();

        Map<String, Object> pathParams = new HashMap<String, Object>();
        
		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
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

			apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		}

		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,pathParams,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));

	}
	//Naga
	@When("I send post request with {string} requestname and {string} jpath value from {string} response file and {string} jpath value from {string} response file")
	public void postwithPayloadWithChaindata1(String fileName,String path, String fileName0,String path1, String fileName1) throws ParseException, IOException {
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		//Map<String, Object> pathParams = new HashMap<String, Object>();
		String quote_idValue=null;
		String selected_quotation_id=null;
		File json = new File("./ResponseStore/" + fileName0 + ".json");
		String responseBody=null;
		
		try {
			responseBody = JsonPath.using(configuration).parse(json).jsonString();
			quote_idValue=String.valueOf(JsonUtils.getJSonObjectValue(responseBody, path));
			System.out.println("Value is " +quote_idValue); // Constants.ResponseData=
			//pathParams.put("quote_id", quote_idValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	File json1 = new File("./ResponseStore/" + fileName1 + ".json");
	String responseBody1=null;
	try {
		responseBody1 = JsonPath.using(configuration).parse(json1).jsonString();
		selected_quotation_id=String.valueOf(JsonUtils.getJSonObjectValue(responseBody1, path1));
		System.out.println("Value is " +selected_quotation_id); // Constants.ResponseData=
		//pathParams.put("selected_quotation_id", selected_quotation_id);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	File filepath = new File(Constants.JSONINPUT_DIR+ fileName+".json");
	
	FileReader reader = new FileReader(filepath);
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
   
	jsonObject.put("quote_id", quote_idValue);
    jsonObject.put("selected_quotation_id", selected_quotation_id);
    FileWriter file=new FileWriter(filepath);
    file.write(jsonObject.toJSONString());
	file.flush();
	file.close();
	
	
	File jsonFile = new File(Constants.JSONINPUT_DIR + fileName + ".json");
	String request = null;
	try {
		request = JsonPath.using(configuration).parse(jsonFile).jsonString();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
	apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
	apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
			ResourceURIS.getResourceURI(fileName));

	apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);


	apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,
		apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()),
		apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
ReportManager.logInfoAPI(LocalDateTime.now().toString());
//System.out.println("Get request response: "+apiTestContext.getApiTestBase().response.prettyPrint());
ReportManager.logInfoAPI("<details><summary><font color=\"green\"><b>Click to view Response</b></font></summary><p><pre>"+apiTestContext.getApiTestBase().response.prettyPrint()+"</pre></script></p></details>");
	
	
	
	}
	@And("I send post request with {string} requestname and {string} jpath value as path parameter from {string} responsefile")
	public void getwithPayloadWithChaindata(String fileName, String jPaths, String responseFileName,
			DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		Map<String, Object> pathParams = new HashMap<String, Object>();
		File responseFile = new File("./ResponseStore/" + responseFileName + ".json");
		String responseBody;
		try {
			responseBody = JsonPath.using(configuration).parse(responseFile).jsonString();
			System.out.println(responseBody);
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

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);

		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,
				pathParams, apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
		System.out.println("Get request response: " + apiTestContext.getApiTestBase().response.asString());
		ReportManager.logInfoAPI(apiTestContext.getApiTestBase().response.asString());

	}

	

	@When("I post the generate OTP request with {string} payload")
	public void postGenerateOTP(String fileName) {

		if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
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

		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		
		}

		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));

	}
	@When("I post the request with {string} without payload")
    public void postwithoutPayload(String fileName) {
        if (apiTestContext.getApiTestBase().requestMap.isEmpty()) {
            Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
            //File json = new File(Constants.JSONINPUT_DIR + fileName + ".json");
            //String request = null;

            //apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.PAYLOAD.name(), request);
            apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.REQUEST_NAME.name(), fileName);
            apiTestContext.getApiTestBase().requestMap.put(WS_PayloadsHeaders.RESOURCE_URI.name(),
                    ResourceURIS.getResourceURI(fileName));

            apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
        }

        apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,
                apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));

    }
	@When("I send post request with {string} requestname with path parameter")
	public void postRequestWithpathParam(String fileName, DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Configuration configuration = Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build();
		Map<String, Object> pathParams = new HashMap<String, Object>();	
		Map<String, Object> contextMap = new HashMap<String, Object>();
				apiTestContext.getApiTestBase().contextMap = contextMap;
				for (int i = 0; i < table.size(); i++) {
					pathParams.put(table.get(i).get("Path"), table.get(i).get("Value"));
				}
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
		apiTestContext.getApiTestBase().specification.baseUri(RestAssuredUtils.baseURI);
		apiTestContext.getApiTestBase().response = RestAssuredUtils.post(apiTestContext.getApiTestBase().specification,
				pathParams, apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.PAYLOAD.name()),
				apiTestContext.getApiTestBase().requestMap.get(WS_PayloadsHeaders.RESOURCE_URI.name()));
		System.out.println("Post request response: " + apiTestContext.getApiTestBase().response.asString());
//		ReportManager.logInfo("<details><summary><font color=\"green\"><b>Click to view Response</b></font></summary><p><pre>"+apiTestContext.getApiTestBase().response.prettyPrint()+"</pre></script></p></details>");
		ReportManager.logInfoAPI(apiTestContext.getApiTestBase().response.asString());
	}
	
}
