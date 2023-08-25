package com.Maddie.DayFour.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maddie.DayFour.model.StudentsEntity;
import com.Maddie.DayFour.repository.StudentsRepository;

@Service
public class StudentsService {
	@Autowired
	StudentsRepository studentrepository;
	
	public StudentsEntity saveTheInfo(StudentsEntity detail)
	{
		return studentrepository.save(detail);
	}
	public List<StudentsEntity> showTheInfo()
	{
		return studentrepository.findAll();
	}
	public Optional<StudentsEntity> showInfoById(int id)
	{
		return studentrepository.findById(id);
	}
	public String changeInfoById(int id, StudentsEntity detail)
	{
		studentrepository.saveAndFlush(detail);
		if(studentrepository.existsById(id))
		{
			return "The values are Updated";
		}
		else
		{
			return "Please Enter the Valid Id";
		}
	}
	public void deleteById(int id)
	{
		studentrepository.deleteById(id);
	}
}