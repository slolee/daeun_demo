package com.example.daeun_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daeun_demo.aspect.CustomStopWatch;
import com.example.daeun_demo.controller.request.StudentRequest;
import com.example.daeun_demo.model.Student;
import com.example.daeun_demo.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {
	private final StudentService service;

	@CustomStopWatch
	@GetMapping("/api/student/{id}")
	public ResponseEntity<Student> retrieve(@PathVariable Long id) {
		Student student = service.retrieveStudent(id);
		return ResponseEntity.ok(student);
	}

	@CustomStopWatch
	@PostMapping("/api/student")
	public ResponseEntity<Student> register(@RequestBody StudentRequest req) {
		Student createdStudent = service.registerStudent(req);
		return ResponseEntity.ok(createdStudent);
	}

}
