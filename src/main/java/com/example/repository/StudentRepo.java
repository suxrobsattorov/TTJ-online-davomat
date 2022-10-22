package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Suxrob Sattorov, Mon 11:05 AM. 10/10/2022
 */

public interface StudentRepo extends JpaRepository<Student, Long> {

    Student findByNameAndSurname(String name, String surname);

}
