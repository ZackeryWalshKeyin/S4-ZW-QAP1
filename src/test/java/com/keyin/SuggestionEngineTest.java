package com.keyin;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine;

    @Before
    public void setUp() throws Exception {
        suggestionEngine = new SuggestionEngine();
        Path dictionaryPath = Paths.get(ClassLoader.getSystemResource("words.txt").toURI());
        suggestionEngine.loadDictionaryData(dictionaryPath);
    }

    @Test
    public void testLoadDictionaryData() {
        assertNotNull(suggestionEngine.getWordSuggestionDB());
        assertTrue(suggestionEngine.getWordSuggestionDB().containsKey("apple"));
        assertTrue(suggestionEngine.getWordSuggestionDB().containsKey("banana"));
    }

    @Test
    public void testGenerateSuggestionsForCorrectWord() {
        String suggestions = suggestionEngine.generateSuggestions("apple");
        assertTrue(suggestions.isEmpty());
    }

    @Test
    public void testGenerateSuggestionsForMisspelledWord() {
        String suggestions = suggestionEngine.generateSuggestions("appl");
        assertFalse(suggestions.isEmpty());
        assertTrue(suggestions.contains("apple"));
    }

    @Test
    public void testGenerateSuggestionsForUnknownWord() {
        String suggestions = suggestionEngine.generateSuggestions("xyz");
        assertTrue(suggestions.isEmpty());
    }
}