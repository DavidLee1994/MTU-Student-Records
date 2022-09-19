	/*
	 * David Lee
	 * R00108718
	 * CS2
	 * Assignment1
	 * /Apr/22
	 */

package application.student.module;

//import application.student.Student;

public class Module /* extends Student */ {
	
	/*==============================
	 * 		Instance Variables
	 * =============================
	 */
	
	private String module;
	private double grade;
	
	/*==========================
	 * 		Constructors
	  ==========================*/

	public Module(int position, String module, double grade) {
		this.module = module;
		this.grade = grade;
	}
	
	public Module(String module, double grade) {
		this.module = module;
	}
	
	public Module() {}
	
	/*=========================
	 * 		Setters
	 * ========================*/
	
	public void setModule(String module) {
		this.module = module;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	/*=========================
	 * 		Getters
	 * ========================*/
	
	public String getSModule() {
		return module;
	}
	
	public double getGrade() {
		return grade;
	}
	
}
