package com.example.courseapidata.course;


import com.example.courseapidata.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/course")
    public List<Course> getAllCourse(){
        //automatically gets converted to json at the time of sending

        return courseService.getAllTopics();
    }

    @RequestMapping("/course/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/course")
    public void addCourse(@RequestBody Course course){
        courseService.addTopic(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/course/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id){
        courseService.updateTopic(id, course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/course/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteTopic(id);
    }

}
