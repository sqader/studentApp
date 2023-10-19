package com.example.studentapp.controller;


import com.example.studentapp.model.StudentModel;
import com.example.studentapp.model.TaskModel;
import com.example.studentapp.service.StudentService;
import com.example.studentapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TasksController {

    private final StudentService studentService;
    private final TaskService taskService;


    @GetMapping("/tasks")
    public String getTaskList(Model model) {
        List<TaskModel> list = taskService.getTaskList();
        model.addAttribute("items", list);
        return "tasks/tasks";
    }


    @GetMapping("/addTask")
    public String addTask(Model model) {
        List<StudentModel> student = studentService.getStudentList();
        model.addAttribute("studentModel", student);
        return "tasks/addTask";
    }


    @PostMapping("/addTask")
    public RedirectView postAddTask(TaskModel task) {
        taskService.addTask(task);
        return new RedirectView("/tasks");
    }


    @GetMapping("/editTask/{id}")
    public String getTask(@PathVariable("id") Long id, Model model) {
        List<StudentModel> list = studentService.getStudentList();
        TaskModel task = taskService.getTaskById(id);
        model.addAttribute("student", list);
        model.addAttribute("task", task);
        return "tasks/editTask";
    }

    @PostMapping("/remove/{id}")
    public RedirectView removeTask(@PathVariable("id") Long id) {
        taskService.removeTask(id);
        return new RedirectView("/tasks");
    }


    @PatchMapping("/editDescription/{id}")
    public RedirectView patchEdit(@PathVariable("id") Long id, @RequestParam String description){
        taskService.updateTaskDescription(id, description);
        return new RedirectView("/tasks");
    }

    @GetMapping("/byColor/{name}")
    public String getColor(@PathVariable String name){
        taskService.findByColorTask(name);
        return "tasks/tasks";
    }


}
