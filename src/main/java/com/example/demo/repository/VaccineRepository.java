package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.one2many.Infect;
import com.example.demo.entity.one2many.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long>{

}
