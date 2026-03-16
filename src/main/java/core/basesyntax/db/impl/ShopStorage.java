package core.basesyntax.db.impl;

import core.basesyntax.db.Storage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShopStorage implements Storage<String, Integer> {
    private final Map<String, Integer> products = new HashMap<>();

    public Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(products);
    }

    public void put(String key, Integer value) {
        products.put(key, value);
    }
}
