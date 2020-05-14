package com.poetry.domain;

import com.poetry.console.ConsoleAdaptor;
import com.poetry.console.WriteLines;
import com.poetry.file.PoetryLibFileAdaptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PoetryTest {


    @Test
    @DisplayName("Should get verse when asked for poetry")
    public void testTheLeftSidePort() {
        //RequestVerse :left side  port
        //poetryReader : hexagonal
        RequestVerse poetryReader = new PoetryReader();
        String verse = poetryReader.giveMeSomePoetry();
        assertEquals("Early to Bed Early to  raise make a men  healthy  wealthy and wise", verse);
    }

    @Test
    @DisplayName("Should get verse when asked for poetry from stub")
    public void testTheRightSidePort(@Mock ObtainPoem obtainPoem) {
        when(obtainPoem.giveMePoetry()).thenReturn("Baa Baa Black sheep");
        RequestVerse poetryReader = new PoetryReader(obtainPoem);

        String verse = poetryReader.giveMeSomePoetry();
        assertEquals("Baa Baa Black sheep", verse);
    }

    @Test
    @DisplayName("Should get verse when console adaptor asked for poetry from stub")
    public void testConsoleAdaptor(@Mock ObtainPoem obtainPoem, @Mock WriteLines writeLines) {
        RequestVerse poetryReader = new PoetryReader(obtainPoem);
        when(poetryReader.giveMeSomePoetry()).thenReturn("Baa Baa Black sheep");
        ConsoleAdaptor consoleAdaptor = new ConsoleAdaptor(poetryReader, writeLines);
        consoleAdaptor.ask();
        Mockito.verify(writeLines).writeLine("Baa Baa Black sheep-uma");
    }

    @Test
    @DisplayName("Should get verse when asked for poetry from file")
    public void testFileAdaptor() throws IOException {
        ObtainPoem obtainPoem = new PoetryLibFileAdaptor(PoetryLibFileAdaptor.class.getClassLoader().getResource("poem.txt").getPath());
        RequestVerse poetryReader = new PoetryReader(obtainPoem);
        String verse = poetryReader.giveMeSomePoetry();
        assertEquals("Baa Baa Black sheep", verse);
    }

    @Test
    @DisplayName("Should get empty string when asked for poetry from invalid  file ")
    public void testFileAdaptorWithoutFile() throws IOException {
        ObtainPoem obtainPoem = new PoetryLibFileAdaptor("");
        RequestVerse poetryReader = new PoetryReader(obtainPoem);
        String verse = poetryReader.giveMeSomePoetry();
        assertEquals("", verse);
    }
}
