package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UpdateProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

@Listeners(com.api.listeners.TestListener.class)
public class UpdateProfileTest {

    @Test(testName = "UpdateProfileTest",description = "Verifies update profile functionality")
    public void updateProfileTest(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Ajay4580","Ajay4580"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String token = loginResponse.getToken();
        long mobileNumber = new Random().nextLong(1000000000L,9999999999L);

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest.Builder()
                .email(loginResponse.getEmail())
                .firstName("Ajay")
                .lastName("Parmar")
                .mobileNumber(Long.toString(mobileNumber))
                .id(loginResponse.getId())
                .username(loginResponse.getUsername())
                .build();
        response = userProfileManagementService.updateProfile(token,updateProfileRequest);

        UpdateProfileResponse updateProfileResponse = response.as(UpdateProfileResponse.class);
        System.out.println(updateProfileResponse.toString());
        Assert.assertEquals(Long.toString(mobileNumber),updateProfileResponse.getMobileNumber());
    }
}
