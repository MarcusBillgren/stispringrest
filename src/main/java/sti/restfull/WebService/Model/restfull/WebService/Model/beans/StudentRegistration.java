package sti.restfull.WebService.Model.restfull.WebService.Model.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRegistration {
private List<Student> studentRecords;
	
	private static StudentRegistration stdregd = null;
	
	private StudentRegistration(){
		studentRecords = new ArrayList<Student>();
	}
	
	public static StudentRegistration getInstance() {
		
		if(stdregd == null) {
			stdregd = new StudentRegistration();
			return stdregd;
		}
		else {
			return stdregd;
		}
	}
	
	public void add(Student std) {
		studentRecords.add(std);
	}
	
	public String upDateStudent(Student std) {
		
		for(int i=0; i<studentRecords.size(); i++)
        {
            Student stdn = studentRecords.get(i);
            System.out.println(stdn.getRegistrationNumber());
            System.out.println(std.getRegistrationNumber());
            if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
            	studentRecords.set(i, std);//update the new record
            	return "Update successful";
            }
        }
		
		return "Update un-successful";
		
	}
	
	public String deleteStudent(String registrationNumber) {
		
		for(int i=0; i<studentRecords.size(); i++)
        {
            Student stdn = studentRecords.get(i);
            if(stdn.getRegistrationNumber().equals(registrationNumber)) {
            	studentRecords.remove(i);//update the new record
            	return "Delete successful";
            }
        }
		
		return "Delete un-successful";
		
	}
        
        public String addCourse(String registrationNumber, Course course){
          
            for(Student s: studentRecords){
                if(s.getRegistrationNumber().equals(registrationNumber)){
                    s.courses.add(course);
                    return "added new course";
                }
                
            }
           return "course not added";
        }

	public List<Student> getStudentRecords() {
		return studentRecords;
	}

    public String deleteCourse(String registrationNumber, Course course) {
        
        int index = 0;
        for(Student s : studentRecords){
            if(s.getRegistrationNumber().equals(registrationNumber)){
                
                for(Course c : s.getCourses()){
                    if(c.getId() == course.getId()){
                        index = s.getCourses().indexOf(c);
                    }
                        
                }
                
                s.getCourses().remove(index);
                      
                return "Course deleted";
            }
        }     
         return "course not found";
    }

    public Student getStudent(String stdnId) {
        Student student = null;
          for(Student s : studentRecords){
            if(s.getRegistrationNumber().equals(stdnId)){  
                student = s; 
            }
        }     
         return student;
    }

    public List<Course> getStudentCourses(String stdnId) {
          for(Student s : studentRecords){
            if(s.getRegistrationNumber().equals(stdnId)){  
                return s.getCourses();
            }
        }     
         return null;
    }

    public Course getStudentsCourse(String stdnId, int courseId) {
          for(Student s : studentRecords){
            if(s.getRegistrationNumber().equals(stdnId)){  
               Optional<Course> course = s.getCourses()
                       .stream()
                       .filter(c -> c.getId() == courseId).findFirst();
               return course.isPresent() ? course.get() : null;
            }
        }     
         return null;
    }
}
