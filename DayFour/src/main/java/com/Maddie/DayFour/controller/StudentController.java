package com.Maddie.DayFour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Maddie.DayFour.model.StudentsEntity;
import com.Maddie.DayFour.service.StudentsService;

@RestController
public class StudentController {
	@Autowired
	StudentsService studentservice;
	
	@PostMapping("save")
	public StudentsEntity add(@RequestBody StudentsEntity detail)
	{
		return studentservice.saveTheInfo(detail);
	}
	
	@GetMapping("Display")
	public List<StudentsEntity> showMe()
	{
		return studentservice.showTheInfo();
	}
		
	@PutMapping("update/{id}")
	public String modifyById(@PathVariable int id, @RequestBody StudentsEntity detail)
	{
		return studentservice.changeInfoById(id, detail);
	}
	
	@DeleteMapping("delete/{id}")
	public void deletebyid(@PathVariable int id)
	{
		studentservice.deleteById(id);
	}

}
