package com.sb.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.sb.model.MutationResponse;
import com.sb.model.Student;
import com.sb.service.StudentService;

@Controller
public class StudentGqlResolvers {
	
	private StudentService studentService;
	
	@Autowired
	public StudentGqlResolvers(StudentService studentService) {
		this.studentService = studentService;
	} 
	
	@QueryMapping
	public List<Student> findAllStudents() {
		List<Student> studentsList = studentService.getStudents();
		return studentsList;
	}
	
	@QueryMapping
	public Student findById(@Argument int id) {
		return studentService.getStudentById(id);
	}
	
	@MutationMapping
	public MutationResponse updateStudentAddress(@Argument Student student) {
		
		MutationResponse response = new MutationResponse("Updated successfully",200);
		Student dbStudent = studentService.updateStudent(student);
		if(!dbStudent.getAddress().equals(student.getAddress())) {
			response.setResponseMessage("Not Updated successfully");
			response.setResponseStatusCode(500);
		}
		return response;
	}
}
