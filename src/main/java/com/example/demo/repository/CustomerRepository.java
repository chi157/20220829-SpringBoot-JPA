package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.many2one.oneway.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
