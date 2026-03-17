package core.basesyntax;

import core.basesyntax.db.FileReader;
import core.basesyntax.db.FileWriter;
import core.basesyntax.db.Storage;
import core.basesyntax.db.impl.CsvFileReader;
import core.basesyntax.db.impl.CsvFileWriter;
import core.basesyntax.db.impl.ShopStorage;
import core.basesyntax.model.ShopTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DefaultShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.ShopOperationStrategy;
import core.basesyntax.util.Mapper;
import core.basesyntax.util.ReportGenerator;
import core.basesyntax.util.impl.CsvShopReportGenerator;
import core.basesyntax.util.impl.ShopTransactionMapper;
import java.util.List;

public class Application {
    private static final String INPUT_FILE = "src/main/resources/input-example.csv";
    private static final String OUTPUT_FILE = "src/main/resources/shop-report.csv";

    public static void main(String[] args) {
        Storage shopStorage = new ShopStorage();

        FileReader fileReader = new CsvFileReader();
        List<String> input = fileReader.read(INPUT_FILE);

        Mapper<String, ShopTransaction> shopTransactionMapper = new ShopTransactionMapper();
        List<ShopTransaction> transactions = input.stream()
                .map(shopTransactionMapper::map)
                .toList();

        OperationStrategy operationStrategy = new ShopOperationStrategy();
        ShopService shopService = new DefaultShopService(shopStorage, operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new CsvShopReportGenerator();
        String report = reportGenerator.generate(shopStorage);

        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.write(report, OUTPUT_FILE);
    }
}
