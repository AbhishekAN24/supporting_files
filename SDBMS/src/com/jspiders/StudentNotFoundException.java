package com.jspiders;

public class StudentNotFoundException extends Exception {
String message;

public StudentNotFoundException(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

}
