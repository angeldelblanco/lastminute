package adba.lastminute.codetest.model.receipt;

import adba.lastminute.codetest.model.item.Purchase;

import java.util.List;

public interface ShoppingListInterface {

    List<Purchase> getPurchasesList();

    boolean isEmpty();
}
