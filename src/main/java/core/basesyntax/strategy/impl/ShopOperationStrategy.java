package core.basesyntax.strategy.impl;

import core.basesyntax.model.ShopTransaction;
import core.basesyntax.service.ShopOperationHandler;
import core.basesyntax.service.impl.ShopBalanceOperationHandler;
import core.basesyntax.service.impl.ShopPurchaseOperationHandler;
import core.basesyntax.service.impl.ShopReturnOperationHandler;
import core.basesyntax.service.impl.ShopSupplyOperationHandler;
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
