package edu.ntcu.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Document(collection = "Book")
public class Book {
    @MongoId
    private String id;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private String img;
    private ArrayList<String> queue;
}
