package com.ts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.StudentDao;
import com.model.Student;

@RestController
public class StudentController {
	@Autowired
	StudentDao studentDao;
	
	@GetMapping("getAllStudents")
	public List<Student> getAllStudents() {		
		return studentDao.getAllStudents();
	}
}