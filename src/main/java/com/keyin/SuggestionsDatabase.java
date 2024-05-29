package com.keyin;

import java.util.HashMap;
import java.util.Map;

public class SuggestionsDatabase {
    private final Map<String, Integer> wordMap = new HashMap<>();

    public Map<String, Integer> getWordMap() {
        return wordMap;
    }
}