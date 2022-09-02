package com.example.demo.entity.one2many.twoway;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu_item")
public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Integer price;
	
	// 雙向多對一
	@JoinColumn(name = "group_id")
	//@ManyToOne // 沒寫 fetch= 預設是 FetchType.EAGER 這樣的話假如我今天查 一個 item 系統會幫你查對應的 group 所以會查兩張表
	@ManyToOne(fetch = FetchType.LAZY) // 只會查一張表 如果sql 搜尋不只一張表就會壞掉
	private MenuGroup menuGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public MenuGroup getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(MenuGroup menuGroup) {
		this.menuGroup = menuGroup;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", menuGroup=" + menuGroup + "]";
	}
	
	
	
}
