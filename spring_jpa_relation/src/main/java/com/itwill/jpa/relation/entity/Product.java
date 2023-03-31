package com.itwill.jpa.relation.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@RequiredArgsConstructor //필요한 생성자만(not null붙인 컬럼만 생성자에 등록)
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
public class Product extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	@Column(nullable = false)
	private String name;
	
	@NotNull
	@Column(nullable = false)
	private Integer price;
	
	@NotNull
	@Column(nullable = false)
	private Integer stock;
	
	@OneToOne(mappedBy = "product")
	@ToString.Exclude //tostring 제외
	private ProductDetail productDetail;
	
	@ManyToOne
	@JoinColumn(name = "provider_id")
	@ToString.Exclude
	private Provider provider;
	
	/************case1[@ManyToOne]***
	@ManyToOne
	@JoinColumn
	@ToString.Exclude
	private Category category;
	*****************************/
	
	/************case2[@OneToMany]***********
	product테이블에 category_id로 FK컬럼이 생성
	**/
	
	
	
	
	
}
