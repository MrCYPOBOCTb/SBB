package com.SBB.spring;

import com.SBB.aervice.FahrplanService;
import com.SBB.aervice.HaltService;
import com.SBB.aervice.ZugService;
import com.SBB.entity.FahrplanPO;
import com.SBB.entity.HaltestellePO;

import java.util.List;

import com.SBB.entity.ZugPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class Rest {
    @Autowired
    HaltService haltService;
    /*@Autowired*/
    ZugService zugService;
    @Autowired
    FahrplanService fahrplanService;

    /*---------------------------------Haltestelle---------------------------------*/

    //List all Haltestelle
    @RequestMapping(value = "/haltestelle/", method = RequestMethod.GET)
    public ResponseEntity<List<HaltestellePO>> getAllHaltestelle() {
        List<HaltestellePO> haltestellePOList = haltService.getAll();
        if (haltService.getAll().isEmpty()) {
            return new ResponseEntity<List<HaltestellePO>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<HaltestellePO>>(haltestellePOList, HttpStatus.OK);
    }

    //Create new Haltestelle
    @RequestMapping(value = "/haltestelle/", method = RequestMethod.POST)
    public ResponseEntity<Void> addHaltestelle(@RequestBody HaltestellePO haltestellePO, UriComponentsBuilder ucBuilder) {
        boolean success = true;
        System.out.println("Creating Haltestelle" + haltestellePO.getName());
        try {
            haltService.add(haltestellePO);
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        if (success == true) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/haltestelle/{id}").buildAndExpand(haltestellePO.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete Haltestelle
    @RequestMapping(value = "/haltestelle/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteHaltestelle(@PathVariable("id") long id) {
        System.out.println("Deleting Haltestelle " + id);
        HaltestellePO haltestellePO = haltService.get(id);
        if (haltestellePO == null) {
            System.out.println("Haltestelle with id " + id + " not found");
        }
        haltService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //Update Haltestelle
    @RequestMapping(value = "/haltestelle/{id}", method = RequestMethod.PUT)
    public ResponseEntity<HaltestellePO> updateHaltestelle(@PathVariable("id") long id, @RequestBody HaltestellePO haltestellePO) {
        boolean success = true;
        System.out.println("Updating Haltestelle " + id);

        HaltestellePO currentHalt = haltService.get(id);

        if (currentHalt == null) {
            System.out.println("Haltestelle with id " + id + " not found");
            return new ResponseEntity<HaltestellePO>(HttpStatus.NOT_FOUND);
        }

        currentHalt.setName(haltestellePO.getName());
        currentHalt.setUIC_CODE(haltestellePO.getUIC_CODE());
        currentHalt.setBemerkung(haltestellePO.getBemerkung());

        try {
            haltService.update(currentHalt);
        } catch (Exception e) {

            e.printStackTrace();
            success = false;
        }
        if (success == true) {

            return new ResponseEntity<HaltestellePO>(currentHalt, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*---------------------------------Fahrplan---------------------------------*/
    //List all Fahrplaene
    @RequestMapping(value = "/fahrplan/", method = RequestMethod.GET)
    public ResponseEntity<List<FahrplanPO>> getAllFahrplaene() {
        List<FahrplanPO> fahrplanPOS = fahrplanService.getAll();
        if (fahrplanService.getAll().isEmpty()) {
            return new ResponseEntity<List<FahrplanPO>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<FahrplanPO>>(fahrplanPOS, HttpStatus.OK);
    }

    //Create new Fahrplan
    @RequestMapping(value = "/fahrplan/", method = RequestMethod.POST)
    public ResponseEntity<Void> addFahplan(@RequestBody FahrplanPO fahrplanPO, UriComponentsBuilder ucBuilder) {

        HaltestellePO haltestellePO = haltService.get(fahrplanPO.getHaltesetelleID());
        ZugPO zugPO = zugService.get(fahrplanPO.getZugID());
        System.out.println("Creating new Fahrplan for Halt " + haltestellePO.getName() + " and Zug " + zugPO.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/fahrplan/{id}").buildAndExpand(fahrplanPO.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    /*---------------------------------Angebot---------------------------------*/
}