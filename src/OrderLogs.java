import java.util.ArrayDeque;
import java.util.Scanner;

public class OrderLogs {
    private ArrayDeque<String> orderLogs = new ArrayDeque<>();

    public OrderLogs() {}

    public void addOrderLog(String log) {
        orderLogs.push(log);
    }

    public String mostRecentLogEntry() {
        if (!orderLogs.isEmpty()) {
            return orderLogs.peek();
        }
        return "No log entries";
    }

    public String getOrderLog() {
        if (!orderLogs.isEmpty()) {
            return orderLogs.pop();
        }
        return "No log entries";
    }

    /**
     * 
     */
    public void removeAllLogEntries() {
        orderLogs.clear();
    }

    public boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }

    public void handleLogs() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Order Log");
            System.out.println("2. View Most Recent Log Entry");
            System.out.println("3. Get Order Log");
            System.out.println("4. Remove All Log Entries");
            System.out.println("5. Check if Logs are Empty");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter log message: ");
                    input.nextLine();
                    String log = input.nextLine();
                    addOrderLog(log);
                    break;
                case 2:
                    System.out.println(mostRecentLogEntry());
                    break;
                case 3:
                    System.out.println(getOrderLog());
                    break;
                case 4:
                    removeAllLogEntries();
                    System.out.println("All log entries removed");
                    break;
                case 5:
                    System.out.println("Are logs empty? " + orderLogsEmpty());
                    break;
                case 6:
                    System.out.println("Exiting log handling...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }
}
