package com.poetry.console;

import com.poetry.console.port.PublicationStrategy;
import com.potery.port.RequestVerse;

public class ConsoleAdapter {

    private RequestVerse requestVerse;
    private PublicationStrategy publicationStartegy;

    public ConsoleAdapter(RequestVerse requestVerse,
                          PublicationStrategy publicationStartegy) {

        this.requestVerse = requestVerse;
        this.publicationStartegy = publicationStartegy;
    }

    public void getVerse() {
        publicationStartegy.displayLine(requestVerse.getPoetry());
    }
}
