package com.coduckfoilo.domain.project;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by YG-MAC on 2018. 1. 21..
 */

@Getter
@NoArgsConstructor
@Entity
public class Project {
    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue
    private long id;

    private long userId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String title;

    private String description;
}
