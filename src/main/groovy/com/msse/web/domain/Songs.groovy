package com.msse.web.domain

import javax.persistence.*
import javax.validation.constraints.NotNull
/**
 * Created by z001hk8 on 2/7/17.
 */

@Entity
class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id

    @NotNull
    String title

    @NotNull @ManyToOne
    Release release

    @ManyToMany
    List<Playlist> playlists

}
