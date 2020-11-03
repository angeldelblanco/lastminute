package adba.lastminute.codetest.util.print;


import adba.lastminute.codetest.model.receipt.Receipt;
import lombok.Builder;

@Builder
public class ReceiptPrinter implements Print {

    private final Receipt receipt;

    @Override
    public String print() {
        if (receipt == null || receipt.isEmpty()) {
            //TODO throw exception
            return "";
        }

        StringBuilder sb = new StringBuilder();
        receipt.getPurchasesList().stream().forEach(purchase -> sb.append(purchase.getQuantity())
                .append(" ")
                .append(purchase.getName())
                .append(": ")
                .append(String.format("%.2f",purchase.getPrice()))
                .append("\n"));

        sb.append("Sales Taxes: ")
                .append(String.format("%.2f",receipt.getSalesTaxes()))
                .append("\nTotal: ")
                .append(receipt.getTotal());

        return sb.toString();
    }
}
