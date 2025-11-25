package com.api.base;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//Wrapper for Rest Assured
    //Handles base uri
    //Handles request creation
    //Handles the response
public class BaseService {
    private static final String BASE_URL = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilter());
    }
    public BaseService() {
        this.requestSpecification = RestAssured.given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }

    protected Response getRequest(String endpoint){
        return  requestSpecification.get(endpoint);
    }

    protected void setToken(String token){
        requestSpecification.header("Authorization","Bearer "+token);
    }

//    protected Response postRequest(String baseUri, Object payload, String endpoint){
//        return requestSpecification.baseUri(baseUri).contentType(ContentType.JSON).body(payload).post(endpoint);
//    }
}
