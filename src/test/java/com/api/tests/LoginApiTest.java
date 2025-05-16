package com.api.tests;

import com.api.models.reponse.LoginResponse;
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
        LoginResponse loginResponse =  response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getId());

        Assert.assertTrue(loginResponse.getToken() !=null);
        Assert.assertEquals(loginResponse.getEmail(), "lemzoxy24@gmail.comcd\r\n");
        Assert.assertEquals(loginResponse.getId(),3);
    }
}
