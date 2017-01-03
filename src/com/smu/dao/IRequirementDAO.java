package com.smu.dao;
import java.util.List;

import com.smu.model.Requirement;
public interface IRequirementDAO {
public Requirement getAllRequirements(int c_id);
public boolean addRequirement(Requirement r);
public boolean updateRequirement(Requirement r);
public boolean deleteRequirement(int c_id);
}
