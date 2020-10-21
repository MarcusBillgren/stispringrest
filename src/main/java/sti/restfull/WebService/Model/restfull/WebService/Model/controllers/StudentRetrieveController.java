package sti.restfull.WebService.Model.restfull.WebService.Model.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sti.restfull.WebService.Model.restfull.WebService.Model.beans.Course;

import sti.restfull.WebService.Model.restfull.WebService.Model.beans.Student;
import sti.restfull.WebService.Model.restfull.WebService.Model.beans.StudentRegistration;

@RestController
public class StudentRetrieveController {
	
	@RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
	@ResponseBody
	public List<Student> getStudents() {
		return StudentRegistration.getInstance().getStudentRecords();
	}
        
        	@RequestMapping(method = RequestMethod.GET, value="/student/{stdnId}")
	@ResponseBody
	public Student getStudent(@PathVariable("stdnId") String stdnId) {   
		return StudentRegistration.getInstance().getStudent(stdnId);
	}
        
       
	@RequestMapping(method = RequestMethod.GET, value="/student/course/all/{stdnId}")
	@ResponseBody
	public List<Course> getStudentCourses(@PathVariable("stdnId") String stdnId) {		
		System.out.println("add course " + stdnId );	   
	    return StudentRegistration.getInstance().getStudentCourses(stdnId);
	}
        
        @RequestMapping(method = RequestMethod.GET, value="/student/course/{courseId}/{stdnId}")
	@ResponseBody
	public Course getSingleCourse(@PathVariable("courseId") Integer courseId,@PathVariable("stdnId") String stdnId) {		
	    return StudentRegistration.getInstance().getStudentsCourse(stdnId, courseId);
	}	
        
        
        
        
}