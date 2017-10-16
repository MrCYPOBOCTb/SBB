package com.SBB.aervice;

import com.SBB.entity.AngebotPO;

import java.util.List;

public interface AngebotService {

    /*private long Id;
    private long Reisender;
    private long Zug;
    private String Bemerkung;*/

    AngebotPO addAngebot(AngebotPO angebotPO) throws Exception;
    AngebotPO get(long id);
    void deleteAngebot(long id) throws Exception;
    List<AngebotPO> getAll();

}
