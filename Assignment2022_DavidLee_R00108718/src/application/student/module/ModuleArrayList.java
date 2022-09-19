	/*
	 * David Lee
	 * R00108718
	 * CS2
	 * Assignment1
	 * 19/Apr/22
	 */

package application.student.module;

import java.util.ArrayList;
import application.student.StudentList;

public class ModuleArrayList extends StudentList {
	
	private ArrayList <Module> moduleList;
	
	public ModuleArrayList() {
		moduleList = new ArrayList <Module>();
	}
	
	public void addModule(Module module) {
		moduleList.add(module);
	}
	
	public void removeModule(Module module) {
		moduleList.remove(module);
	}
	
	public int getSize() {
		return moduleList.size();
	}
	
	public String listModule(int i) {
		String allModule = "\0";
		for (i = 0; i<moduleList.size();i++) {
			allModule = moduleList.get(i).getSModule() + " " + moduleList.get(i).getGrade();
		}
		return allModule;
	}
}
