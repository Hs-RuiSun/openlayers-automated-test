package com.cgi.mock;

import com.cgi.spring.Config;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration( classes = Config.class )
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:/config-test.properties")
public class WireMockTest {
    @Rule
    public WireMockStub wireMockStub = new WireMockStub();
    
    @Autowired
    private WireMockServer wireMockServer;
    
    @Value("${wiremock.protocol}://${wiremock.domain}:${wiremock.port}") 
    private String url;
    
    @Test
    public void testResponse() throws UnirestException {
        String responseText = "hey, it works";
        
        wireMockStub.config(wireMockServer);
        
        assertNotNull(Unirest.get(url + "/wiremock").asString());
        HttpResponse<String> response = Unirest.get(url + "/wiremock").asString();
        assertEquals(responseText, response.getBody());
    }
}
