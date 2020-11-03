package adba.lastminute.codetest.test.builder;

import adba.lastminute.codetest.model.item.Item;
import adba.lastminute.codetest.model.receipt.ShoppingList;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProposedInput {

    public static List<ShoppingList> allExpectedInputs(){
        return Arrays.asList(shoppingListInput1(), shoppingListInput2(), shoppingListInput3());
    }


    public static ShoppingList shoppingListInput1(){
        Item book = new Item("book", new BigDecimal("12.49"), false);
        Item musicCD = new Item("music CD", new BigDecimal("14.99"), false);
        Item choco = new Item("chocolate bar", new BigDecimal("0.85"),false);

        return ShoppingList.of(Arrays.asList(book,musicCD,choco));
    }

    public static ShoppingList shoppingListInput2(){
        Item impChocoBox = new Item("imported box of chocolates ", new BigDecimal("10.00"), true);
        Item impPerfBottle = new Item("imported bottle of perfume", new BigDecimal("47.50"), true);

        return ShoppingList.of(Arrays.asList(impChocoBox, impPerfBottle));
    }

    public static ShoppingList shoppingListInput3(){
        Item impPerfBottle2 = new Item("imported bottle of perfume", new BigDecimal("27.99"), true);
        Item perfumeBottle = new Item("bottle of perfume", new BigDecimal("18.99"), false);
        Item packHeadachePills = new Item("packet of headache pills", new BigDecimal("9.75"), false);
        Item boxImpChoco = new Item("box of imported chocolates", new BigDecimal("11.25"), true);

        return ShoppingList.of(Arrays.asList(impPerfBottle2, perfumeBottle, packHeadachePills, boxImpChoco));

    }

}
