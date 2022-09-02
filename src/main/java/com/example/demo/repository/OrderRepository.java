package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.many2one.oneway.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
