package core.basesyntax.db.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.db.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try (CSVReader csvReader = new CSVReader(new java.io.FileReader(filePath))) {
            return csvReader.readAll()
                    .stream()
                    .map(line -> String.join(",", line))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        } catch (CsvException e) {
            throw new RuntimeException("File is invalid: " + filePath, e);
        }
    }
}
