package core.basesyntax.db.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.db.FileWriter;
import java.io.IOException;

public class CsvFileWriter implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        try (CSVWriter csvWriter = new CSVWriter(new java.io.FileWriter(fileName))) {
            for (String line : data.split("\n")) {
                csvWriter.writeNext(line.split(","));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + fileName, e);
        }
    }
}
