package adba.lastminute.codetest.test.builder;

import adba.lastminute.codetest.model.category.Categories;
import adba.lastminute.codetest.model.item.Item;

import java.math.BigDecimal;

public class CategoriesInit {


    public static Categories initialCategories(){
        Categories categoryList = new Categories();

        // create categories
        categoryList.addCategory("books", false);
        categoryList.addCategory("food", false);
        categoryList.addCategory("medical products",false);
        categoryList.addCategory("music",true);
        categoryList.addCategory("cosmetics",true);

        // create all possible items:
        Item book = new Item("book", new BigDecimal("12.49"), false);
        categoryList.addItem(book,"books");

        Item musicCD = new Item("music CD", new BigDecimal("14.99"), false);
        categoryList.addItem(musicCD,"music");

        Item choco = new Item("chocolate bar", new BigDecimal("0.85"),false);
        categoryList.addItem(choco,"food");

        Item impChocoBox = new Item("imported box of chocolates ", new BigDecimal("10.00"), true);
        categoryList.addItem(impChocoBox,"food");

        Item impPerfBottle = new Item("imported bottle of perfume", new BigDecimal("47.50"), true);
        categoryList.addItem(impPerfBottle,"cosmetics");

        Item impPerfBottle2 = new Item("imported bottle of perfume", new BigDecimal("27.99"), true);
        categoryList.addItem(impPerfBottle2,"cosmetics");

        Item perfumeBottle = new Item("bottle of perfume", new BigDecimal("18.99"), false);
        categoryList.addItem(perfumeBottle,"cosmetics");

        Item packHeadachePills = new Item("packet of headache pills", new BigDecimal("9.75"), false);
        categoryList.addItem(packHeadachePills,"medical products");

        Item boxImpChoco = new Item("box of imported chocolates", new BigDecimal("11.25"), true);
        categoryList.addItem(boxImpChoco,"food");

        return categoryList;
    }
}
