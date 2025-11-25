package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileTest {

    @Test(testName = "GetProfileInfo",description = "Get Profile information")
    public void getProfileInfoTest(){
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("Ajay4580","Ajay4580");
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String token = loginResponse.getToken();

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(token);
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(userProfileResponse.getEmail(),"ajaysingh.parmar4580@gmail.com");
        System.out.println(userProfileResponse.toString());
    }

}
