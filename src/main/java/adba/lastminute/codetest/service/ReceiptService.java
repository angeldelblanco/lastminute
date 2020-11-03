package adba.lastminute.codetest.service;

import adba.lastminute.codetest.model.category.CategoriesRepository;
import adba.lastminute.codetest.model.receipt.ShoppingList;
import adba.lastminute.codetest.model.receipt.ShoppingListInterface;
import adba.lastminute.codetest.service.taxcalculator.BasicTaxDecorator;
import adba.lastminute.codetest.service.taxcalculator.ImportedTaxDecorator;
import adba.lastminute.codetest.model.item.PriceModifier;
import adba.lastminute.codetest.model.item.Purchase;
import adba.lastminute.codetest.model.receipt.Receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReceiptService implements ReceiptServiceInterface{

    private final CategoriesRepository categoriesRepository;

    private ReceiptService(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Receipt generateReceipt(ShoppingListInterface shoppingList) {

        BigDecimal total = BigDecimal.ZERO;
        BigDecimal salesTaxes = BigDecimal.ZERO;
        List<Purchase> purchasesFinalPrice = new ArrayList<>();


        for (Purchase purchase : shoppingList.getPurchasesList()) {
            PriceModifier priceModifierDecorator =  purchase;

            if (categoriesRepository.applyTaxes( purchase )){
                priceModifierDecorator = new BasicTaxDecorator(priceModifierDecorator);
            }
            if (purchase.isImported()) {
                priceModifierDecorator = new ImportedTaxDecorator(priceModifierDecorator);
            }

            BigDecimal finalPrice = priceModifierDecorator.finalPrice().multiply(new BigDecimal(purchase.getQuantity()));

            total = total.add(finalPrice);
            salesTaxes = salesTaxes.add(priceModifierDecorator.costVariation());

            purchasesFinalPrice.add(Purchase.builder()
                                        .name(purchase.getName())
                                        .price(finalPrice)
                                        .imported(purchase.isImported())
                                        .quantity(purchase.getQuantity())
                                        .build());

        }
        return Receipt.builder()
                .shoppingList(ShoppingList.ofPurchases(purchasesFinalPrice))
                .salesTaxes(salesTaxes)
                .total(total)
                .build();

    }

    public static ReceiptService of(CategoriesRepository categoriesRepository){
        return new ReceiptService(categoriesRepository);
    }

}
