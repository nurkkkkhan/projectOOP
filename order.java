package basis;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Order {
    private String orderId;
    private Customer customer;
    private List<NameProduct> products;
    private float price;

    // Constructor
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.price = 0.0f; // Initialize price to zero
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<NameProduct> getProducts() {
        return products;
    }

    public float getPrice() {
        return price;
    }

    // Method to add a product and update the total price
    public void addProduct(NameProduct product) {
        products.add(product);
        this.price += product.getPrice(); // Assuming NameProduct has a getPrice() method
    }

    // toString method
    @Override
    public String toString() {
        return "Order{orderId='" + orderId + "', customer=" + customer +
                ", products=" + products + ", totalPrice=" + price + '}';
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return Objects.equals(orderId, order.orderId);
    }

    // HashCode method
    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
