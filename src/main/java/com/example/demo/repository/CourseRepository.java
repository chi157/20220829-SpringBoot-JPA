package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.many2many.Student;

public interface CourseRepository extends JpaRepository<Student, Long>{

}
