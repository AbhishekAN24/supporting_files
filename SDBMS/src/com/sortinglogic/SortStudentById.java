package com.sortinglogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentById implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		return s1.getId().compareToIgnoreCase(s2.getId());
	}

}
