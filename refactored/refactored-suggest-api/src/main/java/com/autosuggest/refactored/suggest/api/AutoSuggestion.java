package com.autosuggest.refactored.suggest.api;

import java.util.*;

public interface AutoSuggestion {

    Optional<List<String>> suggest(final String keyword, final int atMostResults);

    static Iterable<AutoSuggestion> availableImplementations() {
        return ServiceLoader.load(AutoSuggestion.class);

    }

    static Map<Integer, String> availableImplementations1() {
        ServiceLoader<AutoSuggestion> autoSuggestions = ServiceLoader.load(AutoSuggestion.class);
        Map<Integer, String> integerAutoSuggestionMap = new TreeMap<>();
        Integer index = 1;

        for(AutoSuggestion autoSuggestion: autoSuggestions) {
            integerAutoSuggestionMap.put(index, autoSuggestion.getClass().getSimpleName());
            index++;
        }

        return integerAutoSuggestionMap;

    }

    default List<String> trigger(final String keyword, final int atMostResults, final int index) {

        Optional<List<String>> suggest = suggest("", 10);

        return List.of();
    }

}
