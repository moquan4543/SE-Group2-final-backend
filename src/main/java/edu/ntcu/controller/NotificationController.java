package edu.ntcu.controller;

import edu.ntcu.model.Notification;
import edu.ntcu.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    NotificationRepository repo;

    @GetMapping("/api/allNotifications")
    public List<Notification> getAllNotification(){
        return repo.findAll();
    }
    @PostMapping("/api/addNotification")
    public Notification addNotification(@RequestBody Notification notification){
        return repo.save(notification);
    }

}
