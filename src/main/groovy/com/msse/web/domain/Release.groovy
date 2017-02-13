package com.msse.web.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.NotNull
import java.sql.Time
import java.time.LocalDate


/**
 * Created by z001hk8 on 2/7/17.
 */

@Entity
class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id

    @NotNull
    String title

    @NotNull @ManyToOne
    Artist artist

    @NotNull
    String type

    LocalDate date

    @OneToMany
    List<Songs> songs

}
