package com.example.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//this list is immutable so we need to make a arraylist
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring","Spring Framework", "Description"),
//            new Topic("java","Spring Framework", "Description"),
//            new Topic("js","Spring Framework", "Description")
//    ));

    private List<Topic> topics = new ArrayList<>();

//    public TopicService(TopicRepository topicRepository) {
//        this.topicRepository = topicRepository;
//    }



    public List<Topic> getAllTopics(){
        List<Topic> topics =new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);     //iterate the result of find all in an array list
        return topics;
    }

    public Topic getTopic(String id){
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {

//        for (int i=0; i< topics.size(); i++) {
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.set(i, topic);
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t->t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
