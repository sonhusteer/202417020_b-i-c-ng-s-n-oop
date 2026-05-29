package hust.soict.dsai.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAccumulator extends JFrame {

    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        // Row 1: Label + Input field
        cp.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10);
        tfInput.addActionListener(new TFInputListener());
        cp.add(tfInput);

        // Row 2: Label + Output field
        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String inputStr = tfInput.getText();
            try {
                int inputValue = Integer.parseInt(inputStr);
                sum += inputValue;
                tfInput.setText("");
                tfOutput.setText(String.valueOf(sum));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        SwingAccumulator.this,
                        "\"" + inputStr + "\" is not a valid integer. Please enter a whole number.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );
                tfInput.selectAll(); // chọn toàn bộ text lỗi để người dùng dễ gõ lại
            }
        }
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }
}
