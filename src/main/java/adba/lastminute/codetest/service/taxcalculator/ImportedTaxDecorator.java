package adba.lastminute.codetest.service.taxcalculator;

import adba.lastminute.codetest.model.item.PriceModifier;
import adba.lastminute.codetest.util.PriceOperations;

import java.math.BigDecimal;

public class ImportedTaxDecorator extends PriceModifierDecorator{

    private static final String IMPORTED_TAX = "0.05";

    public ImportedTaxDecorator(PriceModifier wrapee) {
        super(wrapee);
    }

    @Override
    public BigDecimal getPrice() {
        return wrapee.getPrice();
    }

    @Override
    public BigDecimal finalPrice(){
        return super.finalPrice().add(PriceOperations.percentage(wrapee.getPrice(), IMPORTED_TAX));
    }

    @Override
    public BigDecimal costVariation() {
        return super.costVariation().add(PriceOperations.percentage(wrapee.getPrice(), IMPORTED_TAX));
    }
}
