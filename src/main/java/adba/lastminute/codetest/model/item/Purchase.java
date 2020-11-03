package adba.lastminute.codetest.model.item;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
public class Purchase extends Item {

    private int quantity;

    private Purchase(Item item) {
        super(item.getName(), item.getPrice(), item.isImported());
        quantity=1;
    }

    @Builder
    public Purchase(String name, BigDecimal price, boolean imported, int quantity){
        super(name, price, imported);
        this.quantity = quantity;
    }

    public void increaseQuantity(){
        quantity++;
    }

    public void decreaseQuantity(){
        quantity--;
    }

    public static Purchase of(Item item){
        return new Purchase(item);
    }

}
