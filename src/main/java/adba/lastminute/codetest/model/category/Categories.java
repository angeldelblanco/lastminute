package adba.lastminute.codetest.model.category;

import adba.lastminute.codetest.model.item.Item;

import java.util.HashMap;
import java.util.Map;

public class Categories implements CategoriesRepository{

    private final Map<String, Category> categoryList;

    public Categories(){
        categoryList = new HashMap<>();
    }

    @Override
    public void addCategory(String name, boolean applyTaxes){
        if (categoryList.containsKey(name)){
            //TODO throw exception
            return;
        }
        categoryList.put(name, new Category(name, applyTaxes));
    }

    @Override
    public void addItem(Item item, String categoryName){
        Category category;
        if (!categoryList.containsKey(categoryName)){
            //TODO throw exception
            return;
        }
        category = categoryList.get(categoryName);
        category.addItem(item);
    }

    @Override
    public boolean applyTaxes(Item item){

        for (Category category: categoryList.values()){
            if (category.contains(item)){
                return category.isApplyTaxes();
            }
        }

        //TODO throws exception??
        return false;

    }

}
