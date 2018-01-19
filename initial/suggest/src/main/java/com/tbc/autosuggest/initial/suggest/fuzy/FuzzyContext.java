package com.tbc.autosuggest.initial.suggest.fuzy;

import com.tbc.autosuggest.initial.suggest.ds.TrieNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Context class that holds the strategy instance and will redirect control to respective stragy implementation at runtime.
 * <p>
 * <p>
 * Created by chandrashekar.v on 9/14/2017.
 */
public class FuzzyContext {

    /**
     * Algorithm strategy to be set at run time.
     */
    private FuzzyStrategy strategy;

    public FuzzyContext(FuzzyStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calls auto suggest against the strategy at run time.
     *
     * @param atMostResults
     * @return
     */
    public Optional<List<String>> autoSuggest(final String keyword, int atMostResults) {
        Optional<List<String>> suggestions = strategy.suggest(keyword, atMostResults);
        return suggestions;
    }

}
