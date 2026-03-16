package core.basesyntax.strategy.impl;

import core.basesyntax.model.ShopTransaction;
import core.basesyntax.service.ShopOperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class ShopOperationStrategy implements OperationStrategy {
    @Override
    public ShopOperationHandler resolve(ShopTransaction.Operation operationType) {
        return null;
    }
}
