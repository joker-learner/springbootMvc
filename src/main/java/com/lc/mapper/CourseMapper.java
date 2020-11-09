package com.lc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lc.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@org.apache.ibatis.annotations.Mapper
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}
