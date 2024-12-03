
public class Book {
    private final String title;
    private final String author;
    private double price;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.00;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price > 0 ? price : 0.00;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.printf("Price: $%.2f\n", price);
    }

    // Method to update the price
    public void updatePrice(double newPrice) {
        if (newPrice > 0) {
            price = newPrice;
            System.out.printf("Price updated successfully to: $%.2f\n", price);
        } else {
            System.out.println("Invalid price! Price must be positive.");
        }
    }

    // Method to apply a discount
    public void applyDiscount(double discountPercentage) {
        if (discountPercentage > 0.00 && discountPercentage < 100.00) {
            double discountAmount = (discountPercentage / 100.00) * price;
            price -= discountAmount;
            System.out.printf("Discount of %.2f%% applied. New price: $%.2f\n", discountPercentage, price);
        } else {
            System.out.println("Invalid discount! Discount percentage must be between 0.00 and 100.00.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Book unknownBook = new Book();
        unknownBook.displayDetails();

        Book hp1Book = new Book("Harry Potter and Philosopher's Stone", "J.K Rowling", 350.00);
        hp1Book.displayDetails();

        // Testing price updates
        hp1Book.updatePrice(32000.00);
        hp1Book.displayDetails();

        hp1Book.updatePrice(-100.00);
        hp1Book.displayDetails();

        // Testing discounts
        hp1Book.applyDiscount(-20); // Invalid
        hp1Book.applyDiscount(0); // Invalid
        hp1Book.applyDiscount(0.5); // Valid
        hp1Book.applyDiscount(25.00); // Valid
        hp1Book.applyDiscount(50); // Valid
        hp1Book.applyDiscount(100.00); // Invalid
        hp1Book.applyDiscount(150); // Invalid
    }
}
