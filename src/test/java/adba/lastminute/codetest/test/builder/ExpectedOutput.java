package adba.lastminute.codetest.test.builder;

import adba.lastminute.codetest.model.item.Item;
import adba.lastminute.codetest.model.receipt.Receipt;
import adba.lastminute.codetest.model.receipt.ShoppingList;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ExpectedOutput {

    public static List<Receipt> allExpectedReceipts(){
        return Arrays.asList(receiptExpected1(), receiptExpected2(), receiptExpected3());
    }


    public static Receipt receiptExpected1(){
        Item book = new Item("book", new BigDecimal("12.49"), false);
        Item musicCDExpected = new Item("music CD", new BigDecimal("16.49"), false);
        Item choco = new Item("chocolate bar", new BigDecimal("0.85"),false);

        ShoppingList shoppingListExpected = ShoppingList.of(Arrays.asList(book,musicCDExpected,choco));

        return Receipt.builder()
                .shoppingList(shoppingListExpected)
                .salesTaxes(new BigDecimal("1.50"))
                .total(new BigDecimal("29.83"))
                .build();
    }

    public static Receipt receiptExpected2(){
        Item impChocoBoxExpected = new Item("imported box of chocolates ", new BigDecimal("10.50"), true);
        Item impPerfBottleExpected = new Item("imported bottle of perfume", new BigDecimal("54.65"), true);

        ShoppingList shoppingListExpected = ShoppingList.of(Arrays.asList(impChocoBoxExpected, impPerfBottleExpected));

        return Receipt.builder()
                .shoppingList(shoppingListExpected)
                .salesTaxes(new BigDecimal("7.65"))
                .total(new BigDecimal("65.15"))
                .build();
    }

    public static Receipt receiptExpected3(){
        Item impPerfBottle2Expected = new Item("imported bottle of perfume", new BigDecimal("32.19"), true);
        Item perfumeBottleExpected = new Item("bottle of perfume", new BigDecimal("20.89"), false);
        Item packHeadachePills = new Item("packet of headache pills", new BigDecimal("9.75"), false);
        Item boxImpChocoExpected = new Item("box of imported chocolates", new BigDecimal("11.85"), true);

        ShoppingList shoppingListExpected = ShoppingList.of(Arrays.asList(impPerfBottle2Expected,perfumeBottleExpected, packHeadachePills, boxImpChocoExpected));

        return Receipt.builder()
                .shoppingList(shoppingListExpected)
                .salesTaxes(new BigDecimal("6.70"))
                .total(new BigDecimal("74.68"))
                .build();
    }

}
