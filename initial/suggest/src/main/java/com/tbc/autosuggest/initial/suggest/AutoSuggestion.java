package com.tbc.autosuggest.initial.suggest;

import com.tbc.autosuggest.initial.suggest.data.DataLoader;
import com.tbc.autosuggest.initial.suggest.ds.Trie;
import com.tbc.autosuggest.initial.suggest.ds.TrieNode;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface AutoSuggestion {

    Optional<List<String>> suggest(final String keyword, int atMostResults);

    default TrieNode data() {
        Trie trie = DataLoader.getInstance().loadData();
        Objects.requireNonNull(trie);

        return trie.getRoot();
    }
}
