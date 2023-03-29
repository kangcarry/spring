package com.itwill.jpa.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity(name = "users")//users로하는이유??
@SequenceGenerator(	name = "users_id_SEQ_gen",
sequenceName ="users_id_SEQ",
initialValue = 1 ,
allocationSize = 1)
public class User {
	@Id
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id_SEQ_gen")
	@Column(name = "id")
	private Long id;//jpa에서 pk를 int로 사용할수없다
	
	@NonNull
	@Column(nullable = false)//not null
	private String name;
	
	@NonNull //lombok 라이브러리
	@Column(nullable = false)
	private String email;
	
	
	@NonNull
	@Column(nullable = false,updatable = false)  //entity 라이브러리
	private Date createdAt;
	
	@NonNull
	@Column(nullable = false)
	private LocalDateTime updatedAt;
}
