package com.cgi.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.RequestMethod;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Component
public class WireMockStub{

    private String responseText = "hello world";
    private String responseJson = "[]";

    public void config(WireMockServer wireMockServer) {
        wireMockServer.stubFor(any(urlMatching("/wiremock.*")).atPriority(Integer.MAX_VALUE)
                .willReturn(aResponse().withBody(responseText)));
        wireMockServer.stubFor(any(urlMatching("/aircraft.*")).atPriority(Integer.MAX_VALUE)
                .willReturn(aResponse().withBody(responseJson)));
    }

    public void update(WireMockServer wireMockServer, RequestMethod method, String uri, String responseBody) {
        if (method == RequestMethod.GET) {
            wireMockServer.stubFor(get(urlMatching(uri)).atPriority(Integer.MAX_VALUE)
                    .willReturn(aResponse().withBody(responseBody)));
        } else if (method == RequestMethod.POST) {
            wireMockServer.stubFor(post(urlMatching(uri)).atPriority(Integer.MAX_VALUE)
                    .willReturn(aResponse().withBody(responseBody)));
        } else if (method == RequestMethod.PUT) {
            wireMockServer.stubFor(put(urlMatching(uri)).atPriority(Integer.MAX_VALUE)
                    .willReturn(aResponse().withBody(responseBody)));
        } else {
            wireMockServer.stubFor(any(urlMatching(uri)).atPriority(Integer.MAX_VALUE)
                    .willReturn(aResponse().withBody(responseBody)));
        }
    }
}
