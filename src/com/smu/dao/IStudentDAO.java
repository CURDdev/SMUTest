package com.smu.dao;

import java.util.List;

public interface IStudentDAO {
public boolean checkStudent(String s_no);
public List getStudentsByClass(String class_name);
public List getAllStudents();
}
