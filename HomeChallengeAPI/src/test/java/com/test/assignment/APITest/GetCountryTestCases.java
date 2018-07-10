package com.test.assignment.APITest;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;
import com.jayway.restassured.internal.path.json.JSONAssertion;
import com.test.assignment.APIBaseClass.TestBase;
import com.test.assignment.AssertionValues.AssertionValues;
import com.test.assignment.Client.RestClient;
import com.test.assignment.util.TestUtil;

public class GetCountryTestCases extends TestBase{
	
	TestBase testBase;
	
	String getCountryDetails;
	String getUSAResponse;
	String getGermanyResponse;
	String getUKTesponse;
	String getNonExistingCountryDetails;
	
	RestClient testRestClient;
	CloseableHttpResponse closeableHttpResponse;
	//PayloadData payloadData;
	JsonParser jsonParser = new JsonParser();
	/*String createUser;
	String deleteCretatedUser;*/

	
	
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException
	{
		testBase = new TestBase();
		getCountryDetails = properties.getProperty("url");
		getUSAResponse = properties.getProperty("urlforUSA");
		getGermanyResponse = properties.getProperty("urlForGermany");
		getUKTesponse = properties.getProperty("urlForUniteKingdom");
		getNonExistingCountryDetails = properties.getProperty("urlForNonExistingCountry");
		
	}
	
	@Test(priority =1)
	public void getAllCountryDetails() throws ClientProtocolException, IOException, JSONException
	{
		testRestClient = new RestClient();
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Accept", "application/json");
		
		closeableHttpResponse = testRestClient.get(getCountryDetails, headerMap);
		
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is --->"+statusCode);
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		//JSONArray jsonArray = new JSONArray(responseString);
		String responseJSONObject = new JSONObject(responseString).toString();
		System.out.println("Response from API is --->"+responseJSONObject);
		
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionUSA_name),"passed");
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionGermany_name),"passed");	
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionUK_name),"passed");
	}
	
	
	@Test(priority =2)
	public void getUSACountryDetails() throws ClientProtocolException, IOException, JSONException
	{

		
		testRestClient = new RestClient();
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Accept", "application/json");
		
		closeableHttpResponse = testRestClient.get(getUSAResponse, headerMap);
		
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is --->"+statusCode);
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		//JSONArray jsonArray = new JSONArray(responseString);
		String responseJSONObject = new JSONObject(responseString).toString();
		System.out.println("Response from API is --->"+responseJSONObject);
		
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionUSA_name),"passed");
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionUSA_alpha2_code),"passed");
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionUSA_alpha3_code),"passed");
				
		}
	
	@Test(priority =3)
	public void getDECountryDetails() throws ClientProtocolException, IOException, JSONException
	{

		
		testRestClient = new RestClient();
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Accept", "application/json");
		
		closeableHttpResponse = testRestClient.get(getGermanyResponse, headerMap);
		
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is --->"+statusCode);
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		//JSONArray jsonArray = new JSONArray(responseString);
		String responseJSONObject = new JSONObject(responseString).toString();
		System.out.println("Response from API is --->"+responseJSONObject);
		
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionGermany_name),"passed");
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionGermany_alpha2_code),"passed");
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionGermany_alpha3_code),"passed");
				
		}
	
	@Test(priority =4)
	public void getGBCountryDetails() throws ClientProtocolException, IOException, JSONException
	{

		
		testRestClient = new RestClient();
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Accept", "application/json");
		
		closeableHttpResponse = testRestClient.get(getUKTesponse, headerMap);
		
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is --->"+statusCode);
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		//JSONArray jsonArray = new JSONArray(responseString);
		String responseJSONObject = new JSONObject(responseString).toString();
		System.out.println("Response from API is --->"+responseJSONObject);
		
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionUK_name),"passed");
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionUK_alpha2_code),"passed");
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.responseAssertionUK_alpha3_code),"passed");
				
		}
	
	@Test(testName = "inexisting country", priority = 5)
	public void inexistingCountryTest() throws ClientProtocolException, IOException, JSONException
	{
		testRestClient = new RestClient();
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Accept", "application/json");
		
		closeableHttpResponse = testRestClient.get(getNonExistingCountryDetails, headerMap);
		
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is --->"+statusCode);
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		//JSONArray jsonArray = new JSONArray(responseString);
		String responseJSONObject = new JSONObject(responseString).toString();
		System.out.println("Response from API is --->"+responseJSONObject);
		
		Assert.assertTrue(responseJSONObject.contains(AssertionValues.nonExistingCountryERROR_Message),"passed");
		
	}

}
