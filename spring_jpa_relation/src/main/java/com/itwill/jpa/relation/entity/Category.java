package com.itwill.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
@Builder
@RequiredArgsConstructor
@ToString
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@Column(unique = true,nullable = false)
	private String code;
	
	@NonNull
	private String name;
	
	/************case1[@ManyToOne]*****			//맛있는방식
	@ToString.Exclude
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER) //fk를 안만들겠다 내가 부모엔티티다 선언
	private List<Product> products= new ArrayList<Product>();
	****************************/
	/************case2[@OneToMany]***********/ //맛이없는방식
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private List<Product> products= new ArrayList<Product>();
	
}
