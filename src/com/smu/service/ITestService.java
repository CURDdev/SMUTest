package com.smu.service;
import java.util.List;

import com.smu.model.Test;
public interface ITestService {
public int addTest(Test t);
public List gainTests();
public Test getOneTest(int t_id);
}