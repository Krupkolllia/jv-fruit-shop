package core.basesyntax.db;

import java.util.Map;

public interface Storage<K, V> {
    public Map<K, V> getAll();

    public void put(K key, V value);
}
