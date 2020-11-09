package com.lc.controller;

import com.lc.pojo.Course;
import com.lc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coures")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/findall")    //找到全部
    public String querryAll(Model model) {
        List<Course> courses = courseService.querryAll();
        model.addAttribute("courses", courses);
        return "courselist";  //跳到html
    }

    @GetMapping("/create")
    public String createByEntity(Course course) {
        int i = courseService.create(course);
        return "forward:/coures/findall";
    }

    @RequestMapping("/dodelte/{id}")   //根据id 删除1个
    public String deleteById(@PathVariable Long id) {
        int i = courseService.deletById(id);
        return "forward:/coures/findall";  //跳转到链接
    }

    @PostMapping("/update")   //更新
    public String updateById(Course course) {   //前段构造的表单中获得值
        courseService.updateCourse(course);
        return "forward:/coures/findall";
    }

    @RequestMapping("/findByName/{cName}")  //根据名字查找
    public String findByName(@PathVariable(required = false) String cName, Model model) {

        List<Course> byName = courseService.findByName(cName);
        model.addAttribute("courses", byName);
        return "courselist";
    }

    //做页面跳转
    @RequestMapping("/toCreatelist")
    public String fromListToCreate() {

        return "createlist";
    }

    @RequestMapping("/toUpdateList")
    public String fromListToUpdatelist(Long id, Model model) {
        model.addAttribute("courseId", id);
        return "updatelist";
    }

}
