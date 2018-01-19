package com.tbc.autosuggest.initial.suggest.fuzy;

public class FuzzyStrategyFactory {


    FuzzyStrategy fuzzyScoreStrategy;


    FuzzyStrategy jaroWrinklerStrategy;


    FuzzyStrategy levenshteinStrategy;

    /**
     * Identifies and returns fuzzy search algorithm based on given string literal.
     *
     * @param algorithm
     * @return
     */
    public FuzzyStrategy identify(final FuzyAlgorithm algorithm) {
        switch (algorithm) {
            case JARO:
                return new JaroWinklerDistanceStrategy();
            case LEVENSHTEIN:
                return new LevenshteinDistanceStrategy();
            case FUZZY_SCORE:
                return new FuzzyScoreStrategy();
            default:
                return new JaroWinklerDistanceStrategy();

        }
    }
}
