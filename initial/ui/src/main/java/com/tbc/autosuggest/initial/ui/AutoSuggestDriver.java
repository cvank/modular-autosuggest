package com.tbc.autosuggest.initial.ui;


import com.tbc.autosuggest.initial.suggest.AutoSuggestion;
import com.tbc.autosuggest.initial.suggest.FuzzyAutoSuggestion;
import com.tbc.autosuggest.initial.suggest.PrefixBasedAutoSuggestion;
import com.tbc.autosuggest.initial.ui.internal.ProcessorFactory;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AutoSuggestDriver {

    private static final int maxResults = 10;

    public static void main(String[] args) {

        boolean proceed = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nChose Auto suggest type :\n 1. Prefix Based \n 2. Fuzzy Based");

            int type = scanner.nextInt();

            System.out.println("Enter word for suggestions: ");

            final String keyword = scanner.next();
            Objects.requireNonNull(keyword);

            AutoSuggestion autoSuggestionProcessor = ProcessorFactory.getAutoSuggestionProcessor(type, keyword);

            autoSuggestionProcessor.suggest(keyword, maxResults)
                    .ifPresentOrElse(suggestions -> printSuggestions(suggestions), () -> System.out.println("\n No Results\n "));

            System.out.println("----------------------------------------------");
        } while (proceed);

    }

    private static void printSuggestions(List<String> suggestions) {
        if (!suggestions.isEmpty())
            suggestions.forEach(System.out::println);
        else
            System.out.println("No Results");
    }


}
