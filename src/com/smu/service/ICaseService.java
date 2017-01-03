package com.smu.service;

import java.util.List;

import com.smu.model.Case;

public interface ICaseService {
public List getCases(int st_id);
public Case getOneCase(int c_id);
public int addCase(Case c);
public boolean deleteCase(int c_id);
}
