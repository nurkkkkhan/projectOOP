package basis;

import java.util.*;

class NameProduct {
    private String id;
    private String name;
    private double price;

    public NameProduct(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "NameProduct{id='" + id + '\'' + ", name='" + name + '\'' + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NameProduct nameProduct = (NameProduct) obj;
        return Objects.equals(id, nameProduct.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
