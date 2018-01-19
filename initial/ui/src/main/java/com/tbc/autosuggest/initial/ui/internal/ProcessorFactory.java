package com.tbc.autosuggest.initial.ui.internal;

import com.tbc.autosuggest.initial.suggest.AutoSuggestion;
import com.tbc.autosuggest.initial.suggest.FuzzyAutoSuggestion;
import com.tbc.autosuggest.initial.suggest.PrefixBasedAutoSuggestion;

import java.util.List;

public final class ProcessorFactory {

    public static AutoSuggestion getAutoSuggestionProcessor(int type, String keyword) {
        switch (type) {

            case 2:
                return new FuzzyAutoSuggestion();

            default:
                return new PrefixBasedAutoSuggestion();
        }

    }
}
