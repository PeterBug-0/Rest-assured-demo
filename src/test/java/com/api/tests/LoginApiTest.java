package com.api.tests;

import com.api.models.request.LoginRequest;
import com.api.services.AuthService;
import com.sun.net.httpserver.Request;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginApiTest {

    @Test (description = " Verify if login API is working ")
    public void loginTest(){
        LoginRequest loginRequest = new LoginRequest("Deoxygen24", "Lemz1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        System.out.println(response.asPrettyString());

    }
}
