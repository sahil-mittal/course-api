package com.example.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

//this list is immutable so we need to make a arraylist
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring","Spring Framework", "Description"),
//            new Topic("java","Spring Framework", "Description"),
//            new Topic("js","Spring Framework", "Description")
//    ));

    private List<Course> courses = new ArrayList<>();

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getAllCourses(String topicId){
        List<Course> courses =new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);     //iterate the result of find all in an array list
        return courses;
    }

    public Course getCourse(String id){
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {

//        for (int i=0; i< topics.size(); i++) {
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.set(i, topic);
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
//        topics.removeIf(t->t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
