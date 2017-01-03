package com.smu.dao;

import java.util.List;

import com.smu.model.Case;

public interface ICaseDAO {
public List getCases(int st_id);
public Case getOneCase(int c_id);
public int addCase(Case c);
public boolean deleteCase(int c_id);
}
