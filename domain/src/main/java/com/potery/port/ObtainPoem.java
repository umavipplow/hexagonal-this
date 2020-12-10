package com.potery.port;

public interface ObtainPoem {
    default String getPoem() {
        return "Jack and Jill";
    }
}
