package com.lc.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lc.mapper.CourseMapper;
import com.lc.pojo.Course;
import com.lc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServerImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> querryAll() {
        List<Course> courses = courseMapper.selectList(null);
        return courses;
    }


    @Override
    public int deletById(Long id) {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        int result = courseMapper.delete(wrapper);
        return result;
    }

    @Override
    public int create(Course course) {
        int result = courseMapper.insert(course);
        return result;
    }

    @Override
    public int updateCourse(Course course) {
        int result = courseMapper.updateById(course);
        return result;
    }

    @Override
    public List<Course> findByName(String name) {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper
//                .isNotNull("c_name")
//                .likeRight("c_name", name)
//                .likeLeft("c_name" , name)
                .like("c_name" , name);
//                .between("id" , 1,6);
        List<Course> courses = courseMapper.selectList(wrapper);
        return courses;
    }

}
