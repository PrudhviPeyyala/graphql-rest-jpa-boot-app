package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.Employee;
import com.sb.model.Student;
import com.sb.service.StudentService;

@RestController
@RequestMapping("/myapp")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/student")
	public ResponseEntity<List<Student>> students() {
		 List<Student> studentsList = studentService.getStudents();
		return new ResponseEntity(studentsList, HttpStatus.OK);
	}
	
	@PostMapping(value="/student")
	public ResponseEntity<Student> student(@RequestBody Student student) {
		Student savedStudent = studentService.saveStudentInfo(student);
	   return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/student")
	public ResponseEntity<Student> studentData(@RequestBody Student student) {
		Student updatedStudent = studentService.updateStudent(student);
		if(updatedStudent==null) {
			return new ResponseEntity<Student>(new Student(),HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/student/{id}")
	public ResponseEntity<String> student(@PathVariable("id") String id) {
		return new ResponseEntity<String>("id => "+id,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = studentService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
	}
	


}
