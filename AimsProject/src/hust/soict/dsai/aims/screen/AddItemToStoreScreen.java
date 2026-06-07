package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract base class cho các màn hình thêm item vào store.
 * Cung cấp menu bar chung và layout form chuẩn.
 */
public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;
    protected StoreScreen storeScreen;

    public AddItemToStoreScreen(String title, Store store, StoreScreen storeScreen) {
        this.store = store;
        this.storeScreen = storeScreen;

        setTitle(title);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(10, 10));

        // --- North: tiêu đề màn hình ---
        JLabel lblHeader = new JLabel(title, SwingConstants.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        lblHeader.setForeground(new Color(0, 150, 200));
        lblHeader.setBorder(BorderFactory.createEmptyBorder(16, 0, 8, 0));
        cp.add(lblHeader, BorderLayout.NORTH);

        // --- Center: form (do subclass cung cấp) ---
        cp.add(createForm(), BorderLayout.CENTER);

        // --- South: nút Submit ---
        JButton btnSubmit = new JButton("Add to Store");
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 14));
        btnSubmit.setBackground(new Color(0, 150, 200));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setBorder(BorderFactory.createEmptyBorder(10, 24, 10, 24));
        btnSubmit.addActionListener(e -> {
            if (onSubmit()) {
                storeScreen.refreshCenter();
                dispose();
            }
        });

        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        south.add(btnSubmit);
        cp.add(south, BorderLayout.SOUTH);

        setVisible(true);
    }

    /** Subclass trả về JPanel chứa các trường nhập liệu */
    protected abstract JPanel createForm();

    /**
     * Subclass xử lý dữ liệu form và thêm vào store.
     * @return true nếu thành công, false nếu có lỗi validate
     */
    protected abstract boolean onSubmit();

    // ---------------------------------------------------------------- helpers
    /** Tạo một hàng label + textfield */
    protected static JTextField addRow(JPanel form, GridBagConstraints gbc, int row, String labelText) {
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        form.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JTextField tf = new JTextField(20);
        form.add(tf, gbc);
        return tf;
    }

    /** Hiển thị lỗi */
    protected void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}
