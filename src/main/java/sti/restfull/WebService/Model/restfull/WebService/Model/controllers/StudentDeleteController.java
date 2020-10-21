package sti.restfull.WebService.Model.restfull.WebService.Model.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sti.restfull.WebService.Model.restfull.WebService.Model.beans.Course;

import sti.restfull.WebService.Model.restfull.WebService.Model.beans.StudentRegistration;

@RestController
public class StudentDeleteController {

	@RequestMapping(method = RequestMethod.DELETE, value="/delete/student/{regdNum}")
	
	@ResponseBody
	public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {		
		System.out.println("In deleteStudentRecord");	   
	    return StudentRegistration.getInstance().deleteStudent(regdNum);		
	}
        
        
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/student/{stdnId}/deletecourse")
	@ResponseBody
	public String updateStudentRecord(@PathVariable("stdnId") String stdnId,@RequestBody Course course) {		
		System.out.println("add course " + stdnId );	   
	    return StudentRegistration.getInstance().deleteCourse(stdnId, course);
	}	
}
