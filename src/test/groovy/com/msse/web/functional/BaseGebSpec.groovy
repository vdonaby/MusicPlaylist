package com.msse.web.functional

import geb.spock.GebReportingSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseGebSpec extends GebReportingSpec {
    @Autowired
    RestTemplate restTemplate

    @Autowired
    TestRestTemplate testRestTemplate

    MockRestServiceServer mockServer

    def cleanup() {
        mockServer.verify()
    }

    @Value('${local.server.port}')
    int port

    def setup() {
        browser.setBaseUrl("http://localhost:${port}")
        mockServer = MockRestServiceServer.createServer(restTemplate)
    }

}