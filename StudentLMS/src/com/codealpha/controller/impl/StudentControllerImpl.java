package com.codealpha.controller.impl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.codealpha.controller.StudentController;
import com.codealpha.model.Student;
import com.codealpha.model.Subject;

public class StudentControllerImpl implements StudentController{
	Scanner s1 = new Scanner(System.in);

	@Override
	public void checkById() {
		System.out.println("Welcome student please enter your id :");
		String id = s1.next();
		for(Student s :ManagerControllerImpl.students){if(s.getId().equals(id)){showStat(s);break;}throw new InputMismatchException("enter right ID");}
	}

	@Override
	public void showStat(Student student){
		System.out.println("Welcome "+ student.getName());
		for(Subject s : student.getSubjects()) {System.out.println(s.getName() +" ----> "+mark(s.getMark()));}
		System.out.println("MAX point : " + student.getMax());
		System.out.println("MIN point : " + student.getMin());
		System.out.println("Avarage point : " + student.getMean());
	}

	@Override
	public char mark(double mark) {
		if(mark < 50) {return 'F';}
		else if(mark<=65) {return 'D';}
		else if(mark<=75) {return 'C';}
		else if(mark<=85) {return 'B';}
		else if(mark<=100) {return 'A';}
		else {return 'F';}
	}
	
	
	

}
