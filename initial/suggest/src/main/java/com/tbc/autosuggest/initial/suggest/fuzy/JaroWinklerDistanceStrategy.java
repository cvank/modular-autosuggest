package com.tbc.autosuggest.initial.suggest.fuzy;

import com.tbc.autosuggest.initial.suggest.ds.TrieDataInteractor;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Jaro Winkler Distance algorithm is a similarity algorithm that indicates percenatge of matched characters between two given character sequences.
 * <p>
 * <p>
 * <p>Ref:  http://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance.</p>
 * Created by chandrashekar.v on 9/14/2017.
 */
public class JaroWinklerDistanceStrategy implements FuzzyStrategy {

    private static final Logger LOG = Logger.getLogger(JaroWinklerDistanceStrategy.class.getName());

    @Override
    public Optional<List<String>> suggest(final String keyword, final int atMostResults) {

        List<String> words = TrieDataInteractor.fetchWords(keyword, data());
        LOG.info("Total words rebuilt:" + words.size());
        return SearchAlgorithmUtil.applyJaro(keyword, words, atMostResults);

    }
}
