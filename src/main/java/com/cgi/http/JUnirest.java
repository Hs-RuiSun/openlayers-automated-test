package com.cgi.http;

import com.cgi.junit.Aircraft;
import com.cgi.mock.WireMockStub;
import com.cgi.spring.Config;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.http.RequestMethod;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wiremock.com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration( classes = Config.class )
@RunWith(SpringJUnit4ClassRunner.class)
public class JUnirest {
    @Rule
    public WireMockStub wireMockStub = new WireMockStub();
    
    @Autowired
    private WireMockServer wireMockServer;
    
    @Value("${wiremock.protocol}://${wiremock.domain}:${wiremock.port}") 
    private String url;
    
    @Before
    public void setUp() {
        wireMockStub.config(wireMockServer);
    }
    
    @Test
    public void testPost() throws UnirestException, JsonProcessingException {
        Aircraft aircraft = new Aircraft(1, "LFBO", "LFBT", true);
        String json = (new ObjectMapper()).writeValueAsString(aircraft);
        HttpResponse<String> response = Unirest.post(url + "/aircraft.*")
                .header("Content-type", "application/json")
                .body(json)
                .asString();
        assertNotNull(response);
        System.out.println(response.getBody());
    }
    
    @Test
    @Ignore
    public void testGetJson() throws UnirestException, JsonParseException, JsonMappingException, IOException {
        String responseJson = "[{\"id\":307913,\"ori\":\"LFBO\",\"dst\":\"LFBT\",\"tracked\":true},"
                + "{\"id\":305962,\"ori\":\"LFBO\",\"dst\":\"LFRZ\",\"tracked\":true}]";
        wireMockStub.update(wireMockServer, RequestMethod.GET, "/aircraft.*", responseJson);
        
        HttpResponse<JsonNode> httpResponse = Unirest.get(url + "/aircraft").asJson();
        ObjectMapper mapper = new ObjectMapper();
        List<Aircraft> list = mapper.readValue(httpResponse.getRawBody(), new TypeReference<List<Aircraft>>(){ });
        assertEquals(2, list.size());
    }
    
    @Test
    @Ignore
    public void testGet() throws UnirestException {
        String responseText = "hey, it works";
        wireMockStub.update(wireMockServer, RequestMethod.GET, "/wiremock.*", responseText);
        
        HttpResponse<String> httpResponse = Unirest.get(url + "/wiremock").asString();
        assertEquals(200, httpResponse.getStatus());
        assertNotNull(httpResponse.getBody());
        assertEquals(responseText, httpResponse.getBody());
    }
}
