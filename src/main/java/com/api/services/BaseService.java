package com.api.services;


import com.api.models.request.LoginRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseService { // Wrapper for Rest Assured
    //Base Url
    // Creating the Request
    // Handling the Response

    public static final String BASE_URL = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification ;

    public BaseService (){
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response postRequest(LoginRequest payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }
}
