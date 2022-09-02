package com.example.demo.one2many;

import javax.persistence.FetchType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.twoway.MenuGroup;
import com.example.demo.entity.one2many.twoway.MenuItem;
import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;

@SpringBootTest
public class QueryTest2 {
	
	@Autowired
	MenuGroupRepository menuGroupRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Test
	public void test() {
		MenuGroup g = menuGroupRepository.findById(1L).get();
		System.out.println(g.getName());
		
		// 預設 fetch = FetchType.LAZY 只會查當下那張表(預設不加載)
		// 注意：fetch = FetchType.LAZY 若執行時期需要加載另一張表，必須在 application.yml 裡面加入 enable_lazy_load_no_trans: true
		// one to many 預設是 lazy 所以下面這邊要再查一個就會再下一次的 sql 如果不想要下兩次的話就去 MenuGroup 加上 fetch = FetchType.EARGE
		System.out.println(g.getItems().size() + "個");
	}
}
