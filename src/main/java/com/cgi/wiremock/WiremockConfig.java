package com.cgi.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/config.properties")
public class WiremockConfig {
    @Bean
    public Options wireMockOptions(
            @Value("${wiremock.protocol}") String protocol,
            @Value("${wiremock.domain}") String domain,
            @Value("${wiremock.port}") Integer port,
            @Value("${wiremock.containerThreads}") Integer containerThreads,
            @Value("${wiremock.debugLogging}") Boolean debugLogging) {
        WireMockConfiguration wireMockConfiguration = new WireMockConfiguration();
        if ("https".equalsIgnoreCase(protocol)) {
            wireMockConfiguration.httpsPort(port);
        } else {
            wireMockConfiguration.port(port);
        }
        wireMockConfiguration.containerThreads(containerThreads);
        if (debugLogging) {
            wireMockConfiguration.notifier(new ConsoleNotifier(true));
        }
        final int minThreadsForAsync = 5;
        final int threadsToLeaveForWireMock = 2;
        if (containerThreads > minThreadsForAsync) {
            wireMockConfiguration.asynchronousResponseEnabled(true);
            wireMockConfiguration.asynchronousResponseThreads(containerThreads - threadsToLeaveForWireMock);
        }

        wireMockConfiguration.disableRequestJournal();
        return wireMockConfiguration;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer(Options wireMockOptions) {
        return new WireMockServer(wireMockOptions);
    }

    @Bean
    public WireMock wireMock(WireMockServer wireMockServer) {
        return new WireMock(wireMockServer);
    }
}
