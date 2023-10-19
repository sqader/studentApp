package com.example.studentapp.service;

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository;


    public void addStudent(StudentModel student) {
        studentRepository.save(student);
    }


    public List<StudentModel> getStudentList() {
        return studentRepository.findAll();
    }


    public StudentModel findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void saveEditStudent(StudentModel editStudent) {
        studentRepository.save(editStudent);
    }

    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Page<StudentModel> getAllStudentsPageable(Pageable pageable){
        return studentRepository.findAll(pageable);
    }




}
