package com.example.springday13.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name field is required")
    private String name ;

    @NotNull(message = "age field is required")
    @Min(0)
    private int age;
    @NotEmpty(message = "email field is required")
    @Email(message = "please enter a valid email")
    private String email ;

    @NotNull(message = "Salary field is required")
    @Min(5000)
    private int salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    List<Course> courses;



}
