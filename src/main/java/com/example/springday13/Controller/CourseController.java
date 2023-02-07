package com.example.springday13.Controller;

import com.example.springday13.Model.Course;
import com.example.springday13.Model.Merchant;
import com.example.springday13.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    final private CourseService courseService;

    @GetMapping("/display")
    public ResponseEntity getAlLCourse(){
        List<Course> courses = courseService.getCourse();
        return ResponseEntity.status(200).body(courses);
    }

    //Add
    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course course, @PathVariable Integer id) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("Course is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course is deleted ");
    }

    // assign
    @GetMapping("/assignBranch/{teacher_id}/{course_id}")
    public ResponseEntity assignCourse(@PathVariable Integer teacher_id, @PathVariable Integer course_id){
        courseService.assignCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body("Course is assigned ");

    }
}
