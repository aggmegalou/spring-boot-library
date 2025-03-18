package com.luv2code.springbootlibrary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.luv2code.springbootlibrary.entity.Book;

@Configuration
public class MyDataRestConfig {

    private String theAllowedOrigins = "http://localhost:300";

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
        HttpMethod[] theUnsupportedActions = {
            HttpMethod.POST, 
            HttpMethod.PATCH,
            HttpMethod.DELETE, 
            HttpMethod.PUT}; 
        
        config.exposeIdsFor(Book.class);

        diasableHttpMethod(Book.class, config, theUnsupportedActions);
        /*Configure CORS Mapping */
        cors.addMapping(config.getBasePath() + "/**")
                 .allowedOrigins(theAllowedOrigins);
        
    }
    private void diasableHttpMethod(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions){
        config.getExposureConfiguration()
            .forDomainType(theClass)
            .withItemExposure((metdata, HttpMethods) ->
                HttpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, httpMethods) ->
                   httpMethods.disable(theUnsupportedActions));



    }

}
