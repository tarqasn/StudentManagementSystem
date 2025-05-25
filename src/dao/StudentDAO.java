package dao;

import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    public void registerStudent(Student student) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO student (name, email, grade, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getGrade());
            stmt.setString(4, student.getPhone());
            stmt.executeUpdate();
            System.out.println("Student registered.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
