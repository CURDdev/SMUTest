package com.smu.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.smu.service.IStudentService;

public class StudentAction extends ActionSupport {
private IStudentService studentService;
private String s_no;
private String result;
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
    //获取ajax传过来的数据直接使用前台的属性名即可获取。
   
   
    if(studentService.checkStudent(s_no)){
      //返回给ajax的数据
      this.result = "true";
    }else{
      this.result = "false";
    }
    return SUCCESS;
  }
}
