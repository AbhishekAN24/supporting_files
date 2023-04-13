package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.sortinglogic.SortStudentByAge;
import com.sortinglogic.SortStudentById;
import com.sortinglogic.SortStudentByMarks;
import com.sortinglogic.SortStudentByName;

/**
 * @author Abhishek
 * @since 2022
 * 
 * we are adding implementation for 8 abstract methods StudentManagementSystem
 *
 * 
 *
 *
 */
public class StudentManagementSystemImpl implements StudentManagementSystem{
Map<String, Student> db= new LinkedHashMap<String, Student>();
Scanner scan=new Scanner(System.in);

	@Override
	public void addStudent() {
		System.out.println("Enter Name:");
		String name=scan.next();
		System.out.println("Enter age:");
		int age=scan.nextInt();
		System.out.println("Enter Marks:");
		int marks=scan.nextInt();
		
		Student s=new Student(name, age, marks);
		db.put(s.getId(), s);
		System.out.println("Student Record Inserted Succesfully\n-------------------");
		System.out.println("Your Student Id is "+s.getId()+"\n-----------------");
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id: ");
		String id="JSP"+scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student obj = db.get(id);
			System.out.println("Id: "+ obj.getId());
			System.out.println("Name: "+ obj.getName());
			System.out.println("Age: "+ obj.getAge());
			System.out.println("Marks: "+obj.getMarks());
			System.out.println("----------------------");
		}
		else {
			try {
				throw new StudentNotFoundException("Student Records Not Available to Display\n-----------------------");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudent() {
		Set<String> keys=db.keySet();
		System.out.println("Student Records Are as Follows:");
		System.out.println("-------------------------------");
		if(db.size()!=0) {
			for (String key : keys) {
				System.out.println(db.get(key));
			}
			System.out.println("---------------");
		}
		else {
			try {
				throw new StudentNotFoundException("Student Records Not Available to Display\n----------------------------");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() {		//Accept id,  convert uppercase,   containskey(),   remove(),   else--->SNFE  ->handle
		System.out.println("Enter the student Id to remove from list of records");
		String sid="JSP"+scan.next();
		sid=sid.toUpperCase();
		
		if(db.containsKey(sid)) {
			db.remove(sid);
			System.out.println("your student data is removed\n-------------------------");
		}
		else {
			try {
				throw new StudentNotFoundException("student record not available to remove\n----------------------------");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void removeAllStudent() {
		System.out.println(db.size()+" Number of Students Present");
		db.clear();
		System.out.println("All Student Records Are Removed Succefully!");
		
	}

	@Override
	public void updateStudent() {
		//Accept id & uppercase, containskey, get the student object
		//switch case 1:update name, age, marks
		//invoke exception
		System.out.println("Enter the student Id to update the records");
		String id="JSP"+scan.next();
		id=id.toUpperCase();
		
		
		if(db.containsKey(id)) {
			Student obj = db.get(id);
			System.out.println("1.update Name\n2.update age\n3.update marks\n");
			Scanner scan=new  Scanner(System.in);
			System.out.println("Enter choice:");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter name to update");
				obj.setName(scan.next());
				System.out.println("Student Name updated Succesfully");
				break;
			case 2:
				System.out.println("Enter age to update");
				obj.setAge(scan.nextInt());
				System.out.println("Student Age updated Succesfully");
				break;
			case 3:
				System.out.println("Enter marks to update");
				obj.setMarks(scan.nextInt());
				System.out.println("Student Marks updated Succesfully");
				break;
				default:
					try {
						throw new StudentNotFoundException("Invalid Choice\n----------------------------");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
			}
			System.out.println(" ----------------------");
		}
		else {
			try {
				throw new StudentNotFoundException("student record not found\n----------------------------");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void countStudent() {
	System.out.println("Total number of Students "+db.size()+"\n---------------------");
		
	}

	@Override
	public void sortStudent() {
		
		/*converting map into set
		 * keys are student Id and datatype is String
		 */
		Set<String> keys=db.keySet();
		
		/**
		 * Achieving upcasting between List & ArrayList
		 * list can store student objects
		 */
		List<Student> l=new ArrayList<>();
		
			for (String key : keys) {
			l.add(db.get(key));		//Adding Student objects from Map to List
		}
		System.out.println("1.Sort Student By Id\n2.Sort Student By Name\n3.Sort Student By Age\n4.Sort Student By Marks");
		Scanner scan=new  Scanner(System.in);
		System.out.println("Enter choice:");
		int choice=scan.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(l, new SortStudentById());
			display(l);
			break;
		case 2:
			Collections.sort(l, new SortStudentByName());
			display(l);
			break;
		case 3:
			Collections.sort(l, new SortStudentByAge());
			display(l);
			break;
		case 4:
			Collections.sort(l, new SortStudentByMarks());
			display(l);
			break;
			default:
				try {
					throw new StudentNotFoundException("Invalid Choice\n----------------------------");
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
		}
		System.out.println("----------------------");
	}
	private static void display(List<Student> l){
		for (Student s : l) {
			System.out.println(s);
		}
	}
	}
