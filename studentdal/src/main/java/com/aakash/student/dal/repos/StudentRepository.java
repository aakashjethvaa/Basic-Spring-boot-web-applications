package com.aakash.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.aakash.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
