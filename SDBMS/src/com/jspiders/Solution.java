package com.jspiders;

import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		//upcasting for acheiving abstraction
		StudentManagementSystem sms=new  StudentManagementSystemImpl();

		//accept input from user
		Scanner scan =new Scanner(System.in);
		System.err.println("WELCOME TO STUDENT DATABASE MANAGEMENT SYSTEM\n-----------------------------------------");

		while(true) {
			System.out.println("1.Add Student\n2.Display Student\n3.Display All Student\n4.Remove Student\n5.Remove All Student\n6.Update Student\n7.Count Student\n8.Sort Student\n9.Exit");

			int choice =scan.nextInt();

			switch(choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				System.err.println("THANK YOU!");
				System.exit(0);
				break;
			default :
				System.out.println("Enter valid choice");
			}
		}

	}

}
