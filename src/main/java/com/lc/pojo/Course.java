package com.lc.pojo;

//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "course")
@Data
public class Course {

    @Id
    private Long id;

    private String cName;

//    @TableField(fill = FieldFill.INSERT)
//    private Date createTime;

//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private  Date updateTime;

//    @TableLogic    //逻辑删除字段
//    private Integer deleted;
}

