package com.msse.web.controller

import com.msse.web.domain.Account
import com.msse.web.domain.Playlist

import com.msse.web.repository.AccountRepository
import com.msse.web.repository.PlaylistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.awt.PageAttributes.MediaType
/**
 * Created by z001hk8 on 3/5/17.
 */

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaylistControllerFunctionalTest extends Specification{

    @Autowired
    AccountRepository accountRepository

    @Autowired
    PlaylistRepository playlistRepository

    @Autowired
    private TestRestTemplate testRestTemplate

    /*
    Requirement P1
     */
    def "add a playlist"() {

        setup:

        def account = new Account(email: 'validplaylist@gmail.com', password: 'Password1', name: "Test Account")
        accountRepository.save(account)
        def myPlaylist = new Playlist(name: 'myPlaylist', account: account)
        playlistRepository.save(myPlaylist)

        when:
        ResponseEntity<Playlist> response = this.testRestTemplate.postForEntity("/playlist", myPlaylist, Playlist.class)

        then:
        response.statusCode == HttpStatus.OK
        System.out.println('System response: ' + response.toString())
        Playlist actual = response.body
        actual.name == "myPlaylist"
        actual.account.id == account.id

    }

    def "add a song to a playlist"() {

        setup:

        def account = new Account(email: 'validplaylist@gmail.com', password: 'Password1', name: "Test Account")
        accountRepository.save(account)
        def myPlaylist = new Playlist(name: 'myPlaylist', account: account)
        playlistRepository.save(myPlaylist)

        when:
        ResponseEntity<Playlist> response = this.testRestTemplate.postForEntity("/playlist", myPlaylist, Playlist.class)

        then:
        response.statusCode == HttpStatus.OK
        System.out.println('System response: ' + response.toString())
        Playlist actual = response.body
        actual.name == "myPlaylist"
        actual.account.id == account.id

    }
}
