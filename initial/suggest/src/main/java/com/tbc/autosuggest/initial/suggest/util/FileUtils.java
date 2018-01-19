package com.tbc.autosuggest.initial.suggest.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FileUtils: Utility methods for file processing.
 * <p>
 * Created by chandrashekar.v on 9/13/2017.
 */
public final class FileUtils {

    private static final Logger LOG = Logger.getLogger(FileUtils.class.getName());

    private static final String CITIES_FILE = "/home/chandrashekarv/eclipse-workspace/modular-autosuggest/initial/suggest/src/main/java/com/tbc/autosuggest/initial/suggest/test.txt";

    /**
     * Loads resources from the given class path location.
     *
     * @param location
     * @return
     */
    public static Optional<InputStream> loadFileFromClasspath(final String location) {
        Module module = FileUtils.class.getModule();
        try {
            Optional.of(module.getResourceAsStream(location));
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Unable to load data from location:" + location + "Error Message: " + ex.getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Unexpected error while loading data from location:" + location + "Error Message: " + ex.getMessage());
        }

        return Optional.empty();

    }

    public static Optional<List<String>> readData() {
        try {
            return Optional.ofNullable(Files.readAllLines(Paths.get(CITIES_FILE)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
