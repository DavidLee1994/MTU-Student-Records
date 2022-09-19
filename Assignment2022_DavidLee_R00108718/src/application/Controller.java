	/*
	 * David Lee
	 * R00108718
	 * CS2
	 * Assignment1
	 * 19/Apr/22
	 */

package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import application.student.Student;
import application.student.StudentList;
import application.student.module.ModuleArrayList;
import javafx.collections.ObservableList;
import application.student.module.Module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller {
	
	
	private StudentList studCont;
	private ModuleArrayList moduleList;
	
	public Controller() {
		studCont = new StudentList();
		moduleList = new ModuleArrayList();
	}
	
	//=============Student==================
	
	public void addStudentList(String fName,String lName, LocalDate dob, String studNo)
	{
		Student stud = new Student(fName, lName, dob, studNo);
		studCont.addStudent(stud);
	}
	
	public String getListStudent()
	{
		String noStudents = "No Students have been added";
		String allStudent="\n";
		for (int i = 0;i<studCont.getSize();i++){
			return studCont.allStudent(i);	
		}	
		return noStudents; 
	}
	
	public void removeStudentList(String fName,String lName, LocalDate dob, String studNo)
	{
		Student stud = new Student(fName, lName, dob, studNo);
		studCont.removeStudent(stud);
	}
	
	public String saveStudentCSV() throws IOException {
		String fileFound = "File Not Found";
		FileWriter fStudentCSV = new FileWriter("StudentCSV.csv");
		PrintWriter pStudentCSV = new PrintWriter(fStudentCSV);
//		ArrayList<Student> studList = studCont.get
		fStudentCSV.write("Forename");
		fStudentCSV.write("Surname");
		fStudentCSV.write("Date of Birth");
		fStudentCSV.write("Student Number");
		fStudentCSV.write("\n");
		for (int i = 0;i<studCont.getSize();i++){
			 fStudentCSV.write(studCont.allStudent(i)+"\n");
			 fStudentCSV.write(moduleList.listModule(i));
		}
		return fileFound;
	}
	
	public String loadStudentCSV() throws FileNotFoundException, IOException {
	   String line = "No input into file";
		try (BufferedReader br = new BufferedReader(new FileReader("StudentCSV.csv"))) {
			   while ((line = br.readLine()) != null) {
			       return line;
			   }
			}
		return line;
	}
	
	//======================================
	
	//================Module================
	
	public void addModule(int position, String module, double grade) {
		Module moduleAdd = new Module( position, module, grade);
		moduleList.addModule(moduleAdd);
	}
	
	public void removeModule(int position, String module, double grade) {
		Module moduleRemove = new Module(position, module, grade);
		moduleList.removeModule(moduleRemove);
	}
	
	public String studentComboList() {
		StudentList studList = new StudentList();
		return studList.studentBoxList();
	}
}
