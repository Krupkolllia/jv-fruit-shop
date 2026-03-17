package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ShopOperationHandler;

public class ShopBalanceOperationHandler implements ShopOperationHandler<String, Integer> {
    @Override
    public void handle(Storage<String, Integer> storage, String product, Integer quantity) {
        if (storage.getAll().containsKey(product)) {
            throw new RuntimeException("Product already exists: " + product);
        }

        storage.update(product, quantity);
    }
}
