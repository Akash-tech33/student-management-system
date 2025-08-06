package StudentInfo.Controller;

import StudentInfo.Model.Student;
import StudentInfo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
   StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent()
    {
       List<Student> students = studentService.getAllStudent();
         return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("students/{id}")
    public ResponseEntity<Student> getById(@PathVariable long id)
    {
        Student student=studentService.getById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @PostMapping("students/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return new ResponseEntity<>("added succesfully",HttpStatus.OK);

    }

    @PutMapping("students/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody Student  updatedStudent)
    {
        studentService.updateStudent(id,updatedStudent);
        return new ResponseEntity<>("Updated Succesfully",HttpStatus.OK);
    }
    @DeleteMapping("students/delete/{id}")
    public  ResponseEntity<String> deleteStudent(@PathVariable long id)
    {
        studentService.deletebyId(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

}
