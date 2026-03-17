package core.basesyntax.util.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.util.ReportGenerator;
import java.util.Map;

public class CsvShopReportGenerator implements ReportGenerator {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String generate(Storage storage) {
        Map<String, Integer> dataFromStorage = storage.getAll();
        StringBuilder report = new StringBuilder();

        report.append(REPORT_TITLE);

        for (Map.Entry<String, Integer> entry : dataFromStorage.entrySet()) {
            report.append("\n")
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }

        return report.toString();
    }
}
