import java.util.LinkedList;
import java.util.Queue;

public class PizzaQueue {
    private Queue<String> pizzaOrders = new LinkedList<>();

    public void addPizzaOrder(String order) {
        pizzaOrders.add(order);
    }

    public String getNextPizzaOrder() {
        if (!pizzaOrders.isEmpty()) {
            return pizzaOrders.poll();
        }
        return "No orders in queue";
    }

    public int getQueueSize() {
        return pizzaOrders.size();
    }

    public boolean isQueueEmpty() {
        return pizzaOrders.isEmpty();
    }
}