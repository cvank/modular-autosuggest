package com.tbc.autosuggest.initial.suggest.fuzy;

import com.tbc.autosuggest.initial.suggest.ds.TrieDataInteractor;
import com.tbc.autosuggest.initial.suggest.ds.TrieNode;

import java.util.List;
import java.util.Optional;

/**
 * Fuzzy score strategy utilizes Apache commons text matching algorithm.
 * <p>
 * Created by chandrashekar.v on 9/14/2017.
 */

public class FuzzyScoreStrategy extends TrieDataInteractor implements FuzzyStrategy {


    @Override
    public Optional<List<String>> suggest(final String keyword, int atMostResults) {

        List<String> words = TrieDataInteractor.fetchWords(keyword, data());

        return SearchAlgorithmUtil.applyFuzzy(keyword, words, atMostResults);

    }


}
