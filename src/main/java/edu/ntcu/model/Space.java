package edu.ntcu.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Space")
public class Space {
    @MongoId
    private String id;
    private ObjectId owner;
    private String name;
    private String description;
    private ArrayList<SpaceRequire> schedule;
}
