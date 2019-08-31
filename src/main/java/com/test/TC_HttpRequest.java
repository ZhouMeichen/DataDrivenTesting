package com.test;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.HttpHandler;
import util.JSONHandler;

@Listeners(util.Listener.class)
public class TC_HttpRequest {
    @Test
    public void testhttp() {
        
        String[][] header = new String[][] {{"Content-Type","application/json; charset=utf-8"}};
        
        String body = "{\r\n" + 
                "    \"name\": \"morpheus\",\r\n" + 
                "    \"job\": \"leader\"\r\n" + 
                "}";
        
        String schema = "{\r\n" + 
                "    \"type\": \"object\",\r\n" + 
                "    \"properties\": {\r\n" + 
                "        \"name\": {\r\n" + 
                "            \"type\": \"string\"\r\n" + 
                "        },\r\n" + 
                "        \"job\": {\r\n" + 
                "            \"type\": \"string\"\r\n" + 
                "        },\r\n" + 
                "        \"id\": {\r\n" + 
                "            \"type\": \"string\"\r\n" + 
                "        },\r\n" + 
                "        \"createdAt\": {\r\n" + 
                "            \"type\": \"string\"\r\n" + 
                "        }\r\n" + 
                "    },\r\n" + 
                "    \"additionalProperties\": false,\r\n" + 
                "    \"required\": [\"name\", \"job\", \"id\", \"createdAt\"]\r\n" + 
                "}";
        
        HttpHandler http = new HttpHandler("post");
        http.setUri("https://reqres.in/api/users");
        http.setHeaders(header);
        http.setBodyData(body);
        http.sendRequest();
        
        JSONHandler jh = new JSONHandler();
        SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(jh.validateJSONSchema(http.getResponseBody(), schema), "The JSON Schema is not as expected");


            softAssert.assertTrue(http.getStatusCode()==201, "The status code is not 201");
        
            softAssert.assertTrue(http.containsHeader("Content-Type"), "There is no Content-Type header");
        
            softAssert.assertTrue(http.getContentType().contains("application/json"), "Content type is not json");
        
            softAssert.assertTrue(http.getReasonPhrase().equals("Created"), "Message of status line is wrong");

            softAssert.assertTrue(http.getResponseTime()<2000, "Response time is higher than 2,000 ms");
            softAssert.assertAll();

    }
}
