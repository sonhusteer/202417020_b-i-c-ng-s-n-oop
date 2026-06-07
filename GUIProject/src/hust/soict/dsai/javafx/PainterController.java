package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Lab 05 – Section 4.2: Controller cho Painter app.
 * Xử lý sự kiện vẽ (MouseDragged) và xóa bảng (Clear).
 */
public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton radioPen;

    @FXML
    private RadioButton radioEraser;

    /** Gọi khi người dùng kéo chuột trên canvas */
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        Circle dot = new Circle(x, y, 4);

        if (radioEraser != null && radioEraser.isSelected()) {
            // Eraser: vẽ màu trắng (canvas color)
            dot.setFill(Color.WHITE);
            dot.setRadius(10);
        } else {
            // Pen: vẽ màu đen
            dot.setFill(Color.BLACK);
        }

        drawingAreaPane.getChildren().add(dot);
    }

    /** Gọi khi người dùng nhấn nút "Clear" */
    @FXML
    void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }
}
