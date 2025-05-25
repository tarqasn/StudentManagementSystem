package ui;

import dao.DBConnection;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class ViewStudentsUI extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public ViewStudentsUI() {
        setTitle("View Registered Students");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Column names for the table
        String[] columns = {"ID", "Name", "Email", "Grade", "Phone"};

        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadStudents();

        setVisible(true);
    }

    private void loadStudents() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT student_id, name, email, grade, phone FROM student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            tableModel.setRowCount(0); // Clear existing rows

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String grade = rs.getString("grade");
                String phone = rs.getString("phone");

                Object[] row = {id, name, email, grade, phone};
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading students: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run UI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new ViewStudentsUI());
    }
}
