package com.maxoptra.kwelsh.model;

import lombok.Data;

@Data
public class Wrapper<T> {
    private T value;
    public Wrapper(T value) {
        this.value = value;
    }
}
