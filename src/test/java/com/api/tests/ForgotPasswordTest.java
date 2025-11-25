package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test(testName = "VerifyForgotPassword",description = "Test case verifies forgot password api")
    public void verifyForgotPassword(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("abc@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
