package com.qsp.task_management_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.qsp.task_management_project.model.Task;
import com.qsp.task_management_project.repository.TaskDao;

@Controller
public class EmployeeController {
	
	
	@Autowired
	private TaskDao dao;
     
	//To open home page
	@GetMapping("/")
	public String getMessage(Model model) {
		List<Task>task=dao.getAllTask();
		
		model.addAttribute("task", task);
		
		return "home";
	}
	
	//To open add task form
	
	@GetMapping("/add-task")
	public String addTask() {
		return "addtask";
	}
	
	
	@PostMapping("/handle-task")
	public String handleTask(Task task) {
		
		System.out.println(task.getId());
		System.out.println(task.getTitle());
		System.out.println(task.getDescription());
		
		boolean b=dao.addTaskDao(task);
		if(b) {
			System.out.println("task is added....");
		}else {
			System.out.println("task is not added......");
		}
		
		return "redirect:/";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteByID(@PathVariable("id") int id) {
		
		boolean b=dao.delelteTaskById(id);
		if(b) {
			System.out.println("task is deleted....");
		}else {
			System.out.println("task is not deleted......");
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
	    Task task = dao.getTaskByID(id);
	    model.addAttribute("task", task);
	    return "update-form";
	}

	 
	
	@GetMapping("/update-handle")
	public String handleTaskUpdate(Task task) {
		
		
		boolean b=dao.updateTaskDao(task);
		if(b) {
			System.out.println("task is added....");
		}else {
			System.out.println("task is not added......");
		}
		
		return "redirect:/";
	}
	
	
	
	
}
