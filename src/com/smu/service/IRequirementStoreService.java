package com.smu.service;

import com.smu.model.RequirementStore;;

public interface IRequirementStoreService {
public RequirementStore getAllRequirements(int c_id);
public boolean addRequirement(RequirementStore r);
public boolean updateRequirement(RequirementStore r);
public boolean deleteRequirement(int c_id);
    public RequirementStore getOneRequirementStore(int r_id);
    public boolean updateStoreErrors(int r_id,String errors);
    public boolean updateRequirementStore(int RId,String RName,String RContent,String RScore,String errors);
}
