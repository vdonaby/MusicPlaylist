package com.msse.web.domain

import com.msse.web.utilities.ValidPassword
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotBlank

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.xml.bind.ValidationException


/**
 * Created by z001hk8 on 2/7/17.
 */

@Entity
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id

    @NotNull @Email @Column(unique=true)
    String Email

    @NotNull @NotBlank @ValidPassword
    String password

    @NotNull
    String name

    @OneToMany
    List<Playlist> playlists;



}


