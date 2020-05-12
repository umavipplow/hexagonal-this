package com.poetry.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        Assertions.assertEquals("Early to Bed Early to  raise make a men  healthy  wealthy and wise", verse);
    }

    @Test
    @DisplayName("Should get verse when asked for poetry from stub")
    public void testTheRightSidePort(@Mock ObtainPoem obtainPoem) {
        when(obtainPoem.giveMePoetry()).thenReturn("Baa Baa Black sheep");
        RequestVerse poetryReader = new PoetryReader(obtainPoem);
        String verse = poetryReader.giveMeSomePoetry();
        Assertions.assertEquals("Baa Baa Black sheep", verse);
    }
}
