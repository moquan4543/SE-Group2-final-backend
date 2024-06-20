package edu.ntcu.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.ntcu.model.Course;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{
    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    @Override
    public List<Course> findByText(String text) {
        final List<Course> courses = new ArrayList<>();
        MongoDatabase database = client.getDatabase("NTCUbenliton");
        MongoCollection<Document> collection = database.getCollection("Course");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query",text)
                                .append("path", Arrays.asList("courseName","description")))),
                new Document("$sort",
                        new Document("checkInOpen",1L))));
        result.forEach(doc -> courses.add(converter.read(Course.class,doc)));

        return courses;
    }
}
