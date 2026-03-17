package core.basesyntax.util.impl;

import core.basesyntax.model.ShopTransaction;
import core.basesyntax.util.Mapper;

public class ShopTransactionMapper implements Mapper<String, ShopTransaction> {
    @Override
    public ShopTransaction map(String from) {
        String[] parts = from.split(",");
        String stringOperation = parts[0];
        ShopTransaction.Operation operation = switch (stringOperation) {
            case "b" -> ShopTransaction.Operation.BALANCE;
            case "s" -> ShopTransaction.Operation.SUPPLY;
            case "p" -> ShopTransaction.Operation.PURCHASE;
            case "r" -> ShopTransaction.Operation.RETURN;
            default -> throw new RuntimeException("Unexpected operation: " + stringOperation);
        };

        return new ShopTransaction(operation, parts[1], Integer.parseInt(parts[2]));
    }
}
