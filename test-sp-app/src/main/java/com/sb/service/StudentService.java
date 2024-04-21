package com.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.model.Employee;
import com.sb.model.Student;
import com.sb.repositories.AddressRepository;
import com.sb.repositories.EmployeeRepository;
import com.sb.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	public Student saveStudentInfo(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}
	
	public Student updateStudent(Student student) {
		Optional<Student> dbStudentOptional = studentRepository.findById(student.getId());
		Student savedStudent = null;
		if(dbStudentOptional.isPresent()) {
			Student dbStudent = dbStudentOptional.get();
			dbStudent.setName(student.getName());
			dbStudent.setAge(student.getAge());
			dbStudent.setAddress(student.getAddress());
			savedStudent = studentRepository.save(dbStudent);
		}
		
		return savedStudent;
		
	}

	public Student getStudentById(int id) {
		Optional<Student> studOptional = studentRepository.findById(id);
		if(studOptional.isPresent()) {
			return studOptional.get();
		}
		return null;
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
