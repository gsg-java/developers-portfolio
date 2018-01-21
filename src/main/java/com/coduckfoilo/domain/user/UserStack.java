package com.coduckfoilo.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by YG-MAC on 2018. 1. 21..
 */

@Getter
@NoArgsConstructor
@Entity
public class UserStack {
    private long userId;
    private long stackId;
}
