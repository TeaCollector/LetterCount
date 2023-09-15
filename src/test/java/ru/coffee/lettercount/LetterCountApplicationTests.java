package ru.coffee.lettercount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import ru.coffee.lettercount.controller.LetterController;
import ru.coffee.lettercount.util.LetterCounter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class LetterCountApplicationTests {

    @Autowired
    private LetterCounter letterCounter;
    @Autowired
    private LetterController letterController;


    @Test
    @DisplayName("Checking all part of app work correct")
    void returnsValidResponseEntity() {
        ResponseEntity<Map<Character, Long>> responseEntity
                = this.letterController.countLetter("fffggggthth");

        Map<Character, Long> testMap = new LinkedHashMap<>();
        testMap.put('g', 4L);
        testMap.put('f', 3L);
        testMap.put('t', 2L);
        testMap.put('h', 2L);


        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(testMap, responseEntity.getBody());
    }


}
