package edu.ntcu.controller;

import edu.ntcu.model.Space;
import edu.ntcu.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "https://se-group2-final-project.vercel.app/")
public class SpaceController {
    @Autowired
    SpaceRepository repo;

    @GetMapping("/api/allSpaces")
    public List<Space> getAllSpace(){
        return repo.findAll();
    }

    @PostMapping("/api/addSpace")
    public Space addSpace(@RequestBody Space space){
        return repo.save(space);
    }

}
