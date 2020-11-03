package adba.lastminute.codetest.model.category;

import adba.lastminute.codetest.model.item.Item;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Category {

    private final String name;

    private final boolean applyTaxes;

    //As long as Item has not unique name, the whole object has been used as key
    private final Map<Item, Item> itemList;

    public Category(String name, boolean applyTaxes){
        this.name = name;
        this.applyTaxes = applyTaxes;
        this.itemList = new HashMap<>();
    }

    public void addItem(Item item){
        itemList.put(item, item);
    }

    public boolean contains(Item item){
        return itemList.containsKey(item);
    }

}
