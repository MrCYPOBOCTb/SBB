package com.SBB.aervice;

import com.SBB.entity.ZugPO;

import java.util.List;

public interface ZugService{
    ZugPO get(long id);
    ZugPO add(ZugPO zugPO);
    void delete(long id);
    void update(ZugPO zugPO);
    List<ZugPO> getAll();

}

