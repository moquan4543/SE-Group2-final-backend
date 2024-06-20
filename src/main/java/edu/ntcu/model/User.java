package edu.ntcu.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@Getter
@Setter
@Document(collection="User")
public class User {
    @MongoId
    private String id;
    private String username;
    private String description;
    private String email;
    private String phone;
    private String avatar;
    private boolean isAdmin;
    private boolean isPrivate;
    private ArrayList<Notification> notifications;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", isAdmin=" + isAdmin +
                ", notifications=" + notifications +
                '}';
    }
}
