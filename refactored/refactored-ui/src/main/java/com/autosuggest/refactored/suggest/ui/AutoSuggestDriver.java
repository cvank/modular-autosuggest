package com.autosuggest.refactored.suggest.ui;

import com.autosuggest.refactored.suggest.api.AutoSuggestion;

import java.util.Scanner;
import java.util.ServiceLoader;

public class AutoSuggestDriver {
    private static final int MAX_RESULTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter keyword");
        final String keyWord = scanner.next();
        ServiceLoader<AutoSuggestion> autoSuggestionImpls = ServiceLoader.load(AutoSuggestion.class);
        for (AutoSuggestion autoSuggestion : autoSuggestionImpls) {
            //autoSuggestion.suggest(keyWord, MAX_RESULTS);
            System.out.println(autoSuggestion.getClass().getSimpleName());
        }
    }
}
