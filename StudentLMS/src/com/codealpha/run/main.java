package com.codealpha.run;

import java.util.Scanner;

import com.codealpha.controller.impl.ManagerControllerImpl;
import com.codealpha.controller.impl.StudentControllerImpl;

public class main {

	public static void main(String[] args) {
		StudentControllerImpl controllerImpl = new StudentControllerImpl();
		ManagerControllerImpl controllerImpl2= new ManagerControllerImpl();
		while(true) {
			try {
				System.out.println("Are you manager or student : \n1.student\n2.manager");
				Scanner s = new Scanner(System.in);
				int c = s.nextInt();
				switch (c) {
				case 1:
					controllerImpl.checkById();
					break;
				case 2:
					controllerImpl2.signIn();
					break;
				default:
					System.err.println("Enter the right choice");
					break;
				}
				
				
			} catch (Exception e) {
			System.err.println(e.getMessage());
			}
		}

	}

}
