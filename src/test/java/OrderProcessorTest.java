import com.cake.order.Order;
import com.cake.order.OrderProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderProcessorTest {
    private OrderProcessor orderProcessor;

    @BeforeEach
    void setUp() {
        orderProcessor = new OrderProcessor();
    }

    @Test
    void testAddOrder() {
        Order order = new Order("O1", "ABC", 100, 10.0);

        orderProcessor.addOrder(order);

        List<Order> orders = orderProcessor.getOrders();
        Assertions.assertEquals(1, orders.size());
        Assertions.assertEquals(order, orders.get(0));
    }
}
