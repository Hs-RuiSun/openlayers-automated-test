package com.cgi.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.RequestMethod;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

public class WireMockStub implements TestRule{
    
    private String responseText = "hello world";
    private String responseJson = "[]";
    
    public void config(WireMockServer wireMockServer) {
        wireMockServer.stubFor(any(urlMatching("/wiremock.*")).atPriority(Integer.MAX_VALUE)
                .willReturn(aResponse().withBody(responseText)));
        wireMockServer.stubFor(any(urlMatching("/aircraft.*")).atPriority(Integer.MAX_VALUE)
                .willReturn(aResponse().withBody(responseJson)));
    }
    
    public void update(WireMockServer wireMockServer, RequestMethod method, String uri, String responseBody) {
        if(method == RequestMethod.GET) {
            wireMockServer.stubFor(get(urlMatching(uri)).atPriority(Integer.MAX_VALUE)
                    .willReturn(aResponse().withBody(responseBody)));
        }else if(method == RequestMethod.POST) {
            wireMockServer.stubFor(post(urlMatching(uri)).atPriority(Integer.MAX_VALUE)
                    .willReturn(aResponse().withBody(responseBody)));
        }else if(method == RequestMethod.PUT) {
            wireMockServer.stubFor(put(urlMatching(uri)).atPriority(Integer.MAX_VALUE)
                    .willReturn(aResponse().withBody(responseBody)));
        }else {
            wireMockServer.stubFor(any(urlMatching(uri)).atPriority(Integer.MAX_VALUE)
                    .willReturn(aResponse().withBody(responseBody)));
        }
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return base;
    }
}
