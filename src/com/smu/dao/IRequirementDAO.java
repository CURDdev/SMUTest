package com.smu.dao;
import java.util.List;

import com.smu.model.Requirement;
public interface IRequirementDAO {
public Requirement getAllRequirements(String c_name);
public boolean addRequirement(Requirement r);
public boolean updateRequirement(Requirement r);
public boolean deleteRequirement(String c_name);
}
