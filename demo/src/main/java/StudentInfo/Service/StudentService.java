package StudentInfo.Service;

import StudentInfo.Model.Student;
import StudentInfo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public  String deletebyId(long id) {
        studentRepo.deleteById(id);
        return "deleted";
    }

    public  List<Student> getAllStudent() {
    return studentRepo.findAll();
    }

    public Student getById(long id) {
       Optional<Student> byId =studentRepo.findById(id);
       return byId.orElse(null);
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public Student updateStudent(Long id,Student updatedStudent) {
        Student existingStudent=studentRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Id Not Found"+id));
          existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());
        existingStudent.setAge(updatedStudent.getAge());
        return studentRepo.save(existingStudent);
    }
}
