package classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Book> books = new ArrayList<>();
    private JFrame cartFrame;
    private JPanel cartItemsPanel;
    private JLabel totalLabel, subtotalLabel, onlineFeeLabel, payableTotalLabel;

    public Cart() {
        // Set up the cart window (JFrame)
        cartFrame = new JFrame("Cart");
        cartFrame.setSize(800, 600);
        cartFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        cartFrame.setLayout(new BorderLayout());

        // Main split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(500);
        splitPane.setDividerSize(1);

        // Cart Items Panel (Left Side)
        cartItemsPanel = new JPanel();
        cartItemsPanel.setLayout(new BoxLayout(cartItemsPanel, BoxLayout.Y_AXIS));
        JScrollPane cartScrollPane = new JScrollPane(cartItemsPanel);
        splitPane.setLeftComponent(cartScrollPane);

        // Checkout Summary Panel (Right Side)
        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.Y_AXIS));
        checkoutPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        splitPane.setRightComponent(checkoutPanel);

        // Add components to the checkout panel
        subtotalLabel = new JLabel("Subtotal: 0 TK.");
        onlineFeeLabel = new JLabel("Online Fee: 0 TK.");
        totalLabel = new JLabel("Total: 0 TK.");
        payableTotalLabel = new JLabel("Payable Total: 0 TK.");

        subtotalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        onlineFeeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        payableTotalLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton giftButton = new JButton("Order as a Gift");
        JButton checkoutButton = new JButton("Proceed to Checkout");

        // Add action listener to the "Proceed to Checkout" button
        checkoutButton.addActionListener(e -> {
            PaymentFrame paymentFrame = new PaymentFrame(); // Opens the payment frame
            paymentFrame.showPaymentFrame(); // Display the payment frame
        });

        checkoutPanel.add(subtotalLabel);
        checkoutPanel.add(onlineFeeLabel);
        checkoutPanel.add(totalLabel);
        checkoutPanel.add(payableTotalLabel);
        checkoutPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        checkoutPanel.add(giftButton);
        checkoutPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Spacer
        checkoutPanel.add(checkoutButton);

        // Add split pane to the frame
        cartFrame.add(splitPane, BorderLayout.CENTER);

        updateCart();
    }

    // Method to add a book to the cart
    public void addBook(Book book) {
        books.add(book);
        updateCart();
    }

    // Method to remove a book from the cart
    public void removeBook(Book book) {
        books.remove(book);
        updateCart();
    }

    // Update the cart display
    private void updateCart() {
        cartItemsPanel.removeAll(); // Clear the panel before updating it
        double subtotal = 0.0;
        double onlineFee = 48.0; // Fixed fee for demonstration
        double total;

        // Loop through each book and display it in the cart
        for (Book book : books) {
            JPanel bookPanel = new JPanel(new BorderLayout());
            bookPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

            // Book image (placeholder)
            JLabel bookImage = new JLabel();
            bookImage.setPreferredSize(new Dimension(60, 80));
            bookImage.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            // Book details
            JPanel bookDetailsPanel = new JPanel();
            bookDetailsPanel.setLayout(new BoxLayout(bookDetailsPanel, BoxLayout.Y_AXIS));

            JLabel bookTitle = new JLabel(book.getName());
            JLabel bookAuthor = new JLabel("By: " + book.getAuthor());
            JLabel bookPrice = new JLabel("Price: " + book.getPrice() + " TK.");

            bookDetailsPanel.add(bookTitle);
            bookDetailsPanel.add(bookAuthor);
            bookDetailsPanel.add(bookPrice);

            // Quantity controls
            JPanel quantityPanel = new JPanel();
            JButton increaseButton = new JButton("+");
            JButton decreaseButton = new JButton("-");
            JLabel quantityLabel = new JLabel("Qty: " + book.getQuantity());

            increaseButton.addActionListener(e -> {
                book.incrementQuantity();
                updateCart();
            });

            decreaseButton.addActionListener(e -> {
                if (book.getQuantity() > 1) {
                    book.decrementQuantity();
                    updateCart();
                }
            });

            quantityPanel.add(decreaseButton);
            quantityPanel.add(quantityLabel);
            quantityPanel.add(increaseButton);

            // Remove button
            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(e -> removeBook(book));

            // Add components to book panel
            bookPanel.add(bookImage, BorderLayout.WEST);
            bookPanel.add(bookDetailsPanel, BorderLayout.CENTER);
            bookPanel.add(quantityPanel, BorderLayout.EAST);
            bookPanel.add(removeButton, BorderLayout.SOUTH);

            // Add book panel to the cart
            cartItemsPanel.add(bookPanel);
            // Update subtotal
            subtotal += book.getPrice() * book.getQuantity();
        }

        // Update summary labels
        total = subtotal + onlineFee;
        subtotalLabel.setText("Subtotal: " + String.format("%.2f TK.", subtotal));
        onlineFeeLabel.setText("Online Fee: " + String.format("%.2f TK.", onlineFee));
        totalLabel.setText("Total: " + String.format("%.2f TK.", total));
        payableTotalLabel.setText("Payable Total: " + String.format("%.2f TK.", total));

        // Refresh display
        cartItemsPanel.revalidate();
        cartItemsPanel.repaint();
    }

    // Method to show the cart window
    public void showCart() {
        cartFrame.setVisible(true);
    }
}
