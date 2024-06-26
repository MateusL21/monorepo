package com.student.students;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.student.students.models.Student;

import jakarta.annotation.PostConstruct;

@RestController
public class StudentsController {

    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init() {
        Student s1 = new Student();

        s1.setEmail("mateus@abutua.com");
        s1.setId(1);
        s1.setIdCurso(1);
        s1.setName("Java");
        s1.setPeriod(1);
        s1.setPhone("11 9999999");

        Student s2 = new Student();

        s2.setEmail("igir@abutua.com");
        s2.setId(2);
        s2.setIdCurso(2);
        s2.setName("Python");
        s2.setPeriod(2);
        s2.setPhone("11 9333999");

        Student s3 = new Student();

        s3.setEmail("vlad@abutua.com");
        s3.setId(3);
        s3.setIdCurso(3);
        s3.setName("ruby");
        s3.setPeriod(3);
        s3.setPhone("11 933322999");

        students.add(s1);
        students.add(s2);
        students.add(s3);

    }

    /**
     * @param id
     * @return
     */
    @GetMapping("students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {

        /*
         * if (id <= students.size()) {
         * 
         * return ResponseEntity.ok(students.get(id - 1));
         * 
         * }else{
         * 
         * throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
         * 
         * }
         * 
         * }
         */

        Student stud = students.stream().filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sudent not found"));

        return ResponseEntity.ok(stud);

    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;

    }

}
