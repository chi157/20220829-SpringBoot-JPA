package com.example.demo.one2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2one.Department;
import com.example.demo.entity.one2one.Manager;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ManagerRepository;

@SpringBootTest
public class CreateTest3 {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Test
	void test() {
		Manager manager = new Manager();
		manager.setName("John");
		Department department = new Department();
		department.setName("IT");
		
		// 設置關聯關係
		department.setManager(manager);
		
		// 保存資料
		// 因為此時是由 Department 維護關聯關係
		// 而且 Department 在 @OneToOne 中 又配置的聯級新增
		// 她代表 department 新增的同時也會自動新增 manager
		//managerRepository.save(manager); // -> 因此此行可以不用寫
		departmentRepository.save(department);
		
		System.out.println("Add OK");
	}
	
}