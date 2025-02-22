package imaks.hillelmvc.repo;

import imaks.hillelmvc.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepoImpl implements OrderRepo {

    private final Map<Long, Order> orders = new HashMap<>();

    @Override
    public Long save(Order order) {
        if (orders.containsKey(order.getId()) || order.getId() == null) {
            return null;
        }
        orders.put(order.getId(), order);
        return order.getId();
    }

    @Override
    public Order findById(Long id) {
        if (orders.containsKey(id)) {
            return orders.get(id);
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orders.values().stream().toList();
    }
}
