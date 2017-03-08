package com.msse.web.domain

import com.fasterxml.jackson.annotation.JsonProperty
import com.msse.web.utilities.EncryptPassword
import com.msse.web.utilities.ValidPassword
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotBlank

import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.PrePersist
import javax.validation.constraints.NotNull


/**
 * Created by z001hk8 on 2/7/17.
 */

@Entity
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id

    @NotNull
    @Email
    @Column(unique=true)
    @JsonProperty("email")
    String Email

    @NotNull
    @NotBlank
    @ValidPassword
    @Convert(converter = EncryptPassword.class)
    @JsonProperty("password")
    String password

    @NotNull
    @JsonProperty("name")
    String name

    @OneToMany
    List<Playlist> playlists;

}


