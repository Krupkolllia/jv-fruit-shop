package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ShopOperationHandler;

public class ShopPurchaseOperationHandler implements ShopOperationHandler<String, Integer> {
    @Override
    public void handle(Storage<String, Integer> storage, String product, Integer quantity) {
        if (!storage.getAll().containsKey(product)) {
            throw new RuntimeException("No such product as "  + product);
        }

        if (storage.getByKey(product) < quantity) {
            throw new RuntimeException("Not enough stock for product: " + product);
        }

        storage.update(product, storage.getByKey(product) - quantity);
    }
}
