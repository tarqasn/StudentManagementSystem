package ui;

import model.Student;
import dao.StudentDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form Fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();

        JButton registerBtn = new JButton("Register");
        JLabel messageLabel = new JLabel("");

        // Add components to panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(gradeLabel);
        panel.add(gradeField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(registerBtn);
        panel.add(messageLabel);

        frame.add(panel);
        frame.setVisible(true);

        // Button Action
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String grade = gradeField.getText().trim();
                String phone = phoneField.getText().trim();

                if (name.isEmpty() || email.isEmpty()) {
                    messageLabel.setText("Name & Email required!");
                    messageLabel.setForeground(Color.RED);
                    return;
                }

                Student student = new Student(name, email, grade, phone);
                StudentDAO dao = new StudentDAO();
                dao.registerStudent(student);
                messageLabel.setText("Registered!");
                messageLabel.setForeground(new Color(0, 128, 0)); // green

                // Optional: Clear fields
                nameField.setText("");
                emailField.setText("");
                gradeField.setText("");
                phoneField.setText("");
            }
        });
    }
}
