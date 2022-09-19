	/*
	 * David Lee
	 * R00108718
	 * CS2
	 * Assignment1
	 * 19/Apr/22
	 */

package application.student;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class StudentList {
	
	private ArrayList <Student> studentList;
	
	
	public StudentList() {
		studentList = new ArrayList<Student>();
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public void removeStudent(Student removeStudent) {
		 for (int i = 0; i < studentList.size(); i++) {
		        if (studentList.equals(removeStudent == studentList.get(i))) {
		            studentList.remove(i);
		        }
		    }
		while (studentList.contains(removeStudent)){
				studentList.remove(removeStudent);
		}
	}
	
	public int getSize (){
		return studentList.size();
	}
	
	public String allStudent(int i) {
		String allStudents ="\0";

		for(i=0;i<studentList.size(); i++) {
			allStudents = studentList.get(i).getFName()+" "+studentList.get(i).getLName()+"\t\t"+studentList.get(i).getDate()+"\t"+studentList.get(i).getStudentNo();
		}
		return allStudents;
	}
	
	public String studentBoxList() {
		String allStudents = "\0";
		int i;
		for(i=0;i<studentList.size();i++) {
			allStudents = studentList.get(i).getFName()+ " "+ studentList.get(i).getLName()+ " "+ studentList.get(i).getStudentNo();
		}
		return allStudents;
	}
}
