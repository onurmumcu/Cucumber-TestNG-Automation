package com.app.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import com.app.utilities.ConfigurationReader;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class JsonValidationOfRegions {
 

	@Test
	  public void warmUp() {
					
			given().accept(ContentType.JSON)
			.and().params("limit", 10)
			.when().get(ConfigurationReader.getProperty("hrapp.baseresturl")+"/regions")
			.then().assertThat().statusCode(200)
			.and().assertThat().contentType(ContentType.JSON)
			.and().assertThat().body("items.region_id", hasSize(4))
			.and().assertThat().body("items.region_name", hasItems("Europe", "Americas", "Asia", "Middle East and Africa"));//hasItems take varArgs multi
	
		//or this is the second way;;
			
			
	}
	@Test
	  public void warmUp2() {
			Response response= given().accept(ContentType.JSON)
					.and().params("limit", 10)
					.when().get(ConfigurationReader.getProperty("hrapp.baseresturl")+"/regions");
			
			
			JsonPath json=response.jsonPath();
			//this is 
			
			
			assertEquals(response.statusCode(),200);
			
			
			assertEquals(json.getInt("items[0].region_id"), 1);
			assertEquals(json.getString("items[0].region_name"),"Europe");
			
			assertEquals(json.getInt("items[1].region_id"), 2);
			assertEquals(json.getString("items[1].region_name"),"Americas");
			
			assertEquals(json.getInt("items[2].region_id"), 3);
			assertEquals(json.getString("items[2].region_name"),"Asia");
			
			assertEquals(json.getInt("items[3].region_id"), 4);
			assertEquals(json.getString("items[3].region_name"),"Middle East and Africa");
			
			
			
	}
	@Test
	  public void warmUp3() {
			Response response= given().accept(ContentType.JSON)
					.and().params("limit", 10)
					.when().get(ConfigurationReader.getProperty("hrapp.baseresturl")+"/regions");
			
			assertEquals(response.statusCode(),200);

			
			//Store Json 
			JsonPath json=response.jsonPath();
			
			
			//deserialize json to List<Map>
			List<Map> regions=json.getList("items", Map.class);
			
			//I create a Map list of expected results
			Map<Integer, String> expectedRegions=new HashMap<>();
			expectedRegions.put(1,"Europe");
			expectedRegions.put(2,"Americas");
			expectedRegions.put(3,"Asia");
			expectedRegions.put(4,"Middle East and Africa");
			
			for(Integer regionID:expectedRegions.keySet()) {//this is just for keys(1,2,3,4)
				System.out.println("looking for region:"+ regionID);
				for (Map map:regions ) {
					if(map.get("region_id")==regionID) {
						assertEquals(map.get("region_name"), expectedRegions.get(regionID));
					}
					
				}
				
			}
		}



	
	
	
	
//post scenario
//	{
//		
//		
//		given content type Json,
//		Accept tyoe Json, 
//		when I send POST request to regions url;		
//		"region_id":51,
//		"region_name": "area ilyas`"
//		then status code should be 200
//		response should match request body
//	}
}