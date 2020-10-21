package sti.restfull.WebService.Model.restfull.WebService.Model.beans;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	String name;
	int age;
	String registrationNumber;
        List<Course> courses;

    public Student() {
        courses = new ArrayList<>();
    }
        
        
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

        public List<Course> getCourses() {
            return courses;
        }

        public void setCourses(List<Course> courses) {
            this.courses = courses;
        }
        
}
