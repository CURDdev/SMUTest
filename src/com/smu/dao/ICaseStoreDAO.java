package com.smu.dao;

import java.util.List;

import com.smu.model.CaseStore;

public interface ICaseStoreDAO {
public List getCases();
public CaseStore getOneCase(int c_id);
public int addCase(CaseStore c);
public boolean deleteCase(int c_id);
}