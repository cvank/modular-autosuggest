module refactored.fuzy.jaro {
    requires refactored.fuzy.api;

    provides com.autosuggest.refactored.fuzy.api.FuzzyStrategy with com.autosuggest.refactored.fuzy.jaro.JaroWinklerStrategy;


}
