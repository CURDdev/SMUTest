package com.smu.dao;
import java.sql.Timestamp;
import java.util.List;

import com.smu.model.Test;;
public interface ITestDAO {
public List gainTests();
public int addTest(Test t);
public Test getOneTest(int t_id);
public List getAllTests();
public List getPreTests();
public List getLaterTests();
public boolean deleteTests(int t_id);
}
