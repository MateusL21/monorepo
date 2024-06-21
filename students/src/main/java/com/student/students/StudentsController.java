package com.student.students;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

    @GetMapping("student")
    public String getStudent(){
        return "HEllo Student";
    }
    
}
