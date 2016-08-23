package com.smu.dao;

import java.util.List;

import com.smu.model.Case;

public interface ICaseDAO {
public List getCases(String st_id);
public Case getOneCase(String c_id);
public boolean addCase(Case c);
public boolean deleteCase(String c_name);
}