package com.ubod.springboot.model;

import lombok.Getter;
@Getter

public enum Objective {
    GainWeight(1),
    MaintainWeight(2),
    LoseWeight(3);

    private final int value;

    Objective(int value) {
        this.value = value;
    }
}
