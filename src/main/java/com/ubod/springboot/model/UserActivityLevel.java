package com.ubod.springboot.model;

import lombok.Getter;

@Getter
public enum UserActivityLevel {
    NotActive(1),
    Moderate(2),
    Active(3),
    VeryActive(4);

    private final int value;

    UserActivityLevel(int value) {
        this.value = value;
    }

}
