package sti.restfull.WebService.Model.restfull.WebService.Model.controllers;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sti.restfull.WebService.Model.restfull.WebService.Model.beans.Course;

import sti.restfull.WebService.Model.restfull.WebService.Model.beans.Student;
import sti.restfull.WebService.Model.restfull.WebService.Model.beans.StudentRegistration;

@RestController
public class StudentUpdateController {
	
	@RequestMapping(method = RequestMethod.PUT, value="/update/student")
	@ResponseBody
	public String updateStudentRecord(@RequestBody Student stdn) {		
		System.out.println("In updateStudentRecord");	   
	    return StudentRegistration.getInstance().upDateStudent(stdn);		
	}
        
        	

	@RequestMapping(method = RequestMethod.PUT, value="/update/student/{stdnId}/addcourse")
	@ResponseBody
	public String updateStudentRecord(@PathVariable("stdnId") String stdnId,@RequestBody Course course) {		
		System.out.println("add course " + stdnId );	   
	    return StudentRegistration.getInstance().addCourse(stdnId, course);
	}	
}
