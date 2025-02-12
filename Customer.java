package basis;

import java.util.Objects;

class Customer {
    private String id;
    private String name;
    private String email;
    private String address;

    // Constructor
    public Customer(String id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{id='" + id + "', name='" + name + "', email='" + email + "', address='" + address + "'}";
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return Objects.equals(id, customer.id) &&
                Objects.equals(email, customer.email);
    }

    // HashCode method
    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
