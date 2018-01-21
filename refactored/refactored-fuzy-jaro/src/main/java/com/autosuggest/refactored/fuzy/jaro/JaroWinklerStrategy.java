package com.autosuggest.refactored.fuzy.jaro;

import com.autosuggest.refactored.fuzy.api.FuzzyStrategy;

import java.util.List;
import java.util.Optional;

public class JaroWinklerStrategy implements FuzzyStrategy {

    @Override
    public Optional<List<String>> suggest(String keyword, int atMostResults) {
        return Optional.empty();
    }
}
