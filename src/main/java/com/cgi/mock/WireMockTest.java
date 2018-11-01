package com.cgi.mock;

import com.cgi.spring.Config;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration( classes = Config.class )
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:/config.properties")
public class WireMockTest {
    @Autowired
    private WireMockServer wireMockServer;
    
    @Test
    public void testResponse() throws UnirestException {
        String responseText = "hey, it works";
        String url = "http://localhost:9001/wiremock";
        wireMockServer.stubFor(get(urlMatching("/wiremock.*")).atPriority(Integer.MAX_VALUE)
                .willReturn(aResponse().withBody(responseText)));
        
        assertNotNull(Unirest.get(url).asString());
        HttpResponse<String> response = Unirest.get(url).asString();
        assertEquals(responseText, response.getBody());
    }
}
