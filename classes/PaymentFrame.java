package classes;

import javax.swing.*;
import java.awt.*;

public class PaymentFrame {
    private JFrame frame;

    public PaymentFrame() {
        // Set up the main frame
        frame = new JFrame("Payment Method");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setResizable(false);

        // Panel for Payment Methods
        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Payment Method (Please select a payment method)"));

        // Payment Methods - Cash on Delivery
        JRadioButton cashOnDelivery = new JRadioButton("Cash on Delivery");
        paymentPanel.add(cashOnDelivery);

        // Payment Methods - Mobile Wallet
        JPanel mobileWalletPanel = new JPanel();
        mobileWalletPanel.setLayout(new GridLayout(1, 3, 10, 10));

        JRadioButton bkash = new JRadioButton("bKash");
        JRadioButton nagad = new JRadioButton("Nagad");
        JRadioButton rocket = new JRadioButton("Rocket");

        mobileWalletPanel.add(bkash);
        mobileWalletPanel.add(nagad);
        mobileWalletPanel.add(rocket);

        paymentPanel.add(new JLabel("Mobile Wallet"));
        paymentPanel.add(mobileWalletPanel);

        // Payment Methods - Debit/Credit Card
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(1, 3, 10, 10));

        JRadioButton visa = new JRadioButton("Visa");
        JRadioButton mastercard = new JRadioButton("MasterCard");
        JRadioButton amex = new JRadioButton("American Express");

        cardPanel.add(visa);
        cardPanel.add(mastercard);
        cardPanel.add(amex);

        paymentPanel.add(new JLabel("Debit/Credit Card"));
        paymentPanel.add(cardPanel);

        // Grouping radio buttons
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashOnDelivery);
        paymentGroup.add(bkash);
        paymentGroup.add(nagad);
        paymentGroup.add(rocket);
        paymentGroup.add(visa);
        paymentGroup.add(mastercard);
        paymentGroup.add(amex);

        // Checkout Summary Panel
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.Y_AXIS));
        summaryPanel.setBorder(BorderFactory.createTitledBorder("Checkout Summary"));
        summaryPanel.setPreferredSize(new Dimension(300, 0));

        JLabel subtotalLabel = new JLabel("Subtotal: 230 TK.");
        JLabel onlineFeeLabel = new JLabel("Online Fee: 48 TK.");
        JLabel totalLabel = new JLabel("Total: 278 TK.");
        JLabel payableTotalLabel = new JLabel("Payable Total: 278 TK.");
        JLabel promoCodeLabel = new JLabel("Apply Voucher or Promo Code:");

        JTextField promoCodeField = new JTextField(10);
        JButton applyPromoButton = new JButton("Apply");

        JPanel promoPanel = new JPanel();
        promoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        promoPanel.add(promoCodeLabel);
        promoPanel.add(promoCodeField);
        promoPanel.add(applyPromoButton);

        summaryPanel.add(subtotalLabel);
        summaryPanel.add(onlineFeeLabel);
        summaryPanel.add(totalLabel);
        summaryPanel.add(payableTotalLabel);
        summaryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        summaryPanel.add(promoPanel);

        // Confirm Order Button
        JButton confirmButton = new JButton("Confirm Order - 278 TK");
        confirmButton.setBackground(new Color(44, 62, 80));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 14));
        confirmButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Order Confirmed!", "Confirmation", JOptionPane.INFORMATION_MESSAGE));

        // Add panels to the main frame
        frame.add(paymentPanel, BorderLayout.CENTER);
        frame.add(summaryPanel, BorderLayout.EAST);
        frame.add(confirmButton, BorderLayout.SOUTH);

        // Display the frame
        frame.setVisible(true);
    }

    // Method to display the frame
    public void showPaymentFrame() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PaymentFrame();
    }
}
