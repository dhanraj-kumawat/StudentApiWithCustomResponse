package com.dktech.springbootcrudapp.dao;

import com.dktech.springbootcrudapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.name LIKE %:name%")
    List<Student> findNameIncludes(@Param("name") String name);

}
