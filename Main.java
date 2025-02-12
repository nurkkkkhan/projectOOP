import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "purkhan20";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/online-shop";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        while (true) {
            System.out.println("\n--- Online Shop Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Show Products");
            System.out.println("5. Buy Products");
            System.out.println("6. Enter Customer Details (Name, Surname, Product, Email, Address, Price)");
            System.out.println("7. Enter Payment Method");
            System.out.println("8. Pay");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int command = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (command == 1) { // Add Product
                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();
                System.out.print("Enter product price: ");
                float price = scanner.nextFloat();

                String sql = "INSERT INTO shop (product, price) VALUES (?, ?);";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, productName);
                preparedStatement.setFloat(2, price);
                preparedStatement.executeUpdate();
                System.out.println("Product added successfully!");

            } else if (command == 2) { // Remove Product
                System.out.print("Enter product ID to remove: ");
                int productId = scanner.nextInt();
                String sql = "DELETE FROM shop WHERE id=?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, productId);
                preparedStatement.executeUpdate();
                System.out.println("Product removed successfully!");

            } else if (command == 3) { // Update Product
                System.out.print("Enter product ID to update: ");
                int productId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new product name: ");
                String newProduct = scanner.nextLine();
                System.out.print("Enter new price: ");
                int newPrice = scanner.nextInt();

                String sql = "UPDATE shop SET product=?, price=? WHERE id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, newProduct);
                preparedStatement.setFloat(2, newPrice);
                preparedStatement.setInt(3, productId);
                preparedStatement.executeUpdate();
                System.out.println("Product updated successfully!");

            } else if (command == 4) { // Show Products
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM shop";
                ResultSet result = statement.executeQuery(sql);

                System.out.println("\n--- Product List ---");
                while (result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    String surname = result.getString("surname");
                    String product = result.getString("product");
                    String email = result.getString("email");
                    String address = result.getString("address");
                    float price = result.getFloat("price");

                    System.out.println("ID: " + id +
                            " | Name: " + name +
                            " | Surname: " + surname +
                            " | Product: " + product +
                            " | Email: " + email +
                            " | Address: " + address +
                            " | Price: $" + price);
                }

            } else if (command == 5) { // Buy Products
                System.out.println("You are about to buy the products listed in your cart.");

            } else if (command == 6) { // Enter Customer Details
                System.out.print("Enter customer name: ");
                String name = scanner.nextLine();
                System.out.print("Enter customer surname: ");
                String surname = scanner.nextLine();
                System.out.print("Enter product name: ");
                String product = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                System.out.print("Enter price: ");
                float price = scanner.nextFloat();

                String sql = "INSERT INTO shop (name, surname, product, email, address, price) VALUES (?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, surname);
                preparedStatement.setString(3, product);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, address);
                preparedStatement.setFloat(6, price);
                preparedStatement.executeUpdate();

                System.out.println("Customer details added successfully!");

            } else if (command == 7) { // Enter Payment Method
                System.out.print("Enter payment method (Credit/Debit/PayPal): ");
                String paymentMethod = scanner.nextLine();
                System.out.println("Payment method recorded: " + paymentMethod);

            } else if (command == 8) { // Pay
                System.out.println("Processing payment... Payment successful!");

            } else if (command == 9) { // Exit
                System.out.println("Exiting program...");
                break;

            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
        connection.close();
    }
}
