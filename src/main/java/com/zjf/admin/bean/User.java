package com.zjf.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    //以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
