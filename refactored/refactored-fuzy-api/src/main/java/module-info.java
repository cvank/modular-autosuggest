import com.autosuggest.refactored.fuzy.FuzzySuggestion;
import com.autosuggest.refactored.suggest.api.AutoSuggestion;

module refactored.fuzy.api {

    requires refactored.suggest.api;

    provides AutoSuggestion with FuzzySuggestion;

    exports com.autosuggest.refactored.fuzy.api;
}