package adba.lastminute.codetest.model.category;

import adba.lastminute.codetest.model.item.Item;

public interface CategoriesRepository {

    void addCategory(String name, boolean applyTaxes);

    void addItem(Item item, String categoryName);

    boolean applyTaxes(Item item);
}
