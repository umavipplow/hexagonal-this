package com.poetry.console;

import com.poetry.domain.RequestVerse;

public class ConsoleAdaptor {

    private RequestVerse poetryReader;
    private WriteLines writeLines;

    public ConsoleAdaptor(RequestVerse poetryReader, WriteLines writeLines) {
        this.poetryReader = poetryReader;
        this.writeLines = writeLines;
    }

    public void ask() {
        String poetry = this.poetryReader.giveMeSomePoetry();
        this.writeLines.writeLine(poetry + "-uma");
    }
}
