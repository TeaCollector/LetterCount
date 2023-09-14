package ru.coffee.lettercount.controller;

import org.springframework.http.HttpStatus;
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
                .body(letterMap);

    }
}

/*
    Тестовое задание.

        Спроектировать(продумать формат и ограничения входящих/исходящих параметров)
         и реализовать REST API, вычисляющее частоту встречи символов по заданной строке.
         Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

        Пример входной строки: “aaaaabcccc”
        Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

        Требования к решению:
        Java 8+
        Spring boot 2+
        Решение должно быть покрыто тестами
        У решения должна быть документация по запуску и формату входящих/исходящих параметров
        Код решения необходимо разместить в публичном Github репозитории.
*/

