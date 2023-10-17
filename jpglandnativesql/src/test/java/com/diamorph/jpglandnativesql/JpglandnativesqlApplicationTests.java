package com.diamorph.jpglandnativesql;

import com.diamorph.jpglandnativesql.entity.Student;
import com.diamorph.jpglandnativesql.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpglandnativesqlApplicationTests {

	@Autowired
	StudentRepository studentRepository;
	@Test
	public void testStudentCreate() {
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < 20; i++) {
			Student student1 = new Student();
			student1.setFirstName("Vlad");
			student1.setLastName("Tymoshenko");
			student1.setScore(secureRandom.nextInt(100));
			studentRepository.save(student1);

			Student student2 = new Student();
			student2.setFirstName("Ivan");
			student2.setLastName("Ivanov");
			student2.setScore(secureRandom.nextInt(100));
			studentRepository.save(student2);
		}
	}

	@Test
	public void testFindAllStudents() {
		List<Student> students = studentRepository.findAllStudents(PageRequest.of(1, 10, Sort.by(Sort.Direction.ASC, "id")));
		System.out.println(students);
		assertEquals(students.size(), 10);
		assertEquals(students.get(0).getFirstName(), "Vlad");
	}

	@Test
	public void testFindAllStudentsNQ() {
		List<Student> students = studentRepository.findAllStudentsNQ(PageRequest.of(1, 10));
		System.out.println(students);
        assertFalse(students.isEmpty());
	}

	@Test
	public void testFindAllStudentPartial() {
		List<Object[]> allStudentsPartialData = studentRepository.findAllStudentsPartialData();
		allStudentsPartialData.forEach(o -> System.out.println(o[0] + " " + o[1]));
	}

	@Test
	public void testFindAllStudentByFirstName() {
		List<Student> students = studentRepository.findAllStudentsByFirstName("Vlad");
		assertEquals(students.size(), 3);
		students.forEach(student -> assertEquals(student.getFirstName(), "Vlad"));
	}

	@Test
	public void testFindByFirstNameNQ() {
		List<Student> students = studentRepository.findByFirstNameNQ("Vlad", PageRequest.of(0, 10));
		System.out.println(students);
//		assertEquals(students.size(), 3);
		students.forEach(student -> assertEquals(student.getFirstName(), "Vlad"));
	}


	@Test
	public void testFindAllStudentNQPartial() {
		List<Object[]> allStudentsPartialData = studentRepository.findByFirstNameNQPartialData("Vlad", PageRequest.of(0, 10));
		allStudentsPartialData.forEach(o -> System.out.println(o[0] + " " + o[1] + " " + o[2]));
	}
	@Test
	public void testFindAllStudentByGivenScore() {
		List<Student> students = studentRepository.findAllStudentsForGivenScores(90, 100);
		students.forEach(student -> {
			int score = student.getScore();
			System.out.println(student);
			assertTrue( score > 90 && score <= 100);
		});
	}

	@Test
	@Transactional
	@Rollback(false)
	public void deleteStudentsByFirstName() {
		studentRepository.deleteStudentsByFirstName("Vlad");
		assertTrue(studentRepository.findAllStudentsByFirstName("Vlad").isEmpty());
	}
}
