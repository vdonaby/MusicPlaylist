package com.msse.web.controller

import com.msse.web.domain.Music
import com.msse.web.domain.Songs
import com.msse.web.service.SearchRepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by z001hk8 on 3/10/17.
 */

@RestController
class MusicController {

    @Autowired
    SearchRepositoryService searchRepositoryService

    @GetMapping("/music/name/{wildcard}")
    Music getSongByTitleAndArtistName(@PathVariable wildcard) {
        return searchRepositoryService.search(wildcard)
    }
}
