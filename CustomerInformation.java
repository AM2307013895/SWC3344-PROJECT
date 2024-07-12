import java.util.ArrayList; // Import ArrayList class from the java.util package
import java.util.List; // Import List interface from the java.util package

// Define the CustomerInformation class
public class CustomerInformation{
    private String custId; // Declare a private String variable for customer ID
    private String custName; // Declare a private String variable for customer name
    private int tableNumber; // Declare a private int variable for table number
    private List<OrderInformation> orders; // Declare a private List to hold OrderInformation objects

    // Constructor
    public CustomerInformation(String custId, String custName, int tableNumber) {
        this.custId = custId; // Initialize the customer ID
        this.custName = custName; // Initialize the customer name
        this.tableNumber = tableNumber; // Initialize the table number
        this.orders = new ArrayList<>(); // Initialize the orders list as an empty ArrayList
    }

    // Getters and Setters
    public String getCustId() {
        return custId; // Return the customer ID
    }

    public void setCustId(String custId) {
        this.custId = custId; // Set the customer ID
    }

    public String getCustName() {
        return custName; // Return the customer name
    }

    public void setCustName(String custName) {
        this.custName = custName; // Set the customer name
    }

    public int getTableNumber() {
        return tableNumber; // Return the table number
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber; // Set the table number
    }

    public List<OrderInformation> getOrders() {
        return orders; // Return the list of orders
    }

    public void addOrder(OrderInformation order) {
        this.orders.add(order); // Add an order to the list of orders
    }

    @Override
    public String toString() {
        return "CustomerInformation{" + // Start the string representation of the CustomerInformation object
                "custId='" + custId + '\'' + // Add the customer ID to the string representation
                ", custName='" + custName + '\'' + // Add the customer name to the string representation
                ", tableNumber=" + tableNumber + // Add the table number to the string representation
                ", orders=" + orders + // Add the list of orders to the string representation
                '}'; // End the string representation
            }
}