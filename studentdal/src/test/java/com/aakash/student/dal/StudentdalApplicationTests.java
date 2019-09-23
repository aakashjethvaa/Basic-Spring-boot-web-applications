package com.aakash.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aakash.student.dal.entities.Student;
import com.aakash.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void createStudent() {
		
		Student student = new Student();
		student.setName("Aakash");
		student.setCourse("Web tools and Development");
		student.setFee(100d);
		
		studentRepository.save(student);
	}
	
	@Test
	public void findStudentById() {
		Student student = studentRepository.findById(1l).get();
	}
	
	@Test
	public void updateStudent() {
		Student student = studentRepository.findById(1l).get();
		student.setFee(500d);
		studentRepository.save(student);
	}
	
	@Test
	public void deleteStudent() {
		Student student = new Student();
		student.setId(1l);
		studentRepository.delete(student);
	}
	
}
