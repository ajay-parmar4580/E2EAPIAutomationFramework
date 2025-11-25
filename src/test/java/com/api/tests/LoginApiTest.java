package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTest {

    @Test(testName = "Verify login test",description = "This test verify the login API")
    public void loginTest(){
        LoginRequest loginRequest = new LoginRequest("Ajay4580","Ajay4580");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getEmail());
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(loginResponse.getToken() != null);
        Assert.assertEquals(loginResponse.getEmail(),"ajaysingh.parmar4580@gmail.com");
    }
}
