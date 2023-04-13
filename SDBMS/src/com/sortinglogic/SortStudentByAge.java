package com.sortinglogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentByAge implements Comparator<Student>{

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return x.getAge()-y.getAge();
	}

}
