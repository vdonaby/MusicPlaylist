package com.msse.web.domain

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

/**
 * Created by z001hk8 on 2/7/17.
 */

@Entity
class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id

    @NotNull
    @JsonProperty("name")
    String name

    @NotNull
    @ManyToOne
    @JsonProperty("account")
    Account account

    @ManyToMany
    @JsonProperty("songs")
    List<Songs> songs


}
