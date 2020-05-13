package com.poetry.console.application;

import com.poetry.console.WriteLines;

public class ConsolePublication implements WriteLines {
    @Override
    public void writeLine(String poetryLines) {
        System.out.println(poetryLines);
    }
}
