package com.example.daeun_demo.service;

import org.springframework.stereotype.Service;

import com.example.daeun_demo.controller.request.StudentRequest;
import com.example.daeun_demo.model.Student;
import com.example.daeun_demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	private final StudentRepository repository;

	public Student registerStudent(StudentRequest req) {
		Student newStudent = new Student(req.getName(), req.getAge());
		return repository.save(newStudent); // JPA
	}

	public Student retrieveStudent(Long id) {
		Student s = repository.findById(id).orElseThrow(() -> new RuntimeException(""));
		// Student
		return s;
	}

}
