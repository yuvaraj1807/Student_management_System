package main;

import daoimpl.StudentDAOImpl;
import model.Student;

public class TestAddStudent {

    public static void main(String[] args) {

        Student s = new Student(
                0,
                "Yuvaraj",
                22,
                "Male",
                "Computer Science",
                "yuva@gmail.com",
                "9876543210",
                "yuva1");

        StudentDAOImpl dao = new StudentDAOImpl();

        if (dao.addStudent(s)) {
            System.out.println("Student Added Successfully");
        } else {
            System.out.println("Failed");
        }
    }
}