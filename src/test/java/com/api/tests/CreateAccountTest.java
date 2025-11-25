package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class CreateAccountTest {

    @Test(testName = "Create Account test",description = "This test verify the login API")
    public void createAccountTest(){
        SignUpRequest signUpRequest = new SignUpRequest.Builder().username("ajay1087")
                .email("parmarajay1087@gmail.com").firstName("Ajay").lastName("Parmar")
                .mobileNumber("1234567890").password("ajay1087").build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.asPrettyString(),"User registered successfully");
    }
}
