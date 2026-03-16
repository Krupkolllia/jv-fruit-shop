package core.basesyntax.db;

import java.util.Map;

public interface Storage<K, V> {
    public Map<K, V> getAll();

    public V getByKey(K key);

    public void update(K key, V value);
}
