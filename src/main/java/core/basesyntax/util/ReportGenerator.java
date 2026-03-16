package core.basesyntax.util;

import core.basesyntax.db.Storage;

public interface ReportGenerator<K, V> {
    String generate(Storage<K, V> source);
}
