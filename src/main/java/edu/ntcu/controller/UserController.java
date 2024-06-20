package edu.ntcu.controller;

import edu.ntcu.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.ntcu.model.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class UserController {
    @Autowired
    UserRepository repo;

    @GetMapping("/api/allUsers")
    public List<User> getAllUsers(){
        return repo.findAll();
    }

    @PostMapping("/api/addUser")
    public User addUser(@RequestBody User user){
        Optional<User> existingUser = repo.findByEmail(user.getEmail());
        return existingUser.orElseGet(() -> repo.save(user));
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        Optional<User> user = repo.findById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/user_email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        Optional<User> user = repo.findByEmail(email);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/api/updateAvatar")
    public ResponseEntity<String> updateAvatar(@RequestBody User request) {
        Optional<User> existingUser = repo.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setAvatar(request.getAvatar());
            repo.save(user);
            return ResponseEntity.ok("Avatar updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
}
