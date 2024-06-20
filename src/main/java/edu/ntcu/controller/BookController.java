package edu.ntcu.controller;

import edu.ntcu.model.Book;
import edu.ntcu.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
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
