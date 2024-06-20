package edu.ntcu.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Event")
public class Event {
    private String title;
    private String description;
    private Date timestamp;

}
