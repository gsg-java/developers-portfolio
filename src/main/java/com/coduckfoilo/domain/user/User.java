package com.coduckfoilo.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by YG-MAC on 2018. 1. 21..
 */

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String email;
}
