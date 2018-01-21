import com.autosuggest.refactored.suggest.api.AutoSuggestion;
import com.autosuggest.refactored.suggest.prefix.PrefixBasedAutoSuggestion;

module refactored.prefix.api {
    requires refactored.suggest.api;

    provides AutoSuggestion with PrefixBasedAutoSuggestion;


}