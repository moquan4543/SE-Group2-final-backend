package edu.ntcu.controller;

import edu.ntcu.model.Course;
import edu.ntcu.repository.CourseRepository;
import edu.ntcu.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class CourseController {
    @Autowired
    CourseRepository repo;

    @Autowired
    SearchRepository srepo;
    @GetMapping("/api/allCourses")
    public List<Course> getAllCourse(){
        return repo.findAll();
    }

    @PostMapping("/api/addCourse")
    public Course addCourse(@RequestBody Course course){
        return repo.save(course);
    }

    @GetMapping("/api/courses/{text}")
    public List<Course> search(@PathVariable String text){
        return srepo.findByText(text);
    }
}
