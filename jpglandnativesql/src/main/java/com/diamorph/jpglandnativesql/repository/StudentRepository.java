package com.diamorph.jpglandnativesql.repository;

import com.diamorph.jpglandnativesql.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query("select st.firstName, st.lastName from Student st")
    List<Object[]> findAllStudentsPartialData();

    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score>=:min and score<=:max")
    List<Student> findAllStudentsForGivenScores(@Param("min") int min, @Param("max") int max);

    @Modifying
    @Query("delete from Student where firstName=:firstName")
    void deleteStudentsByFirstName(@Param("firstName") String firstName);

    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<Student> findAllStudentsNQ(Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE fname=:firstName", nativeQuery = true)
    List<Student> findByFirstNameNQ(@Param("firstName") String firstName, Pageable pageable);

    @Query(value = "SELECT id, fname, lname FROM student WHERE fname=:firstName", nativeQuery = true)
    List<Object[]> findByFirstNameNQPartialData(@Param("firstName") String firstName, Pageable pageable);
}
