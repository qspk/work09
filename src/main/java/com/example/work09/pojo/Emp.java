package com.example.work09.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job;
    private LocalDate entryDate;     //LocalDate类型对应数据表中的date类型
    private Integer deptId;
    private LocalDateTime createTime;//LocalDateTime类型对应数据表中的datetime类型
    private LocalDateTime updateTime;

    public Emp codePassword() {
        Emp emp = new Emp();
        emp.id = this.id;
        emp.username = this.username;
        emp.password = "******";
        emp.name = this.name;
        emp.gender = this.gender;
        emp.image = this.image;
        emp.job = this.job;
        emp.entryDate = this.entryDate;
        emp.deptId = this.deptId;
        emp.createTime = this.createTime;
        emp.updateTime = this.updateTime;

        return emp;
    }
}