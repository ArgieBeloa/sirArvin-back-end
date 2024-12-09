package com.example.demo.StudentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {


        private final StudentService studentService;

        @Autowired
        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        // Endpoint to get all students
        @GetMapping
        public ResponseEntity<List<StudentModel>> getAllStudents() {
            List<StudentModel> students = studentService.getAllStudents();
            return new ResponseEntity<>(students, HttpStatus.OK);
        }

        // Endpoint to get a student by ID
        @GetMapping("/{id}")
        public ResponseEntity<StudentModel> getStudentById(@PathVariable String id) {
            Optional<StudentModel> student = studentService.getStudentById(id);
            return student.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Endpoint to get a student by username
        @GetMapping("/username/{username}")
        public ResponseEntity<StudentModel> getStudentByUsername(@PathVariable String username) {
            StudentModel student = studentService.getStudentByUsername(username);
            return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
        }

        // Endpoint to create or update a student
        @PostMapping("/add")
        public ResponseEntity<StudentModel> createOrUpdateStudent(@RequestBody StudentModel studentModel) {
            StudentModel savedStudent = studentService.saveStudent(studentModel);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        }

        // Endpoint to delete a student by ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
            studentService.deleteStudentById(id);
            return ResponseEntity.noContent().build();
        }


}
