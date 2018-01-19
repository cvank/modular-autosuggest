package com.tbc.autosuggest.initial.suggest.fuzy;

import com.tbc.autosuggest.initial.suggest.AutoSuggestion;
import com.tbc.autosuggest.initial.suggest.ds.TrieNode;

import java.util.List;
import java.util.Optional;

/**
 * Created by chandrashekar.v on 9/14/2017.
 */
public interface FuzzyStrategy extends AutoSuggestion {

    default int getDefaultFuzziess() {
        return 3;
    }
}
