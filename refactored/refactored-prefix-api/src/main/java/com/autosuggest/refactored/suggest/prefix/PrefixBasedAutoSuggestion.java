package com.autosuggest.refactored.suggest.prefix;

import com.autosuggest.refactored.suggest.api.AutoSuggestion;

import java.util.List;
import java.util.Optional;

public class PrefixBasedAutoSuggestion implements AutoSuggestion {
    @Override
    public Optional<List<String>> suggest(String keyword, int atMostResults) {
        return Optional.empty();
    }
}
