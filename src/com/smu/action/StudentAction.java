package com.smu.action;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.*;
import com.opensymphony.xwork2.ActionSupport;
import com.smu.service.IStudentService;
import com.smu.model.Student;

public class StudentAction extends ActionSupport {
private IStudentService studentService;
private String s_no;
private String result;
private Student s;
public Student getS() {
	return s;
}
public void setS(Student s) {
	this.s = s;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public IStudentService getStudentService() {
	return studentService;
}
public void setStudentService(IStudentService studentService) {
	this.studentService = studentService;
}
public String getS_no() {
	return s_no;
}
public void setS_no(String s_no) {
	this.s_no = s_no;
}
public String execute() throws Exception {
    HttpServletRequest request = ServletActionContext.getRequest();
	Student student = new Student();
	student = studentService.checkStudent(s_no);
	Map<String,String > map = new HashMap<String,String>();
	map.put("class",student.getMclass().getClassName());
	map.put("name",student.getSName());
	map.put("no",student.getSNo());
	map.put("grade",student.getSGrade());
	result  = JSON.toJSONString(map);
//	result = "{'name':'"+student.getSName()+"','className':'"+student.getMclass().getClassName()+"','no':'"+student.getSNo()+"'}";
	return SUCCESS;
  }
}
