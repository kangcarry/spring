package com.itwill.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true )
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "provider")
public class Provider extends BaseEntity{
	@Id //pk설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//시퀀스설정
	private Long id;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	
	/*
	    Fetch Type 이란 Fetch Type 은 JPA 가 하나의 Entity 를 조회할 때, 연관관계에 있는 객체들을 어떻게 가져올 것이냐를 나타내는 설정값입니다.

		Fetch Type 은 크게 Eager 와 Lazy 두가지 전략이 있습니다. Fetch Type Issue 상황이라는 것은 하나의 Entity 를 로드할 때, 아래의 두가지 전략 중 고민하는 상황을 말합니다.

		연관 관계에 있는 Entity 들 모두 가져온다 → Eager 전략
		연관 관계에 있는 Entity 가져오지 않고, getter로 접근할 때 가져온다 → Lazy 전략
	 */
	@OneToMany(mappedBy = "provider",fetch = FetchType.EAGER)
	List<Product> productList = new ArrayList<Product>();
}
