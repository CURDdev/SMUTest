package com.smu.dao;
import java.util.List;

import com.smu.model.RequirementStore;
public interface IRequirementStoreDAO {
public RequirementStore getAllRequirements(int c_id);
public boolean addRequirement(RequirementStore r);
public boolean updateRequirement(RequirementStore r);
public boolean deleteRequirement(int c_id);
}
