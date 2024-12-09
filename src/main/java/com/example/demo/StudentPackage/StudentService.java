package com.example.demo.StudentPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Method to save or update a student
    public StudentModel saveStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    // Method to get all students
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    // Method to get a student by ID
    public Optional<StudentModel> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    // Method to delete a student by ID
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }
    // Get student by username
    public StudentModel getStudentByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

    // Method to update a student
    public StudentModel updateStudent(String id, StudentModel studentDetails) {
        Optional<StudentModel> student = studentRepository.findById(id);
        if (student.isPresent()) {
            StudentModel updatedStudent = student.get();
            updatedStudent.setName(studentDetails.getName());
            updatedStudent.setAge(studentDetails.getAge());
            updatedStudent.setUsername(studentDetails.getUsername());
            updatedStudent.setPassword(studentDetails.getPassword());
            updatedStudent.setSchedule(studentDetails.getSchedule());
            updatedStudent.setUpcomingEvents(studentDetails.getUpcomingEvents());
            updatedStudent.setPersonalGoals(studentDetails.getPersonalGoals());
            return studentRepository.save(updatedStudent);
        }
        return null;
    }
}
