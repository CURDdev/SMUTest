package com.smu.dao;

import java.util.List;

import com.smu.model.Student;

public interface IStudentDAO {
public Student checkStudent(String s_no);
public List getStudentsByClass(String class_name);
public List getAllStudents();
}
