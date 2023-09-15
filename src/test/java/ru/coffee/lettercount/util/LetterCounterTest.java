package ru.coffee.lettercount.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class LetterCounterTest {

    @InjectMocks
    private LetterCounter letterCounter;

    @Test
    void correctData_InputCorrectData() {
        Map<Character, Long> testMap = new LinkedHashMap<>();
        testMap.put('e', 5L);
        testMap.put('g', 3L);
        testMap.put('d', 2L);
        testMap.put('s', 2L);

        assertEquals(letterCounter.count("eeeeegggddss"), testMap);
    }

    @Test
    void incorrectDat_InputIncorrectData() {
        Map<Character, Long> testMap = new LinkedHashMap<>();
        testMap.put('e', 5L);
        testMap.put('g', 3L);
        testMap.put('d', 2L);
        testMap.put('s', 0L);

        assertNotEquals(letterCounter.count("eeeeegggddss"), testMap);
    }
}