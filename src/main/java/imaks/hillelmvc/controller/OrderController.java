package imaks.hillelmvc.controller;

import imaks.hillelmvc.entity.Order;
import imaks.hillelmvc.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepo orderRepo;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody Order order) {
        Long orderId = orderRepo.save(order);

        if (orderId == null) {
            return ResponseEntity.badRequest().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{Id}")
                .buildAndExpand(orderId)
                .toUri();

        return ResponseEntity.created(location).body(orderId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = orderRepo.findById(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderRepo.findAll());
    }
}
