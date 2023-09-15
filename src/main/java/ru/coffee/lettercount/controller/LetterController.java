package ru.coffee.lettercount.controller;

import jdk.jfr.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.lettercount.util.LetterCounter;

import java.util.Map;

@RestController
public class LetterController {

    private final LetterCounter letterCounter;

    public LetterController(LetterCounter letterCounter) {
        this.letterCounter = letterCounter;
    }

    @GetMapping("/count")
    public ResponseEntity<Map<Character, Long>> countLetter(
            @RequestParam(required = false, defaultValue = "Hello world") String sequence) {

        Map<Character, Long> letterMap = letterCounter.count(sequence);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(letterMap);
    }
}