package model;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String grade;
    private String phone;

    public Student(String name, String email, String grade, String phone) {
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.phone = phone;
    }

    public Student() {}

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
