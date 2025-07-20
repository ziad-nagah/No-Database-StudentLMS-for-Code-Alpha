package com.codealpha.model;

import java.util.ArrayList;
import java.util.Collections;

public class Student {
	private String name ;
	private String id;
	private String grade;
	private ArrayList<Subject> subjects = new ArrayList<Subject>() ;
	
	public Student(String name , String id,String grade){
		this.id = id;
		this.name = name;
		this.setGrade(grade);
	}
	public ArrayList<Double> getMarksSet(){ 
	ArrayList<Double> marks = new ArrayList<Double>() ;
	for(Subject s : subjects) {
		marks.add(s.getMark());}
	return marks;
	}
	public void addSubject(Subject s) {
		subjects.add(s);
	}
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public double getMax() {
		  
		return Collections.max(getMarksSet());
	}
	public double getMin() {
		return Collections.min(getMarksSet());
	}
	public double getMean() {
		return (getMax() + getMin())/2;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	

}
