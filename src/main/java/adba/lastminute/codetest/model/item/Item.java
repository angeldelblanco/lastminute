package adba.lastminute.codetest.model.item;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;


@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Item implements PriceModifier{

    private final String name;

    private final BigDecimal price;

    private final boolean imported;

    @Override
    public BigDecimal finalPrice() {
        return price;
    }

    @Override
    public BigDecimal costVariation() {
        return BigDecimal.ZERO;
    }
}
