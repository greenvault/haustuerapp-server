package de.gruene.haustuer.topic;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.gruene.haustuer.door.DoorController;

@RestController()
@RequestMapping("/topic")
public class TopicController {
    
    private static Logger logger = LoggerFactory.getLogger(DoorController.class);

    @Autowired
    private TopicService topicService;
    
    @GetMapping
    public List<Topic> getAllTopics(){
        return topicService.getAll();
    }
    
    @PostMapping
    public Topic createTopic(@Valid @RequestBody Topic topic){
        return topicService.save(topic);
    }
    

}