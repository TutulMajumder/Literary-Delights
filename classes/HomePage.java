package classes;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends JFrame {

    private List<String> allBooks = new ArrayList<>();
    private JPanel bookGridPanel;
    private Cart cart = new Cart(); // Cart object for managing the cart
    private JLabel noBooksFoundLabel;
    private Login login;  // Store the login object here
    // Label to display no books found message

    // Updated constructor to accept a Login object
    public HomePage(Login login) {
        this.login = login; // Store the passed Login object
        // Frame setup
        setTitle("Book Shop");
        setSize(1080, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Using absolute layout for precise positioning
        setResizable(false);

        // Initialize the list of all books (loaded from file)
        loadBooksFromFile("AllTextFiles/BookInfo.txt");

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80));
        headerPanel.setBounds(0, 0, 1080, 100);
        headerPanel.setLayout(null);

        JLabel headerLabel = new JLabel("Book Shop");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBounds(20, 30, 200, 40);

        // Search Field (smaller size)
        JTextField searchField = new JTextField("Search books...");
        searchField.setBounds(260, 35, 300, 30); // Smaller and shifted left
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setForeground(Color.GRAY);

        // Placeholder text behavior for search field
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Search books...")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Search books...");
                    searchField.setForeground(Color.GRAY);
                }
            }
        });

        // Listener for search field
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchTerm = searchField.getText().toLowerCase();
                updateBookGrid(searchTerm);
            }
        });

        // Add About Us and Contact Us buttons
        JButton aboutUsButton = new JButton("About Us");
        aboutUsButton.setBounds(580, 35, 90, 30); // Shifted left and smaller
        aboutUsButton.setBackground(new Color(52, 152, 219));
        aboutUsButton.setForeground(Color.WHITE);
        aboutUsButton.setFont(new Font("Arial", Font.PLAIN, 12));
        aboutUsButton.addActionListener(e -> {
            this.setVisible(false);
            new AboutUs(this); // Open About Us page
        });

        JButton contactUsButton = new JButton("Contact Us");
        contactUsButton.setBounds(680, 35, 100, 30); // Shifted left and smaller
        contactUsButton.setBackground(new Color(52, 152, 219));
        contactUsButton.setForeground(Color.WHITE);
        contactUsButton.setFont(new Font("Arial", Font.PLAIN, 12));
        contactUsButton.addActionListener(e -> {
            this.setVisible(false);
            new ContactUs(this); // Open Contact Us page
        });

        // Profile Button added here
        JButton profileButton = new JButton("Profile");
        profileButton.setBounds(900, 35, 80, 30); // Position the button near the cart button
        profileButton.setBackground(new Color(52, 152, 219));
        profileButton.setForeground(Color.WHITE);
        profileButton.setFont(new Font("Arial", Font.PLAIN, 12));
        profileButton.addActionListener(e -> {
            this.setVisible(false);
            new Profile(login, this); // Open Profile page with the login object
        });

        profileButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                profileButton.setBackground(new Color(41, 128, 185));
            }

            public void mouseExited(MouseEvent evt) {
                profileButton.setBackground(new Color(52, 152, 219));
            }
        });

        headerPanel.add(profileButton);

        // Cart Button
        JButton cartButton = new JButton("Cart");
        cartButton.setBackground(new Color(52, 152, 219));
        cartButton.setForeground(Color.WHITE);
        cartButton.setFont(new Font("Arial", Font.PLAIN, 12));
        cartButton.setBounds(800, 35, 80, 30); // Smaller and shifted left
        cartButton.addActionListener(e -> cart.showCart());

        cartButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                cartButton.setBackground(new Color(41, 128, 185));
            }

            public void mouseExited(MouseEvent evt) {
                cartButton.setBackground(new Color(52, 152, 219));
            }
        });

        headerPanel.add(headerLabel);
        headerPanel.add(searchField);
        headerPanel.add(aboutUsButton);
        headerPanel.add(contactUsButton);
        headerPanel.add(cartButton);

        // Book Grid Area
        bookGridPanel = new JPanel();
        bookGridPanel.setBackground(Color.WHITE);
        bookGridPanel.setBounds(20, 100, 1040, 450);
        bookGridPanel.setLayout(new GridLayout(0, 5, 20, 20)); // Grid layout with 5 columns

        JScrollPane scrollPane = new JScrollPane(bookGridPanel);
        scrollPane.setBounds(20, 100, 1040, 450);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createIncreaseButton(orientation);
                button.setBackground(new Color(44, 62, 80));
                return button;
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(new Color(44, 62, 80));
                return button;
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                g.setColor(new Color(52, 73, 94));
                g.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
            }
        });

        updateBookGrid("");

        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(44, 62, 80));
        footerPanel.setBounds(0, 550, 1080, 100);
        footerPanel.setLayout(new BorderLayout());

        // Shorter Footer Text
        JLabel footerLabel = new JLabel("© 2024 Book Shop");
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        footerPanel.add(footerLabel, BorderLayout.CENTER);

        // Add all panels to the frame
        add(headerPanel);
        add(scrollPane);
        add(footerPanel);

        setLocationRelativeTo(null);
        this.setVisible(true); // Ensure the frame is visible when constructed
    }

    // Method to update the book grid based on the search term
    private void updateBookGrid(String searchTerm) {
        bookGridPanel.removeAll();
        boolean foundMatch = false;
        for (String bookInfo : allBooks) {
            // Skip empty lines
            if (bookInfo.trim().isEmpty()) continue;
            String[] bookDetails = bookInfo.split(",");
            if (bookDetails.length < 3) continue; // Skip malformed lines
            String bookName = bookDetails[0].trim();
            String bookAuthor = bookDetails[1].trim();
            String priceStr = bookDetails[2].trim();
            String coverImagePath = (bookDetails.length > 3) ? bookDetails[3].trim() : "Images/500x650.png";
            Double bookPrice;
            try {
                bookPrice = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                bookPrice = 0.0;
            }
            final double finalBookPrice = bookPrice;
            File imgFile = new File(coverImagePath);
            if (!imgFile.exists()) {
                coverImagePath = "Images/500x650.png";
            }
            if (bookName.toLowerCase().contains(searchTerm)) {
                foundMatch = true;
                JPanel bookPanel = new JPanel();
                bookPanel.setBackground(new Color(240, 240, 240));
                bookPanel.setPreferredSize(new Dimension(150, 300));
                bookPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
                JLabel coverLabel = new JLabel();
                ImageIcon bookCover = loadImage(coverImagePath, 122, 186);
                coverLabel.setIcon(bookCover);
                coverLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                bookPanel.add(coverLabel);
                JLabel bookLabel = new JLabel(bookName);
                bookLabel.setFont(new Font("Arial", Font.BOLD, 14));
                bookLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                JLabel authorLabel = new JLabel("By " + bookAuthor);
                authorLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                JLabel priceLabel = new JLabel("৳" + String.format("%.2f", finalBookPrice));
                priceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                bookPanel.add(Box.createVerticalStrut(10));
                bookPanel.add(bookLabel);
                bookPanel.add(authorLabel);
                bookPanel.add(priceLabel);
                JButton addToCartButton = new JButton("Add to Cart");
                addToCartButton.setBackground(new Color(52, 152, 219));
                addToCartButton.setForeground(Color.WHITE);
                addToCartButton.setFont(new Font("Arial", Font.PLAIN, 12));
                addToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                addToCartButton.addActionListener(e -> {
                    cart.addBook(new Book(bookName, bookAuthor, finalBookPrice));
                    JOptionPane.showMessageDialog(this, bookName + " added to cart.");
                });
                bookPanel.add(Box.createVerticalStrut(10));
                bookPanel.add(addToCartButton);
                bookGridPanel.add(bookPanel);
            }
        }
        if (!foundMatch) {
            if (noBooksFoundLabel == null) {
                noBooksFoundLabel = new JLabel("No books found.");
                noBooksFoundLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                noBooksFoundLabel.setForeground(Color.RED);
                noBooksFoundLabel.setHorizontalAlignment(SwingConstants.CENTER);
            }
            bookGridPanel.add(noBooksFoundLabel);
        }
        bookGridPanel.revalidate();
        bookGridPanel.repaint();
    }

    // Load image from file path
    private ImageIcon loadImage(String imagePath, int width, int height) {
        try {
            if (imagePath != null && new File(imagePath).exists()) {
                BufferedImage img = ImageIO.read(new File(imagePath));
                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedImage placeholder = ImageIO.read(new File("Images/placeholder.png"));
            Image scaledImg = placeholder.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Load books from a file
    private void loadBooksFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                allBooks.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login login = new Login(); // Make sure the login instance is created
            HomePage homePage = new HomePage(login); // Pass login instance to HomePage
            homePage.setVisible(true);
        });
    }
}
