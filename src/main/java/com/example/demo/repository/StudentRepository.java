package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.many2many.Course;

public interface StudentRepository extends JpaRepository<Course, Long>{

}
