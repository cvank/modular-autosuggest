package com.autosuggest.refactored.fuzy.levenshtein;

import com.autosuggest.refactored.fuzy.api.FuzzyStrategy;

import java.util.List;
import java.util.Optional;

public class LevenshteinStrategy implements FuzzyStrategy {

    @Override
    public Optional<List<String>> suggest(String keyword, int atMostResults) {
        return Optional.empty();
    }
}
