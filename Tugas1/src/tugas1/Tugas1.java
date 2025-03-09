package tugas1;  

import tugas1.pages.HalamanLogin;
import javax.swing.*;

public class Tugas1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HalamanLogin().setVisible(true);
        });
    }
}