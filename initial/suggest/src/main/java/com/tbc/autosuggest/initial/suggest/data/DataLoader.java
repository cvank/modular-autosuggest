package com.tbc.autosuggest.initial.suggest.data;

import com.tbc.autosuggest.initial.suggest.ds.Trie;
import com.tbc.autosuggest.initial.suggest.util.FileUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


/**
 * Contains methods to load data.
 * <p>
 * Created by chandrashekar.v on 9/13/2017.
 */
public class DataLoader implements Serializable, Cloneable {

    private static final DataLoader INSTANCE = new DataLoader();
    /**
     * Configurable file location from where the data needs to be read.
     */
    private static String fileLocation = "";

    /**
     * Boolean value specifies whether data load completed.
     */
    private static boolean isDataDumpComplete = false;

    private static final Logger LOG = Logger.getLogger(DataLoader.class.getName());

    private DataLoader() {
    }

    public static DataLoader getInstance() {
        return INSTANCE;
    }

    /**
     * Data structure to hold loaded data.
     */
    private static Trie trie;

    static {
        init();

    }

    private static void init() {
        if (Objects.isNull(trie)) {
            LOG.info("Data is unavailable. Initiating data fetching from location:" + fileLocation);
           // Optional<InputStream> fileData = FileUtils.loadFileFromClasspath(fileLocation);
            //List<String> allCities = readDataFromFile(fileData);
            List<String> allCities = FileUtils.readData().orElse(List.of());

            if (!Objects.isNull(allCities)) {
                // Populate data into Trie data structure.
                trie = new Trie(allCities);
                isDataDumpComplete = !Objects.isNull(trie.getRoot());

                LOG.info("Data dump complete.");
            }
        }
    }

    private List<String> mockData() {
        return List.of("");
    }

    /**
     * Reads given file data and returns required column into list.
     *
     * @param fileData
     * @return
     */
    private List<String> readDataFromFile(Optional<InputStream> fileData) {
        List<String> allCities = null;

        // CSV reading logic
        if (fileData.isPresent()) {
            InputStream citiesDataStream = fileData.get();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(citiesDataStream))) {
                allCities = bufferedReader.lines().parallel()
                        .skip(1) // Skip first row from CSV
                        .map(line -> Arrays.stream(line.split(","))
                                .skip(7) // consider taluk column as city data.
                                .findFirst())
                        .filter(s -> s.isPresent()).map(s -> s.get()).
                                collect(Collectors.toList());
            } catch (Exception ex) {
                LOG.log(Level.SEVERE, "Unable to load data.Parsing failed." + ex.getMessage());
            }
        }
        return allCities;
    }

    /**
     * Retrieves Data.
     *
     * @return
     */
    public Trie loadData() {

        if (Objects.isNull(trie))
            init();

        return trie;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private Object readResolve()  {
        return INSTANCE;
    }
}
