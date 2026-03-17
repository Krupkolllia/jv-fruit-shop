package core.basesyntax.strategy.impl;

import core.basesyntax.model.ShopTransaction;
import core.basesyntax.strategy.ShopOperationHandler;
import core.basesyntax.strategy.OperationStrategy;

import java.util.Map;

public class ShopOperationStrategy implements OperationStrategy {
    private final Map<ShopTransaction.Operation, ShopOperationHandler> handlers;

    public ShopOperationStrategy(Map<ShopTransaction.Operation, ShopOperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public ShopOperationHandler resolve(ShopTransaction.Operation operationType) {
        return handlers.get(operationType);
    }
}
