package core.basesyntax.service;

import core.basesyntax.db.Storage;

public interface ShopOperationHandler<K, V> {
    void handle(Storage<K, V> storage, K product, V quantity);
}
