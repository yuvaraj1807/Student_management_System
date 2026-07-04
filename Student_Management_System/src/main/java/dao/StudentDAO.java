package dao;

import java.util.List;
import model.Student;

public interface StudentDAO{
	boolean addStudent(Student student);
	List<Student>getAllStudents();
	Student getStudentById(int id);
	boolean updateStudent(Student student);
	boolean deleteStudent(int id);
	Student loginStudent(int id, String password);
}