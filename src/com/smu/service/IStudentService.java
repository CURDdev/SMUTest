package com.smu.service;

import java.util.List;
import com.smu.model.Student;
public interface IStudentService {
public Student checkStudent(String s_no);
public List getStudentsByClass(String class_name);
public List getAllStudents();
}
