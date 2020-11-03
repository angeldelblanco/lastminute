package adba.lastminute.codetest.service;

import adba.lastminute.codetest.model.receipt.Receipt;
import adba.lastminute.codetest.model.receipt.ShoppingListInterface;

public interface ReceiptServiceInterface {
    Receipt generateReceipt(ShoppingListInterface shoppingList);
}
