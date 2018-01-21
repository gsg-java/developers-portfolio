package com.coduckfoilo.domain.stack;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by YG-MAC on 2018. 1. 21..
 */
@Getter
@NoArgsConstructor
@Entity
public class Stack {
    @Id
    @Column(name = "STACK_ID")
    @GeneratedValue
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StackType type;

    private String imageUrl;

    @Builder
    public Stack(String name, StackType type, String imageUrl) {
        this.name = name;
        this.type = type;
        this.imageUrl = imageUrl;
    }
}
