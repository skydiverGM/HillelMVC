package imaks.hillelmvc.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {

    private Long id;
    private LocalDateTime orderDate;
    private double totalCost;
    private List<Product> products;
}
