package edu.ntcu.controller;

import edu.ntcu.model.Book;
import edu.ntcu.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "https://se-group2-final-project.vercel.app/")
@RequestMapping("/api/v1/")
public class BookController {
    @Autowired
    BookRepository repo;

    @GetMapping("/allBooks")
    public List<Book> getAllBook(){
        return repo.findAll();
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return repo.save(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable ObjectId id){
        repo.deleteById(id);
    }

}
