package com.sortinglogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentByName implements Comparator<Student>{

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return x.getName().compareToIgnoreCase(y.getName());
	}

}
