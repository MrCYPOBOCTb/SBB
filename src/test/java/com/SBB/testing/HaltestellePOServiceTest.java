/*
package com.SBB.testing;

import com.SBB.entity.HaltestellePO;
import com.SBB.Service.Halt_Service;
import org.junit.Test;

import java.util.List;

public class HaltestellePOServiceTest {
    Halt_Service service = new Halt_Service();

    @Test
    public void testSaveRecord() throws Exception {
        HaltestellePO halt = new HaltestellePO();
        halt.setName("Rapperswil");
        halt.setUIC_CODE(8503110);
        halt.setBemerkung("HaltestellePO input testing");
        HaltestellePO haltestellePO = service.add(halt);
        System.out.println(haltestellePO);
    }

    @Test
    public void testDeleteRecord() throws Exception {
        HaltestellePO halt1 = new HaltestellePO();
        halt1.setName("Otelfingen");
        halt1.setUIC_CODE(8503525);
        halt1.setBemerkung("HaltestellePO delete testing");
        HaltestellePO haltestellePO = service.add(halt1);
        HaltestellePO haltFromDB = service.get(haltestellePO.getId());
        service.delete(haltFromDB.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        HaltestellePO halt1 = new HaltestellePO();
        halt1.setName("Arth-Goldau");
        halt1.setUIC_CODE(8505004);
        halt1.setBemerkung("HaltestellePO update testing");
        halt1 = service.add(halt1);
        halt1.setBemerkung("Updated");
        service.update(halt1);
        HaltestellePO haltestellePO = service.get(halt1.getId());
        System.out.println(haltestellePO);

    }

    @Test
    public void testGetAll() {
        List<HaltestellePO> haltestellePOList = service.getAll();
        if (haltestellePOList.isEmpty()) {
            System.out.println("Haltestelle-List is empty");
            HaltestellePO halt1 = new HaltestellePO();
            halt1.setName("Zurich");
            halt1.setUIC_CODE(8503000);
            HaltestellePO halt2 = new HaltestellePO();
            halt2.setName("Bern");
            halt2.setUIC_CODE(8507000);
            HaltestellePO halt3 = new HaltestellePO();
            halt3.setName("Genf Airport");
            halt3.setUIC_CODE(8501026);
            service.add(halt1);
            service.add(halt2);
            service.add(halt3);
            haltestellePOList = service.getAll();
        }
        for (HaltestellePO c : haltestellePOList) {
            System.out.println(c);

        }
    }
}
*/
