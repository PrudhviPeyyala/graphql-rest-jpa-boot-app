//package com.sb.resolvers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//
//import com.sb.model.Student;
//import com.sb.service.StudentService;
//
//@Controller
//public class StudentGql_dupResolvers {
//	
//	private StudentService studentService;
//	
//	@Autowired
//	public StudentGql_dupResolvers(StudentService studentService) {
//		this.studentService = studentService;
//	}
//
//	@QueryMapping
//	public List<Student> findAllStudents() {
//		List<Student> studentsList = studentService.getStudents();
//		return studentsList;
//	}
//	
//	
//	
//}
