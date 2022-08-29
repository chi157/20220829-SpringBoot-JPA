package com.example.demo.one2many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.Infect;
import com.example.demo.entity.one2many.Vaccine;
import com.example.demo.repository.InfectRepository;
import com.example.demo.repository.VaccineRepository;

@SpringBootTest
public class CreateTest {
	@Autowired
	InfectRepository infectRepository;
	
	@Autowired
	VaccineRepository vaccineRepository;
	
	@Test
	void test() {
		Infect infect = new Infect();
		infect.setName("covid-19");
		Vaccine v1 = new Vaccine();
		v1.setName("AZ");
		v1.setCount(3);
		Vaccine v2 = new Vaccine();
		v2.setName("BNT");
		v2.setCount(2);
		Vaccine v3 = new Vaccine();
		v3.setName("PJ");
		v3.setCount(1);
		
		// 設置關聯關係 一的那方要去維護多的那方
		infect.getVaccines().add(v1);
		infect.getVaccines().add(v2);
		infect.getVaccines().add(v3);
		
		// 執行非聯集保存操作
		vaccineRepository.save(v1);
		vaccineRepository.save(v2);
		vaccineRepository.save(v3);
		
		infectRepository.save(infect);
		
		// 也可以 執行聯集保存操作(casecade) 那就可以只要新增 傳染病就好
		// infectRepository.save(infect);
	}
}
