package tugas1.pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HalamanUtama extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton saveButton;
    private JButton convertButton;
    private JTextArea textArea;
    private ArrayList<String> dataList;

    public HalamanUtama() {
        setTitle("Halaman Utama");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel labelFirstName = new JLabel("Nama Depan:");
        firstNameField = new JTextField();
        JLabel labelLastName = new JLabel("Nama Belakang:");
        lastNameField = new JTextField();
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        maleRadioButton = new JRadioButton("Pria");
        femaleRadioButton = new JRadioButton("Wanita");
        ButtonGroup genderGroup = new ButtonGroup();
        saveButton = new JButton("Simpan");
        convertButton = new JButton("Convert to .txt File");
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        labelFirstName.setBounds(20, 20, 100, 20);
        firstNameField.setBounds(20, 40, 150, 20);
        labelLastName.setBounds(200, 20, 100, 20);
        lastNameField.setBounds(200, 40, 150, 20);
        labelGender.setBounds(150, 70, 100, 20);
        maleRadioButton.setBounds(130, 90, 60, 20);
        femaleRadioButton.setBounds(200, 90, 80, 20);
        saveButton.setBounds(125, 130, 150, 30);
        scrollPane.setBounds(20, 170, 350, 150);
        convertButton.setBounds(125, 330, 150, 30);

        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        add(labelFirstName);
        add(firstNameField);
        add(labelLastName);
        add(lastNameField);
        add(labelGender);
        add(maleRadioButton);
        add(femaleRadioButton);
        add(saveButton);
        add(scrollPane);
        add(convertButton);

        dataList = new ArrayList<>();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String gender = "";

                if (maleRadioButton.isSelected()) {
                    gender = "Pria";
                } else if (femaleRadioButton.isSelected()) {
                    gender = "Wanita";
                }

                if (firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(HalamanUtama.this, "Data belum lengkap!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String data = firstName + " " + lastName + " | Gender : " + gender;
                    dataList.add(data);
                    textArea.append(data + "\n");
                    
                    firstNameField.setText("");
                    lastNameField.setText("");
                    genderGroup.clearSelection(); 
                }
            }
        });

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dataList.isEmpty()) {
                    JOptionPane.showMessageDialog(HalamanUtama.this, "Belum ada data yang dimasukkan!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try (FileWriter writer = new FileWriter("data_123230066.txt")) {
                        for (int i = 0; i < dataList.size(); i++) {
                            writer.write((i + 1) + " " + dataList.get(i) + "\n");
                        }
                        JOptionPane.showMessageDialog(HalamanUtama.this, "Data berhasil disimpan ke data_123230066.txt");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(HalamanUtama.this, "Gagal menyimpan data!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}