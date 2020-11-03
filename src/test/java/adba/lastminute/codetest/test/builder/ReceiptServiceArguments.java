package adba.lastminute.codetest.test.builder;

import adba.lastminute.codetest.model.receipt.Receipt;
import adba.lastminute.codetest.model.receipt.ShoppingList;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReceiptServiceArguments {

    public static Stream<Arguments> receiptServiceArguments(){

        BiFunction<ShoppingList, Receipt, Arguments> generator = (sh, re) -> Arguments.of(sh, re);

        List<ShoppingList> shoppingLists = ProposedInput.allExpectedInputs();
        List<Receipt> receipts = ExpectedOutput.allExpectedReceipts();
        return IntStream.range(0, shoppingLists.size())
                .mapToObj(i -> generator.apply(shoppingLists.get(i), receipts.get(i)));
    }
}