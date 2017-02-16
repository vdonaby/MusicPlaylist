package com.msse.web.domain

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
class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id

    @NotNull
    String title

    @NotNull @ManyToOne
    Release release

    @ManyToMany
    List<Playlist> playlists



}
