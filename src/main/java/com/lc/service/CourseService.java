package com.lc.service;

import com.lc.pojo.Course;

import java.util.List;

public interface CourseService {

    List<Course> querryAll();

    int deletById(Long id);

    int create(Course course);

    int updateCourse(Course course);

    List<Course> findByName(String name);

}
