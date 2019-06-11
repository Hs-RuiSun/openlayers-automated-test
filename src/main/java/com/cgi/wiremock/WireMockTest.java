package com.cgi.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes = WiremockConfig.class)
@ExtendWith({SpringExtension.class})
@TestPropertySource(locations = "classpath:/config-test.properties")
public class WireMockTest {
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
