package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {

    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        setBackground(new Color(245, 245, 245));

        // Title label
        JLabel lblTitle = new JLabel(media.getTitle(), SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);

        // Cost label
        JLabel lblCost = new JLabel(String.format("%.2f $", media.getCost()), SwingConstants.CENTER);
        lblCost.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCost.setForeground(new Color(0, 128, 0));
        lblCost.setAlignmentX(CENTER_ALIGNMENT);

        // Category label
        JLabel lblCategory = new JLabel(media.getCategory(), SwingConstants.CENTER);
        lblCategory.setFont(new Font("Arial", Font.ITALIC, 12));
        lblCategory.setForeground(Color.GRAY);
        lblCategory.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(10));
        add(lblTitle);
        add(Box.createVerticalStrut(4));
        add(lblCategory);
        add(Box.createVerticalStrut(4));
        add(lblCost);
        add(Box.createVerticalStrut(8));

        // Button panel
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 0));
        btnPanel.setOpaque(false);

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.setFont(new Font("Arial", Font.PLAIN, 12));
        btnAddToCart.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(
                    MediaStore.this,
                    "\"" + media.getTitle() + "\" has been added to cart.",
                    "Add to Cart",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        btnPanel.add(btnAddToCart);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.setFont(new Font("Arial", Font.PLAIN, 12));
            btnPlay.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    JOptionPane.showMessageDialog(
                            MediaStore.this,
                            "Now playing: " + media.getTitle(),
                            "Playing",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(
                            MediaStore.this,
                            ex.getMessage(),
                            "Illegal Media Length",
                            JOptionPane.ERROR_MESSAGE);
                }
            });
            btnPanel.add(btnPlay);
        }

        add(btnPanel);
        add(Box.createVerticalStrut(10));
    }
}
