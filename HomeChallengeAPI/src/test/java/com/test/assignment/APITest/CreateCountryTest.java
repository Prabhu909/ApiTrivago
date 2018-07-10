package com.test.assignment.APITest;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonParser;
import com.test.assignment.APIBaseClass.TestBase;
import com.test.assignment.Client.RestClient;

public class CreateCountryTest extends TestBase{
	
	TestBase testBase;
	
	String createCountry;
	
	RestClient testRestClient;
	CloseableHttpResponse closeableHttpResponse;
	//PayloadData payloadData;
	JsonParser jsonParser = new JsonParser();
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException
	{
		testBase = new TestBase();
		createCountry = properties.getProperty("createCountryURL");
	}
	
	@Test
	public void createCountryTest() throws ClientProtocolException, IOException
	{
	testRestClient = new RestClient();
	
	HashMap<String, String> headerMap = new HashMap<String, String>();
	headerMap.put("Content-Type", "application/json");
	
	headerMap.put("Accept", "application/json");
	
	
	FileReader testPayloadData = new FileReader(System.getProperty("user.dir")+"/src/main/java/com/test/assignment/testDataPayload/CreateCountry.json");
	String payloadData = jsonParser.parse(testPayloadData).getAsJsonObject().toString();
	System.out.println(payloadData);
	
	closeableHttpResponse = testRestClient.post(createCountry, payloadData, headerMap);
	int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
	System.out.println(statusCode);
	
	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
	JSONObject responseJson = new JSONObject();
	
	System.out.println(responseString);	
	
	}
}
