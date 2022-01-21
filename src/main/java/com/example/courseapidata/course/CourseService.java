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

    private List<Course> topics = new ArrayList<>();

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getAllTopics(){
        List<Course> topics =new ArrayList<>();
        courseRepository.findAll().forEach(topics::add);     //iterate the result of find all in an array list
        return topics;
    }

    public Course getTopic(String id){
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addTopic(Course course) {
        courseRepository.save(course);
    }

    public void updateTopic(String id, Course course) {

//        for (int i=0; i< topics.size(); i++) {
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.set(i, topic);
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t->t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
