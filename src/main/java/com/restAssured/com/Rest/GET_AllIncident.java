package com.restAssured.com.Rest;


import java.util.List;

import com.restAssured.com.BASE.Base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GET_AllIncident extends Base {
	
			
	public static void getAllIncident() {
		
		RestAssured.baseURI=ENDPOINT;
		
		RestAssured.authentication=RestAssured.basic(USERNAME,PASSWORD);
		
		
		Response res=RestAssured.get();
		
		System.out.println(res.getStatusCode());
		
		System.out.println(res.getTime());
		
//		System.out.println(res.prettyPrint());
		
		JsonPath jsonPath = res.jsonPath();
		
		List<String> sysId = jsonPath.get("result.sys_id");
	
		System.out.println(sysId.get(0));
	}
	
	public static void getAllIncidentWithParam() {
		

		RestAssured.baseURI=ENDPOINT;
		
		RestAssured.authentication=RestAssured.basic(USERNAME,PASSWORD);
		
		
		Response res=RestAssured.given().queryParam("sysparm_fields", "number,sys_id").get();	
		
		System.out.println(res.getStatusCode());
		
		System.out.println(res.getTime());
		
		System.out.println(res.prettyPrint());
		
	}
	
	
	public static void getAllIncidentAsXML() {
		
	    RestAssured.baseURI=ENDPOINT;
		
		RestAssured.authentication=RestAssured.basic(USERNAME,PASSWORD);
		
		Response response = RestAssured.given().queryParam("sysparm_fields", "number,sys_id").accept(ContentType.XML).get();
		
		XmlPath xmlPath = response.xmlPath();
		
		List<String> list = xmlPath.getList("response.result.sys_id");
		
		System.out.println(list);
	}
	
	
	

	

	
	public static void main(String[] args) {
		
		getAllIncident();
		getAllIncidentWithParam();
		
	}
	
}
