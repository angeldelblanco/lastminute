package adba.lastminute.codetest.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceOperations {

    public static final BigDecimal NEAREST = new BigDecimal("0.05");

    public static BigDecimal percentage(BigDecimal base, String percentage) {
        return round(base.multiply(new BigDecimal(percentage)), NEAREST);
    }

    private static BigDecimal round(BigDecimal price, BigDecimal nearest) {
        //TODO test with negative numbers
        if (nearest.signum() == 0) {
            return price;
        }
        // take care of numbers with '5' in the second decimal (e.g. '2.95')
        int decimal = price.remainder(BigDecimal.ONE).setScale(2, RoundingMode.HALF_DOWN)
                                                                .multiply(new BigDecimal("100")).intValue();
        if (decimal % 5 == 0) {
            return price.setScale(2, RoundingMode.HALF_DOWN);
        }

        return price.divide(nearest, 1, RoundingMode.HALF_EVEN)
                            .multiply(nearest).setScale(1, RoundingMode.HALF_EVEN);
    }
}
