package com.tbc.autosuggest.initial.suggest;

import com.tbc.autosuggest.initial.suggest.fuzy.FuzzyStrategyFactory;
import com.tbc.autosuggest.initial.suggest.fuzy.FuzyAlgorithm;
import com.tbc.autosuggest.initial.suggest.fuzy.FuzzyContext;
import com.tbc.autosuggest.initial.suggest.fuzy.FuzzyStrategy;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

public class FuzzyAutoSuggestion implements AutoSuggestion {
    private static final Logger LOG = Logger.getLogger(FuzzyAutoSuggestion.class.getName());

    @Override
    public Optional<List<String>> suggest(String keyword, int atMostResults) {
        System.out.println("Which Fuzzy approach? \n 1. Fuzzy Score \n 2. Levenshtein \n 3. Jaro Winkler \n ");
        Scanner scanner = new Scanner(System.in);

        FuzyAlgorithm fuzyAlgorithm = userChoice(scanner);
        FuzzyStrategyFactory fuzzyStrategyFactory = new FuzzyStrategyFactory();
        FuzzyStrategy fuzzyAlgorithm = fuzzyStrategyFactory.identify(fuzyAlgorithm);

        // Set strategy to context
        FuzzyContext fuzzyContext = new FuzzyContext(fuzzyAlgorithm);
        return fuzzyContext.autoSuggest(keyword, atMostResults);

    }

    private FuzyAlgorithm userChoice(Scanner scanner) {

        switch (scanner.nextInt()) {
            case 1:
                return FuzyAlgorithm.FUZZY_SCORE;

            case 2:
                return FuzyAlgorithm.LEVENSHTEIN;

            default:
                return FuzyAlgorithm.JARO;
        }
    }


}
