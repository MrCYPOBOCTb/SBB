package com.SBB.aervice;

import java.util.List;

import com.SBB.entity.HaltestellePO;

public interface HaltService {
    HaltestellePO add(HaltestellePO haltestellePO) throws Exception;

    void delete(long id);

    HaltestellePO get(long id);

    void update(HaltestellePO haltestellePO) throws Exception;

    List<HaltestellePO> getAll();
}
