package com.example.studentapp.repository;

import com.example.studentapp.model.StudentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    Page<StudentModel> findAll(Pageable pageable);



}
