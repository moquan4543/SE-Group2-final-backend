package edu.ntcu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.util.Date;
@Getter
@AllArgsConstructor
public class SpaceRequire {
    private Date timeslot;
    private ObjectId user;
}
