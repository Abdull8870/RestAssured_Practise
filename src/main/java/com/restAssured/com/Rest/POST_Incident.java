package com.restAssured.com.Rest;

import java.io.File;
import java.util.List;

import com.restAssured.com.BASE.Base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class POST_Incident extends Base {

	
			
	public static void postAnIncidentWithoutBody() {
		
		RestAssured.baseURI=ENDPOINT;
		
		RestAssured.authentication=RestAssured.basic(USERNAME,PASSWORD);
		
		
		Response res=RestAssured.given().contentType(ContentType.JSON).post();
		
		System.out.println(res.getStatusCode());
		
		System.out.println(res.getTime());
		
		System.out.println(res.prettyPrint());
		
		JsonPath jsonPath = res.jsonPath();
		
		System.out.println(jsonPath);
		
		
//		List<String> sysId = jsonPath.get("result.sys_id");
//	
//		System.out.println(sysId.get(0));
	}
	
	
	public static void postAnIncidentWithBody() {
		
		RestAssured.baseURI=ENDPOINT;
		RestAssured.authentication=RestAssured.basic(USERNAME, PASSWORD);
		
		File f=new File("./Data/Data.json");
		
		Response post = RestAssured.given().contentType(ContentType.JSON).body(f).post();
		
		System.out.println(post.prettyPrint());
		
		System.out.println(post.getStatusCode());
		
		JsonPath jsonPath = post.jsonPath();
		
		String list = jsonPath.get("result.short_description");
		
		System.out.println(list);
		
	}
	
	
	public static void main(String[] args) {
	    
		postAnIncidentWithoutBody();
		postAnIncidentWithBody();

	}

}
