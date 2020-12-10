package com.potery;

import com.potery.port.ObtainPoem;
import com.potery.port.RequestVerse;

public class PoetryReader implements RequestVerse {

    ObtainPoem obtainPoem;

    public PoetryReader() {
        this.obtainPoem = new ObtainPoem() {
        };
    }

    public PoetryReader(ObtainPoem obtainPoem) {
        this.obtainPoem = obtainPoem;
    }

    @Override
    public String getPoetry() {
        return obtainPoem.getPoem() + "\n";
    }
}
