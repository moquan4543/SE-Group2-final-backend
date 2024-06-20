package edu.ntcu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document(collection = "Course")
public class Course {
    private String teacher;
    private String courseName;
    private String description;
    private Integer maxStudents;
    private ArrayList<User> participants;
    private boolean checkInOpen;
}
