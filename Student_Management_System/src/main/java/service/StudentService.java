package service;
import model.Student;
import java.util.List;
public interface StudentService{
	boolean addStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(int id);
	boolean updateStudent(Student student);
	boolean deleteStudent(int id);
	Student loginStudent(int id, String password);
}