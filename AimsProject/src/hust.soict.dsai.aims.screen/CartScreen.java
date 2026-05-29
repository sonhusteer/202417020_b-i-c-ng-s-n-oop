package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.JFrame;
import java.io.IOException;
import java.net.URL;

public class CartScreen extends JFrame {

    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;

        // 1. Tạo JFXPanel và nhúng vào JFrame
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        // 2. Cài đặt thuộc tính JFrame
        setTitle("Cart");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // 3. Nạp JavaFX content trên JavaFX Application Thread
        Platform.runLater(() -> {
            try {
                URL fxmlUrl = CartScreen.class.getResource("cart.fxml");
                if (fxmlUrl == null) {
                    System.err.println("Cannot find cart.fxml. "
                            + "Ensure cart.fxml is in the same package/directory as CartScreen.class.");
                    return;
                }

                FXMLLoader loader = new FXMLLoader(fxmlUrl);

                // Thiết lập controller bên ngoài (constructor injection)
                loader.setController(new CartScreenController(cart));

                // Nạp cây giao diện
                Parent root = loader.load();

                // Tạo Scene và gắn vào JFXPanel
                Scene scene = new Scene(root);
                fxPanel.setScene(scene);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
