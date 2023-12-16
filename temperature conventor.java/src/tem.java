import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class tem {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBox_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    tem window = new tem();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public tem() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 535, 482);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 0, 501, 87);
        frame.getContentPane().add(panel);

        JLabel lblNewLabel = new JLabel("Temperature Converter");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        panel.add(lblNewLabel);

        comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
        comboBox.setBounds(73, 163, 80, 21);
        frame.getContentPane().add(comboBox);

        comboBox_1 = new JComboBox<>();
        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
        comboBox_1.setBounds(73, 301, 80, 21);
        frame.getContentPane().add(comboBox_1);

        textField = new JTextField();
        textField.setBounds(288, 164, 171, 35);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(288, 302, 171, 35);
        frame.getContentPane().add(textField_1);

        JButton btnNewButton = new JButton("Convert");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton.setBounds(232, 235, 85, 35);
        frame.getContentPane().add(btnNewButton);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField_1.setText("");
            }
        });
        btnClear.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnClear.setBounds(377, 235, 85, 35);
        frame.getContentPane().add(btnClear);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnExit.setBounds(374, 400, 85, 35);
        frame.getContentPane().add(btnExit);
    }

    private void convertTemperature() {
        try {
            String box1 = (String) comboBox.getSelectedItem();
            String box2 = (String) comboBox_1.getSelectedItem();

            double inputValue = Double.parseDouble(textField.getText());
            double result = 0.0;

            if (box1.equals("Celsius")) {
                if (box2.equals("Fahrenheit")) {
                    result = inputValue * 1.8 + 32;
                } else if (box2.equals("Kelvin")) {
                    result = inputValue + 273.15;
                } else {
                    result = inputValue;
                }
            } else if (box1.equals("Fahrenheit")) {
                if (box2.equals("Celsius")) {
                    result = (inputValue - 32) * 5 / 9;
                } else if (box2.equals("Kelvin")) {
                    result = (inputValue - 32) * 5 / 9 + 273.15;
                } else {
                    result = inputValue;
                }
            } else if (box1.equals("Kelvin")) {
                if (box2.equals("Celsius")) {
                    result = inputValue - 273.15;
                } else if (box2.equals("Fahrenheit")) {
                    result = (inputValue - 273.15) * 9 / 5 + 32;
                } else {
                    result = inputValue;
                }
            }

            textField_1.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            textField_1.setText("Invalid input");
        }
    }
}
