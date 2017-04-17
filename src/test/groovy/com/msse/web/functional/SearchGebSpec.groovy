package com.msse.web.functional

import org.hamcrest.core.StringContains
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate
import spock.lang.Ignore
import spock.lang.Specification

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore

class SearchGebSpec extends Specification {

    @Autowired
    RestTemplate restTemplate

    @Autowired
    TestRestTemplate testRestTemplate

    MockRestServiceServer mockServer

    def "get artist"() {
        setup:
        mockServer = MockRestServiceServer.createServer(restTemplate)

        mockServer.expect(requestTo(new StringContains("/v1/artists/1vCWHaC5f2uS3yhpwWbIA6.json"))).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON_UTF8))
        when:
        def responseEntity = testRestTemplate.exchange("/v1/artists/1vCWHaC5f2uS3yhpwWbIA6", HttpMethod.GET,
                getAuthorizedHttpEntity(), Map)

        then:
        mockServer.verify()
        responseEntity.body == [:]
        responseEntity.statusCode == HttpStatus.OK
    }

    def "get artist - server errors out"() {
        setup:
        mockServer = MockRestServiceServer.createServer(restTemplate)

        mockServer.expect(requestTo(new StringContains("/v1/artists/1vCWHaC5f2uS3yhpwWbIA6.json"))).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON_UTF8))
        when:
        def responseEntity = testRestTemplate.exchange("/v1/artists/1vCWHaC5f2uS3yhpwWbIA6", HttpMethod.GET,
                getAuthorizedHttpEntity(), Map)

        then:
        mockServer.verify()
        responseEntity.body == [:]
        responseEntity.statusCode == HttpStatus.INTERNAL_SERVER_ERROR
    }

    def "get artist - bad request"() {
        setup:
        mockServer = MockRestServiceServer.createServer(restTemplate)

        mockServer.expect(requestTo(new StringContains("/v1/artists/1vCWHaC5f2uS3yhpwWbIA6.json"))).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON_UTF8))
        when:
        def responseEntity = testRestTemplate.exchange("/v1/artists/1vCWHaC5f2uS3yhpwWbIA6", HttpMethod.GET,
                getAuthorizedHttpEntity(), Map)

        then:
        mockServer.verify()
        responseEntity.body == [:]
        responseEntity.statusCode == HttpStatus.BAD_REQUEST
    }


    def "get album - server errors out"() {
        setup:
        mockServer = MockRestServiceServer.createServer(restTemplate)

        mockServer.expect(requestTo(new StringContains("/v1/albums/0sNOF9WDwhWunNAHPD3Baj.json"))).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON_UTF8))
        when:
        def responseEntity = testRestTemplate.exchange("/v1/albums/0sNOF9WDwhWunNAHPD3Baj", HttpMethod.GET,
                getAuthorizedHttpEntity(), Map)

        then:
        mockServer.verify()
        responseEntity.body == [:]
        responseEntity.statusCode == HttpStatus.INTERNAL_SERVER_ERROR
    }

    def "get album"() {
        setup:
        mockServer = MockRestServiceServer.createServer(restTemplate)

        mockServer.expect(requestTo(new StringContains("/v1/albums/0sNOF9WDwhWunNAHPD3Baj.json"))).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON_UTF8))
        when:
        def responseEntity = testRestTemplate.exchange("/v1/albums/0sNOF9WDwhWunNAHPD3Baj", HttpMethod.GET,
                getAuthorizedHttpEntity(), Map)

        then:
        mockServer.verify()
        responseEntity.body == [:]
        responseEntity.statusCode == HttpStatus.OK
    }

    def "get album - bad request"() {
        setup:
        mockServer = MockRestServiceServer.createServer(restTemplate)

        mockServer.expect(requestTo(new StringContains("/v1/albums/0sNOF9WDwhWunNAHPD3Baj.json"))).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON_UTF8))
        when:
        def responseEntity = testRestTemplate.exchange("/v1/albums/0sNOF9WDwhWunNAHPD3Baj", HttpMethod.GET,
                getAuthorizedHttpEntity(), Map)

        then:
        mockServer.verify()
        responseEntity.body == [:]
        responseEntity.statusCode == HttpStatus.BAD_REQUEST
    }


    def "get song"() {
        setup:
        mockServer = MockRestServiceServer.createServer(restTemplate)

        mockServer.expect(requestTo(new StringContains("v1/search?q=abba&type=track.json"))).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON_UTF8))
        when:
        def responseEntity = testRestTemplate.exchange("v1/search?q=abba&type=track", HttpMethod.GET,
                getAuthorizedHttpEntity(), Map)

        then:
        mockServer.verify()
        responseEntity.body == [:]
        responseEntity.statusCode == HttpStatus.OK
    }


    def "get song - server errors out"() {
        setup:
        mockServer = MockRestServiceServer.createServer(restTemplate)

        mockServer.expect(requestTo(new StringContains("v1/search?q=abba&type=track.json"))).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON_UTF8))
        when:
        def responseEntity = testRestTemplate.exchange("v1/search?q=abba&type=track", HttpMethod.GET,
                getAuthorizedHttpEntity(), Map)

        then:
        mockServer.verify()
        responseEntity.body == [:]
        responseEntity.statusCode == HttpStatus.INTERNAL_SERVER_ERROR
    }



    def "get song - bad request"() {
        setup:
        mockServer = MockRestServiceServer.createServer(restTemplate)

        mockServer.expect(requestTo(new StringContains("v1/search?q=abba&type=track.json"))).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON_UTF8))
        when:
        def responseEntity = testRestTemplate.exchange("v1/search?q=abba&type=track", HttpMethod.GET,
                getAuthorizedHttpEntity(), Map)

        then:
        mockServer.verify()
        responseEntity.body == [:]
        responseEntity.statusCode == HttpStatus.BAD_REQUEST
    }


}
