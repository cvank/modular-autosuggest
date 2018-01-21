package com.autosuggest.refactored.fuzy;

import com.autosuggest.refactored.suggest.api.AutoSuggestion;

import java.util.List;
import java.util.Optional;

public class FuzzySuggestion implements AutoSuggestion{

    @Override
    public Optional<List<String>> suggest(String keyword, int atMostResults) {
        return Optional.empty();
    }
}
