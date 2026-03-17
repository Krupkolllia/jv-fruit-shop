package core.basesyntax.db;

import java.util.Map;

public interface Storage {
    public Map<String, Integer> getAll();

    public Integer getByKey(String key);

    public void update(String key, Integer value);
}
