package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpecification, FilterableResponseSpecification responseSpecification, FilterContext filterContext){
        logRequest(requestSpecification);
        Response response = filterContext.next(requestSpecification,responseSpecification);//request is going to be executed
        logResponse(response);
        return response;//test for assertion
    }

    public void logRequest(FilterableRequestSpecification requestSpecification){
        logger.info("BASE URI: "+requestSpecification.getBaseUri());
        logger.info("Request Header: "+requestSpecification.getHeaders());
        logger.info("Request Payload: "+requestSpecification.getBody());
    }

    public void logResponse(Response response){
        logger.info("STATUS CODE: "+response.getStatusCode());
        logger.info("Response Header: "+response.getHeaders());
        logger.info("Response Body: "+response.getBody().prettyPrint());
    }

}
