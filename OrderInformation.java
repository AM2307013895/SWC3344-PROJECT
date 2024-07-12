//import package
import java.util.*;

public class OrderInformation{
    private String orderId; // Declare a private String variable for order ID
    private String itemName; // Declare a private String variable for item name
    private double itemPrice; // Declare a private double variable for item price
    private int quantity; // Declare a private int variable for quantity
    private String orderTime; // Declare a private String variable for order time

    // Constructor
    public OrderInformation(String orderId, String itemName, double itemPrice, int quantity, String orderTime) {
        this.orderId = orderId; // Initialize the order ID
        this.itemName = itemName; // Initialize the item name
        this.itemPrice = itemPrice; // Initialize the item price
        this.quantity = quantity; // Initialize the quantity
        this.orderTime = orderTime; // Initialize the order time
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId; // Return the order ID
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId; // Set the order ID
    }

    public String getItemName() {
        return itemName; // Return the item name
    }

    public void setItemName(String itemName) {
        this.itemName = itemName; // Set the item name
    }

    public double getItemPrice() {
        return itemPrice; // Return the item price
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice; // Set the item price
    }

    public int getQuantity() {
        return quantity; // Return the quantity
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity; // Set the quantity
    }

    public String getOrderTime() {
        return orderTime; // Return the order time
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime; // Set the order time
    }

    @Override
    public String toString() {
        return "OrderInformation{" + // Start the string representation of the OrderInformation object
                "orderId='" + orderId + '\'' + // Add the order ID to the string representation
                ", itemName='" + itemName + '\'' + // Add the item name to the string representation
                ", itemPrice=" + itemPrice + // Add the item price to the string representation
                ", quantity=" + quantity + // Add the quantity to the string representation
                ", orderTime='" + orderTime + '\'' + // Add the order time to the string representation
                '}'; // End the string representation
            }
}