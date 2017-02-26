package com.smu.service;

import java.util.List;

import com.smu.model.CaseStore;

public interface ICaseStoreService {
public List getCases();
public CaseStore getOneCase(int c_id);
public int addCase(CaseStore c);
public boolean deleteCase(int c_id);
    public boolean updateOneCaseStore(int CId,String CName,String CContent );
}
