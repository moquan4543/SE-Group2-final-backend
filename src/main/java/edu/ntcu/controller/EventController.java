package edu.ntcu.controller;

import edu.ntcu.model.Event;
import edu.ntcu.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventRepository repo;

    @GetMapping("/api/allEvents")
    public List<Event> getAllEvent(){
        return repo.findAll();
    }

    @PostMapping("/api/addEvent")
    public Event addEvent(@RequestBody Event event){
        return repo.save(event);
    }

}
