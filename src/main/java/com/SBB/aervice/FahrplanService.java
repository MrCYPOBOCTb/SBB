package com.SBB.aervice;

import java.util.List;

import com.SBB.entity.FahrplanPO;

public interface FahrplanService {
    FahrplanPO addFahrplan (FahrplanPO fahrplanPO);
    FahrplanPO get(long id);
    void delete (long id);
    void update (FahrplanPO fahrplanPO);
    List<FahrplanPO> getAll();



}
