package main;

import model.Student;
import dao.StudentDAO;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice", "alice@gmail.com", "A", "9876543210");
        StudentDAO dao = new StudentDAO();
        dao.registerStudent(s);
    }
}
