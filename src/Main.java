public class Main{
    public static void main(String[] args) throws Exception {
        HandleOrders handleOrders = new HandleOrders();
        handleOrders.takeOrder();
        handleOrders.displayCustomPizzas(); 
        handleOrders.createOrderSummary();
        System.out.println(handleOrders);

        OrderLogs orderLogs = new OrderLogs();
        orderLogs.handleLogs();
    }
}
