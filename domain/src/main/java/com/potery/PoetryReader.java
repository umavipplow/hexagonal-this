package com.potery;

import com.potery.port.RequestVerse;

public class PoetryReader implements RequestVerse {

    @Override
    public String getPoetry() {
        return "Jack and Jill";
    }
}
