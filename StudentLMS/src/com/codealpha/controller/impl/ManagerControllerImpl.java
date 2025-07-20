package com.codealpha.controller.impl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.codealpha.controller.ManagerController;
import com.codealpha.model.Student;
import com.codealpha.model.Subject;


public class ManagerControllerImpl implements ManagerController{
	
	private Manager m= new Manager("ziad" , "123");
	static ArrayList<Student> students = new ArrayList<Student>() ;
	Scanner s1 = new Scanner(System.in);
	Scanner s2 = new Scanner(System.in);

	@Override
	public void signIn(){
		System.out.println("Enter your name :");
		String name =s1.next();
		if(name.equals(m.getName())){
			System.out.println("your password please:");
			String password =s1.next();
			if(password.equals(m.getPassword())){start();
			}else{
				throw new InputMismatchException("password is not right make sure");
				}
			}else{
				throw new InputMismatchException("user name is not exist");
				}
		}
	@Override
	public void start(){
		System.out.println("welcome " +m.getName());
		String s = students.size()==0?"the database is empty input 1 to add students ergently !":"number of student in our DB is " + students.size()+"\n1.add student to our db\n2.edit student's grades\n3.exit";
		System.out.println(s);
		
		int choice = s1.nextInt();
		
		switch (choice) {
		case 1:
			addStudent();
			break;
		case 2:
			if(students.size()!=0){addMarks();}
			break;
		case 3:
			throw new InputMismatchException("thank you");	
		default:
			throw new InputMismatchException("choose right please");
			
		}
		
	}
	@Override	
	public void addStudent(){
		System.out.print("enter nuber of studens to add : ");
		int x = s1.nextInt();
		boolean tryagain ;
		for(int i = 0,e = 1; i< x ; i++,e++){
			tryagain = true;
			System.out.println("Student NO. " + e);
			System.out.println("Enter student name : ");
			String name = s1.next();
			System.out.println("Enter student Faculity ID : ");
			String id = s2.next();
			for(Student s :students){if(s.getId().equals(id)){System.err.println("Sorry the id must be unique try again");tryagain=false;}}
			if(!tryagain) {--i;--e;continue;}
			System.out.println("Enter student Grade : ");
			String grade = s1.next();
			System.out.println("Saving....");
			
            students.add(new Student(name,id,grade));
			
		}
			
	}
	@Override
	public void addMarks(){
		System.out.println("type student id :");
		String id = s1.next();
		for(Student s :students){if(s.getId().equals(id)){
			System.out.println("how many subject do you want to add ? : ");
			int x = s2.nextInt();
			for(int i =0 ;i< x;i++) {
			System.out.println("enter subject name :");
			String name = s1.next();
			System.out.println("enter student mark :");
			double mark = s2.nextDouble();
			s.addSubject(new Subject(name, mark));
			}break;}throw new InputMismatchException("enter right ID");}
		
		
	} 
	public class Manager{
		
		private String name ;
		private String password ;
		public Manager(String name , String password) {
			this.name = name;
			this.password = password;
		}
		public String getName() {
			return name;
		}
		
		public String getPassword() {
			return password;
		}
		
	}
	
	
	

}



