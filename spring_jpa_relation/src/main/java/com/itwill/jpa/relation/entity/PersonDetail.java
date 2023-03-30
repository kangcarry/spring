package com.itwill.jpa.relation.entity;

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
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Builder
@Entity
@ToString
@Table
public class PersonDetail extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Column(nullable = false)
	private String MBTI;
	
	@OneToOne
	@JoinColumn(name = "person")
	@ToString.Exclude
	private Person person;
}
