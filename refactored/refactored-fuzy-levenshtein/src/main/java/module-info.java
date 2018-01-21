import com.autosuggest.refactored.fuzy.api.FuzzyStrategy;
import com.autosuggest.refactored.fuzy.levenshtein.LevenshteinStrategy;

module refactored.fuzy.levenshtein {
    requires refactored.fuzy.api;

    provides FuzzyStrategy with LevenshteinStrategy;
}
