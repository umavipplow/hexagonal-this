package com.poetry.console.application;

import com.poetry.console.ConsoleAdapter;
import com.potery.PoetryReader;
import com.potery.port.RequestVerse;

public class console {

    public static void main(String[] args) {
        RequestVerse requestVerse = new PoetryReader();
        ConsoleAdapter consoleAdapter = new ConsoleAdapter(requestVerse, new ConsolePublication());
        consoleAdapter.getVerse();
    }
}
