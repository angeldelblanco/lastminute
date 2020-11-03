package adba.lastminute.codetest.service.taxcalculator;

import adba.lastminute.codetest.model.item.PriceModifier;
import adba.lastminute.codetest.util.PriceOperations;

import java.math.BigDecimal;

public class BasicTaxDecorator extends PriceModifierDecorator{

    private static final String BASIC_TAX = "0.1";

    public BasicTaxDecorator(PriceModifier wrapee) {
        super(wrapee);
    }

    @Override
    public BigDecimal getPrice() {
        return wrapee.getPrice();
    }

    @Override
    public BigDecimal finalPrice(){
        return super.finalPrice().add(PriceOperations.percentage(wrapee.getPrice(), BASIC_TAX));
    }

    @Override
    public BigDecimal costVariation() {
        return PriceOperations.percentage(wrapee.getPrice(), BASIC_TAX);
    }
}
