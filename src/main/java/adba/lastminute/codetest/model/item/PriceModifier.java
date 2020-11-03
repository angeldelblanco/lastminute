package adba.lastminute.codetest.model.item;


import java.math.BigDecimal;

public interface PriceModifier {

    BigDecimal getPrice();

    BigDecimal finalPrice();

    BigDecimal costVariation();
}
