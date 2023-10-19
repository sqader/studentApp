package com.example.studentapp.controller;

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentsController {


    private final StudentService studentService;


    @GetMapping("/students")
    public String getStudentList(Model model) {
        List<StudentModel> studentList = studentService.getStudentList();
        model.addAttribute("studentModel", studentList);
        return "persons/personList";
    }

    @GetMapping("/addStudent")
    public String getAddStudent() {
        return "persons/addNewPerson";
    }


    @PostMapping("/addStudent")
    public RedirectView postAddStudent(StudentModel student) {
        studentService.addStudent(student);
        return new RedirectView("/students");
    }


    @GetMapping("/editStudent/{id}")
    public String getEditStudent(@PathVariable("id") Long id, Model model) {
        StudentModel student = studentService.findById(id);
        model.addAttribute("studentModel", student);
        return "persons/editPerson";
    }


    @PostMapping("/edit/{id}")
    public RedirectView editStudent(StudentModel editStudent) {
        studentService.saveEditStudent(editStudent);
        return new RedirectView("/students");
    }


    @PostMapping("/del/{id}")
    public RedirectView deleteStudent(@PathVariable("id") Long id){
        studentService.removeStudent(id);
        return new RedirectView("/students");
    }


    @GetMapping("/allStudents")
    public Page<StudentModel> getAllStudentsPageable(Pageable pageable){
        int currentPage = pageable.getPageNumber();
        return studentService.getAllStudentsPageable(pageable);
    }



}
