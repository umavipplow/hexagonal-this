package com.poetry.domain;

import com.potery.PoetryReader;
import com.potery.port.ObtainPoem;
import com.potery.port.RequestVerse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PoetryTest {

    @Test
    @DisplayName("Should get verse when asked for poetry")
    public void testTheLeftSidePort() {
        RequestVerse requestVerse = new PoetryReader();
        String verse = requestVerse.getPoetry();
        assertThat(verse).isEqualTo("Jack and Jill");
    }

    @Test
    @DisplayName("Should get verse from potery from stub")
    public void testTheRightSidePort(@Mock ObtainPoem obtainPoem) {
        when(obtainPoem.getPoem()).thenReturn("Jonny jonny yes pappa");
        RequestVerse requestVerse = new PoetryReader(obtainPoem);
        String verse = requestVerse.getPoetry();
        assertThat(verse).isEqualTo("Jonny jonny yes pappa");
    }
}
