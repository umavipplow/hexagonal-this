package com.poetry.console.application;

import com.poetry.console.ConsoleAdaptor;
import com.poetry.domain.PoetryReader;
import com.poetry.domain.RequestVerse;

public class Console {

    public static void main(String[] arg) {
        RequestVerse poetryReader = new PoetryReader();
        ConsoleAdaptor consoleAdaptor = new ConsoleAdaptor(poetryReader, new ConsolePublication());
        consoleAdaptor.ask();
    }
}
