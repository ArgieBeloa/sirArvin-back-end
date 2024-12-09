package com.example.demo.StudentPackage;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;
//import java.util.Optional;
@Repository
public interface StudentRepository extends MongoRepository<StudentModel, String> {

    // You can define custom query methods here if needed
    StudentModel findByUsername(String username); // Example custom method to find by username

}
