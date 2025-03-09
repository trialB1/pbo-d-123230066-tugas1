package tugas1.pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanLogin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public HalamanLogin() {
        setTitle("Halaman Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 
        
        JLabel labelUsername = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel labelPassword = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        labelUsername.setBounds(20, 20, 80, 20);
        usernameField.setBounds(100, 20, 150, 20);
        labelPassword.setBounds(20, 50, 80, 20);
        passwordField.setBounds(100, 50, 150, 20);
        loginButton.setBounds(100, 90, 100, 30);

        add(labelUsername);
        add(usernameField);
        add(labelPassword);
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equalsIgnoreCase("pbo") && password.equalsIgnoreCase("if-d")) {
                    JOptionPane.showMessageDialog(HalamanLogin.this, "Login Berhasil!");
                    new HalamanUtama().setVisible(true);
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(HalamanLogin.this, "Gagal Login", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}