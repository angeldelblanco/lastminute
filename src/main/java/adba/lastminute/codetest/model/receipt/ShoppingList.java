package adba.lastminute.codetest.model.receipt;

import adba.lastminute.codetest.model.item.Item;
import adba.lastminute.codetest.model.item.Purchase;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

@EqualsAndHashCode
@Getter(AccessLevel.PROTECTED)
public class ShoppingList implements ShoppingListInterface {

    protected final Map<Item, Purchase> purchases;

    private ShoppingList(){
        this.purchases = new LinkedHashMap<>();
    }

    protected ShoppingList(Map<Item, Purchase> purchases){
        this.purchases = purchases;
    }

    public void addItem(Item item){
        if (purchases.containsKey(item)){
            purchases.get(item).increaseQuantity();
        } else {
            purchases.put(item, Purchase.of(item));
        }
    }

    public static ShoppingList of(List<Item> itemList){
        final ShoppingList shoppingList = new ShoppingList();

        itemList.stream().forEach(item -> shoppingList.addItem(item));

        return shoppingList;
    }

    public static ShoppingList ofPurchases(List<Purchase> purchases){
        ShoppingList shoppingList = new ShoppingList();

        purchases.stream().forEach(purchase -> shoppingList.addItem(purchase));

        return shoppingList ;
    }

    @Override
    public List<Purchase> getPurchasesList(){
        return new ArrayList<>(purchases.values());
    }

    @Override
    public boolean isEmpty(){
        return purchases.isEmpty();
    }


}
