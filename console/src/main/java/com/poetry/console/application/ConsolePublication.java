package com.poetry.console.application;

import com.poetry.console.port.PublicationStrategy;

public class ConsolePublication implements PublicationStrategy {
    @Override
    public void displayLine(String poem) {
        System.out.println(poem);
    }
}
