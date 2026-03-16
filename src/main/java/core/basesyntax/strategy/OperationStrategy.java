package core.basesyntax.strategy;

import core.basesyntax.model.ShopTransaction;
import core.basesyntax.service.ShopOperationHandler;

public interface OperationStrategy {
    ShopOperationHandler resolve(ShopTransaction.OPERATION operationType);
}
