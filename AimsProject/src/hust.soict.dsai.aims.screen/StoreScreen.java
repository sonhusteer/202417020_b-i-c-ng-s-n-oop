package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {

    private Store store;

    public StoreScreen(Store store) {
        this.store = store;

        // Setup Content Pane với BorderLayout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ------------------------------------------------------------------ NORTH
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Menu "Options"
        JMenu menuOptions = new JMenu("Options");

        // Sub-menu "Update Store"
        JMenu menuUpdateStore = new JMenu("Update Store");
        menuUpdateStore.add(new JMenuItem("Add Book"));
        menuUpdateStore.add(new JMenuItem("Add CD"));
        menuUpdateStore.add(new JMenuItem("Add DVD"));
        menuOptions.add(menuUpdateStore);

        // Separator
        menuOptions.addSeparator();

        // Menu items "View store" và "View cart"
        menuOptions.add(new JMenuItem("View store"));
        menuOptions.add(new JMenuItem("View cart"));

        menuBar.add(menuOptions);
        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBackground(Color.WHITE);

        // Tiêu đề "AIMS" – màu CYAN, font cỡ 50
        JLabel lblTitle = new JLabel("AIMS");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 50));
        lblTitle.setForeground(Color.CYAN);
        lblTitle.setAlignmentY(CENTER_ALIGNMENT);

        // Glue để đẩy nút sang phải
        header.add(lblTitle);
        header.add(Box.createHorizontalGlue());

        // Nút "View cart" góc phải
        JButton btnViewCart = new JButton("View cart");
        btnViewCart.setAlignmentY(CENTER_ALIGNMENT);
        header.add(btnViewCart);

        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return header;
    }

    // ----------------------------------------------------------------- CENTER
    private JPanel createCenter() {
        // GridLayout(3, 3) với gap 2px
        JPanel center = new JPanel(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int limit = Math.min(9, mediaInStore.size());

        for (int i = 0; i < limit; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    // ------------------------------------------------------------------ MAIN
    public static void main(String[] args) {
        // Tạo store mẫu để chạy thử
        Store store = new Store();

        // Thêm một vài media mẫu nếu muốn chạy độc lập
        // store.addMedia(new Book("Clean Code", "Tech", 29.99f));

        SwingUtilities.invokeLater(() -> new StoreScreen(store));
    }
}
