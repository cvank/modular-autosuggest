package com.tbc.autosuggest.initial.suggest;

import com.tbc.autosuggest.initial.suggest.ds.TrieNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PrefixBasedAutoSuggestion implements AutoSuggestion {

    @Override
    public Optional<List<String>> suggest(String keyword, int atMostResults) {

        getCounter();
        List<String> suggestions = new ArrayList<>();
        fetch(keyword, false, atMostResults, suggestions);
        setCounter(null);
        return Optional.of(suggestions);
    }


    /**
     * Counter to compare against number of results populated.
     */
    private AtomicInteger counter = new AtomicInteger();

    public AtomicInteger getCounter() {
        if (Objects.isNull(counter)) {
            counter = new AtomicInteger(0);
        }
        return counter;
    }

    public void setCounter(AtomicInteger counter) {
        this.counter = counter;
    }


    /**
     * Traverse through trie data structure and identifies matching words.
     *
     * @param prefix
     * @param caseSensitive
     * @param atMost
     * @param suggestions
     */
    public void fetch(String prefix, final boolean caseSensitive, final int atMost, List<String> suggestions) {
        prefix = prefix.toLowerCase();
        TrieNode lastNode = data();

        StringBuilder prefixActual = new StringBuilder();
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChildNode(prefix.charAt(i));
            if (Objects.isNull(lastNode)) {
                return;
            }
            prefixActual.append(lastNode.getDisplayCharacter());
        }
        if (caseSensitive)
            caseSensitiveSuggestions(prefixActual.toString(), lastNode, atMost, suggestions);
        else
            caseInsensitiveSuggestions(lastNode, atMost, suggestions);
    }

    /**
     * Returns case sensitve suggestions for the given start word.
     *
     * @param prefix start word.
     * @param parent current parent node
     * @param atMost atmost suggestions need to be returned
     * @param suggestions list of suggestions.
     */
    private void caseSensitiveSuggestions(final String prefix, TrieNode parent, final int atMost, List<String> suggestions) {
        // Exit if number of suggestions match the atmost value.
        if (getCounter().intValue() >= atMost)
            return;

        if (parent.isTerminated()) {
            suggestions.add(prefix);
            getCounter().getAndIncrement();
        }

        if (parent.getChildren().size() == 0)
            return;

        // for each child node recursively populate suggestions.
        for (Map.Entry<Character, TrieNode> entry : parent.getChildren().entrySet()) {
            caseSensitiveSuggestions(prefix + entry.getValue().getDisplayCharacter(), entry.getValue(), atMost, suggestions);

        }
    }

    /**
     * Case insensitive suggestions.
     *
     * @param parent current parent node
     * @param atMost atmost suggestions need to be returned
     * @param suggestions list of suggestions.
     */
    private void caseInsensitiveSuggestions(TrieNode parent, final int atMost, List<String> suggestions) {

        if (getCounter().intValue() >= atMost)
            return;

        if (parent.isTerminated()) {
            suggestions.add(parent.getWord());
            getCounter().getAndIncrement();
        }

        if (parent.getChildren().size() == 0)
            return;

        for (Map.Entry<Character, TrieNode> entry : parent.getChildren().entrySet()) {
            caseInsensitiveSuggestions(entry.getValue(), atMost, suggestions);

        }
    }
}
