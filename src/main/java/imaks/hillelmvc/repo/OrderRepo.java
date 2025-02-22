package imaks.hillelmvc.repo;

import imaks.hillelmvc.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepo {

    Long save(Order order);
    Order findById(Long id);
    List<Order> findAll();

}
