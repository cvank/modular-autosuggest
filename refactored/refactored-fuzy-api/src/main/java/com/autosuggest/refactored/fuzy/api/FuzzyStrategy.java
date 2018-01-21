package com.autosuggest.refactored.fuzy.api;

import java.util.List;
import java.util.Optional;

public interface FuzzyStrategy {
    public Optional<List<String>> suggest(String keyword, int atMostResults);
}
