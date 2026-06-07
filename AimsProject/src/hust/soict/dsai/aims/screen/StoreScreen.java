package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {

    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AIMS – Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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

        JMenu menuOptions = new JMenu("Options");

        // --- Update Store sub-menu ---
        JMenu menuUpdateStore = new JMenu("Update Store");

        JMenuItem miAddBook = new JMenuItem("Add Book");
        miAddBook.addActionListener(e ->
            new AddBookToStoreScreen(store, this));

        JMenuItem miAddCD = new JMenuItem("Add CD");
        miAddCD.addActionListener(e ->
            new AddCDToStoreScreen(store, this));

        JMenuItem miAddDVD = new JMenuItem("Add DVD");
        miAddDVD.addActionListener(e ->
            new AddDVDToStoreScreen(store, this));

        menuUpdateStore.add(miAddBook);
        menuUpdateStore.add(miAddCD);
        menuUpdateStore.add(miAddDVD);
        menuOptions.add(menuUpdateStore);
        menuOptions.addSeparator();

        // --- View store (refresh) ---
        JMenuItem miViewStore = new JMenuItem("View store");
        miViewStore.addActionListener(e -> refreshCenter());
        menuOptions.add(miViewStore);

        // --- View cart ---
        JMenuItem miViewCart = new JMenuItem("View cart");
        miViewCart.addActionListener(e ->
            SwingUtilities.invokeLater(() -> new CartScreen(cart)));
        menuOptions.add(miViewCart);

        menuBar.add(menuOptions);
        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("AIMS");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 50));
        lblTitle.setForeground(Color.CYAN);
        lblTitle.setAlignmentY(CENTER_ALIGNMENT);

        header.add(lblTitle);
        header.add(Box.createHorizontalGlue());

        JButton btnViewCart = new JButton("View cart");
        btnViewCart.setAlignmentY(CENTER_ALIGNMENT);
        btnViewCart.addActionListener(e ->
            SwingUtilities.invokeLater(() -> new CartScreen(cart)));
        header.add(btnViewCart);

        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return header;
    }

    // ----------------------------------------------------------------- CENTER
    private JPanel centerPanel;

    private JPanel createCenter() {
        centerPanel = new JPanel(new GridLayout(0, 3, 2, 2));
        populateCenter();
        JScrollPane scroll = new JScrollPane(centerPanel);
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(scroll, BorderLayout.CENTER);
        return wrapper;
    }

    private void populateCenter() {
        centerPanel.removeAll();
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media m : mediaInStore) {
            centerPanel.add(new MediaStore(m, cart));
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /** Gọi từ các màn hình Add sau khi thêm item mới */
    public void refreshCenter() {
        populateCenter();
    }

    // ------------------------------------------------------------------ MAIN
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }
}
