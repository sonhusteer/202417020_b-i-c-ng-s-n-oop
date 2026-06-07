package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;

public class CartScreenController {

    // ---------------------------------------------------------------- @FXML fields
    @FXML private TextField tfFilter;

    @FXML private ToggleGroup filterCategory;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    @FXML private TableView<Media>        tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float>  colMediaCost;

    @FXML private Button btnPlay;
    @FXML private Button btnRemove;

    @FXML private Label lblTotalCost;

    // ---------------------------------------------------------------- Cart data
    private Cart cart;
    private FilteredList<Media> filteredData;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    // ---------------------------------------------------------------- initialize
    @FXML
    private void initialize() {
        // Cài đặt CellValueFactory cho từng cột
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Đổ dữ liệu giỏ hàng vào bảng (ArrayList → ObservableList -> FilteredList)
        filteredData = new FilteredList<>(FXCollections.observableArrayList(cart.getItemsOrdered()), p -> true);
        tblMedia.setItems(filteredData);

        // Ẩn cả hai nút lúc khởi đầu
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Listener cho textField filter
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });

        // ChangeListener: khi người dùng chọn một dòng trong bảng
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        );
    }

    // ---------------------------------------------------------------- helpers
    private void showFilteredMedia(String filter) {
        filteredData.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) return true;
            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(filter.toLowerCase());
            } else {
                try {
                    int id = Integer.parseInt(filter);
                    return media.getId() == id;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        });
    }

    /**
     * Hiển thị/ẩn các nút tùy thuộc vào loại media đang được chọn.
     */
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    // ---------------------------------------------------------------- event handlers
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            // Làm mới bảng sau khi xóa và giữ nguyên filter hiện tại
            filteredData = new FilteredList<>(FXCollections.observableArrayList(cart.getItemsOrdered()), p -> true);
            tblMedia.setItems(filteredData);
            showFilteredMedia(tfFilter.getText());
            // Cập nhật tổng tiền
            updateTotalCost();
            // Ẩn lại các nút
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Illegal Media Length");
                alert.setHeaderText("Playback Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!\nTotal: " + cart.totalCost() + " $");
        alert.showAndWait();
    }

    // ---------------------------------------------------------------- private utils
    private void updateTotalCost() {
        if (lblTotalCost != null) {
            lblTotalCost.setText(cart.totalCost() + " $");
        }
    }
}
