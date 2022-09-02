package com.example.demo.many2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class RemoveTest {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		// 直接刪除 "多" 的一方
		// orderRepository.deleteById(2L);
		
		// 直接刪除 "1" 的一方
		// customerRepository.deleteById(1L);
		// 是無法刪除的
		// 除非設置 聯集刪除 刪除 1 的一方 多 的一方也全部都會刪除
	}
}
