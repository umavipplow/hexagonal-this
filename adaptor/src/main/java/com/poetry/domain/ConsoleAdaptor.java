package com.poetry.domain;

import java.io.ByteArrayOutputStream;

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
