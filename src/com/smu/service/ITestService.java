package com.smu.service;
import java.util.List;

import com.smu.model.Test;
public interface ITestService {
public int addTest(Test t);
public List gainTests();
/**通过考试 ID 获得一个考试对象*/
public Test getOneTest(int t_id);
    public List getAllTests();
    public List getPreTests();
    public List getLaterTests();
    public boolean deleteTests(int t_id);
}