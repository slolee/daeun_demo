package com.example.daeun_demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Student {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id = null;

	private String name;

	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
