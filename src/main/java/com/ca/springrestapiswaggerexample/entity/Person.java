package com.ca.springrestapiswaggerexample.entity;

import com.sun.istack.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@ApiModel(value = "Person Entity Model")
public class Person {
    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Person Id Field")
    private int id;
    @Column(length = 100)
    @ApiModelProperty(value = "Person Name Field")
    private String name;
    @Column(length = 100)
    @ApiModelProperty(value = "Person Email Field")
    private String email;
    @Column(length = 10)
    @ApiModelProperty(value = "Person Phone Field")
    private String phone;
}