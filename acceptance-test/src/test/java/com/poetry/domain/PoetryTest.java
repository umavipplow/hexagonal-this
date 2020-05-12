package com.poetry.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
}
