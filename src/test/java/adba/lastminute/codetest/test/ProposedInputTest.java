package adba.lastminute.codetest.test;

import adba.lastminute.codetest.model.category.CategoriesRepository;
import adba.lastminute.codetest.model.receipt.Receipt;
import adba.lastminute.codetest.model.receipt.ShoppingList;
import adba.lastminute.codetest.service.ReceiptServiceInterface;
import adba.lastminute.codetest.util.print.ReceiptPrinter;
import adba.lastminute.codetest.service.ReceiptService;
import adba.lastminute.codetest.test.builder.CategoriesInit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProposedInputTest {

    CategoriesRepository categoriesRepository;

    ReceiptServiceInterface receiptService;

    @BeforeEach
    public void setUp(){
        categoriesRepository = CategoriesInit.initialCategories();
        receiptService = ReceiptService.of(categoriesRepository);
    }

    @ParameterizedTest
    @DisplayName("Shopping Basket #")
    @MethodSource("adba.lastminute.codetest.test.builder.ReceiptServiceArguments#receiptServiceArguments")
    void proposed_input(ShoppingList shoppingListInput, Receipt expectedReceipt){
        Receipt receipt = receiptService.generateReceipt(shoppingListInput);

        assertEquals(expectedReceipt, receipt);

        System.out.println(ReceiptPrinter.builder()
                            .receipt(receipt).build()
                            .print());
    }
}
