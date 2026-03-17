package core.basesyntax.strategy.impl;

import core.basesyntax.model.ShopTransaction;
import core.basesyntax.strategy.ShopOperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class ShopOperationStrategy implements OperationStrategy {
    @Override
    public ShopOperationHandler resolve(ShopTransaction.Operation operationType) {
        return switch (operationType) {
            case BALANCE -> new ShopBalanceOperationHandler();
            case SUPPLY -> new ShopSupplyOperationHandler();
            case PURCHASE -> new ShopPurchaseOperationHandler();
            case RETURN -> new ShopReturnOperationHandler();
        };
    }
}
