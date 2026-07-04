package serviceimpl;
import java.util.List;
import daoimpl.StudentDAOImpl;
import model.Student;
import service.StudentService;
public class StudentServiceImpl implements StudentService {

    StudentDAOImpl dao = new StudentDAOImpl();

    public boolean addStudent(Student student) {
        return dao.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return dao.getAllStudents();
    }

    public Student getStudentById(int id) {
        return dao.getStudentById(id);
    }

    public boolean updateStudent(Student student) {
        return dao.updateStudent(student);
    }

    public boolean deleteStudent(int id) {
        return dao.deleteStudent(id);
    }
    @Override
    public Student loginStudent(int id, String password) {
        return dao.loginStudent(id, password);
    }
}