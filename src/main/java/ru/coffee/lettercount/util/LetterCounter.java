package ru.coffee.lettercount.util;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class LetterCounter {
    public Map<Character, Long> count(String requestString) {

        Map<Character, Long> letterMap = requestString
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((Comparator<? super Map.Entry<Character, Long>>) Map.Entry.comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        return letterMap;
    }
}
