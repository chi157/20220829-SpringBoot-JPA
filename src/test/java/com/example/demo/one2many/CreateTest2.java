package com.example.demo.one2many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.oneway.Infect;
import com.example.demo.entity.one2many.oneway.Vaccine;
import com.example.demo.entity.one2many.twoway.MenuGroup;
import com.example.demo.entity.one2many.twoway.MenuItem;
import com.example.demo.repository.InfectRepository;
import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.VaccineRepository;

@SpringBootTest
public class CreateTest2 {
	@Autowired
	MenuGroupRepository menuGroupRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Test
	public void test() {
		MenuGroup g = new MenuGroup();
		g.setName("一號餐");
		
		MenuItem m1 = new MenuItem();
		m1.setName("可樂");
		m1.setPrice(20);
		
		MenuItem m2 = new MenuItem();
		m2.setName("漢堡");
		m2.setPrice(35);
		
		// 設置關聯關係
		g.getItems().add(m1);
		g.getItems().add(m2);
		m1.setMenuGroup(g);
		m2.setMenuGroup(g);
		
		// 執行保存動作
		menuGroupRepository.save(g);
		menuItemRepository.save(m1);
		menuItemRepository.save(m2);
	}
}
