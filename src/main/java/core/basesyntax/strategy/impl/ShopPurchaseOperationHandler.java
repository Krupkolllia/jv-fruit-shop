package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.ShopOperationHandler;

public class ShopPurchaseOperationHandler implements ShopOperationHandler {
    @Override
    public void handle(Storage storage, String product, Integer quantity) {
        if (!storage.getAll().containsKey(product)) {
            throw new RuntimeException("No such product as " + product);
        }

        if (storage.getByKey(product) < quantity) {
            throw new RuntimeException("Not enough stock for product: " + product);
        }

        storage.update(product, storage.getByKey(product) - quantity);
    }
}
