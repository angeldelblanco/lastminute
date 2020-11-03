package adba.lastminute.codetest.model.receipt;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
public class Receipt extends ShoppingList {

    private final BigDecimal salesTaxes;

    private final BigDecimal total;

    @Builder
    public Receipt(ShoppingList shoppingList, BigDecimal salesTaxes, BigDecimal total){
        super(shoppingList.getPurchases());
        this.salesTaxes = salesTaxes;
        this.total = total;

    }

}
