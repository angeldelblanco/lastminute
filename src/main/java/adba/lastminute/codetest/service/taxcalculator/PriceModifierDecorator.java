package adba.lastminute.codetest.service.taxcalculator;

import adba.lastminute.codetest.model.item.PriceModifier;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public abstract class PriceModifierDecorator implements PriceModifier {

    protected PriceModifier wrapee;

    @Override
    public BigDecimal finalPrice(){
        return wrapee.finalPrice();
    }

    @Override
    public BigDecimal costVariation(){
        return wrapee.costVariation();
    }
}
