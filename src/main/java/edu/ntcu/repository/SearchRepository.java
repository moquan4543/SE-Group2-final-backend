package edu.ntcu.repository;

import edu.ntcu.model.Course;

import java.util.List;

public interface SearchRepository {
    List<Course> findByText(String text);
}
