	/*
	 * David Lee
	 * R00108718
	 * CS2
	 * Assignment1
	 * 19/Apr/22
	 */

package application.student;

import java.time.LocalDate;

public class Student {
	
		/*==============================
		 * 		Instance Variables
		 * =============================
		 */
	
	private String fName;
	private String lName;
	private LocalDate dates;
	private String studentNo;	
		
		/*==========================
		 * 		Constructors
		  ==========================*/
	
	public Student(String fName, String lName, LocalDate dob, String studentNo) {
		this.fName = fName;
		this.lName = lName;
		this.dates = dob;
		this.studentNo = studentNo;
	}
	
	public Student(String fName, String lName, String studentNo) {
		this.fName = fName;
		this.lName = lName;
		this.studentNo = studentNo;
	}
	
	public Student() {}
		
		/*=========================
		 * 		Setters
		 * ========================*/

	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public void setdates(LocalDate dates) {
		this.dates = dates;
	}
	
	public void setstudentNo(String studNo) {
		this.studentNo = studNo;
	}
		
		
		/*=========================
		 * 		Getters
		 * ========================*/
	
	public String getFName() {
		return fName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public LocalDate getDate() {
		return dates;
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	
	public void clearStudent() {
		this.fName = null;
		this.lName = null;
		this.dates = null;
		this.studentNo = null;
	}
}
