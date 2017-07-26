package com.smu.service;

import com.smu.model.Teacher;

import java.util.List;


public interface IUserService {
    public Teacher checkUser(Teacher teacher);
    public Teacher getTeacherByTId(String TId);
    public List getAllTeachers();
    public boolean addOneTeacher(Teacher t);
    public boolean deleteOneTeacher(String TId);
    public boolean checkTeacherId(String TId);
    public boolean updateOneTeacherName(String TId,String TName);
}
