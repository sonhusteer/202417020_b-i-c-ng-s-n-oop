package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

/**
 * Lab 05 – Section 1.1: AWTAccumulator
 * Ứng dụng tích lũy giá trị sử dụng AWT (không dùng Swing).
 */
public class AWTAccumulator extends Frame {

    private TextField tfInput;
    private TextField tfOutput;
    private float sum = 0f;

    public AWTAccumulator() {
        setLayout(new GridLayout(4, 1, 4, 4));

        add(new Label("Enter a number:"));

        tfInput = new TextField();
        tfInput.addActionListener(new InputListener());
        add(tfInput);

        add(new Label("Accumulated Sum:"));

        tfOutput = new TextField();
        tfOutput.setEditable(false);
        tfOutput.setText("0.0");
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(300, 200);
        setVisible(true);

        // Đóng cửa sổ
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Named inner class listener
    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                float value = Float.parseFloat(tfInput.getText().trim());
                sum += value;
                tfOutput.setText(String.valueOf(sum));
                tfInput.setText("");
            } catch (NumberFormatException ex) {
                tfOutput.setText("Invalid input!");
                tfInput.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}
