package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {

    private Media media;

    public MediaStore(Media media) {
        this.media = media;

        // BoxLayout theo trục Y
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // JLabel tiêu đề – font Plain cỡ 20, căn giữa
        JLabel lblTitle = new JLabel(media.getTitle());
        lblTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);

        // JLabel giá tiền
        JLabel lblCost = new JLabel(media.getCost() + " $");
        lblCost.setAlignmentX(CENTER_ALIGNMENT);

        add(lblTitle);
        add(lblCost);

        // Container phụ chứa các nút – FlowLayout căn giữa
        JPanel btnContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnContainer.add(btnAddToCart);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnContainer.add(btnPlay);

            // ActionListener cho nút Play – bắt PlayerException
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) media).play();
                        JDialog dialog = new JDialog();
                        dialog.setTitle("Playing");
                        dialog.add(new JLabel("Now playing: " + media.getTitle(), SwingConstants.CENTER));
                        dialog.setSize(300, 100);
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (PlayerException ex) {
                        JOptionPane.showMessageDialog(
                                null,
                                ex.getMessage(),
                                "Illegal Media Length",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            });
        }

        // ActionListener cho nút Add to cart
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        MediaStore.this,
                        "\"" + media.getTitle() + "\" has been added to cart.",
                        "Add to Cart",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        add(btnContainer);

        // Viền đen
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
