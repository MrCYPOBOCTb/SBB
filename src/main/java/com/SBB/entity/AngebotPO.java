package com.SBB.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table (name="ANGEBOT")
@NamedQuery(name = "Angebot.getAll", query = "SELECT c from AngebotPO c")
public class AngebotPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (name ="HALTESTELLE_ABGANG")
    private long angebotHaltestelleAbgang;
    @Column (name ="HALTESTELLE_BESTIMMUNG")
    private long angebotHaltestelleBestimmung;
    @Column (name = "ZUG_ID")
    private long zugID;
    @Column (name = "ZEIT_ABGANG")
    private Time angebotZeitAbgang;
    @Column (name = "REISENDER")
    private long angebotReisender;
    @Column (name = "Bemerkung")
    private String bemerkung;

    public AngebotPO(){}
    public AngebotPO(long angebotHaltestelleAbgang, long angebotHaltestelleBestimmung, long zugID,
                     Time angebotZeitAbgang, long angebotReisender, String bemerkung){
        this.angebotHaltestelleAbgang=angebotHaltestelleAbgang;
        this.angebotHaltestelleBestimmung=angebotHaltestelleBestimmung;
        this.zugID=zugID;
        this.angebotZeitAbgang=angebotZeitAbgang;
        this.angebotReisender=angebotReisender;
        this.bemerkung=bemerkung;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAngebotHaltestelleAbgang() {
        return angebotHaltestelleAbgang;
    }

    public void setAngebotHaltestelleAbgang(long angebotHaltestelleAbgang) {
        this.angebotHaltestelleAbgang = angebotHaltestelleAbgang;
    }

    public long getAngebotHaltestelleBestimmung() {
        return angebotHaltestelleBestimmung;
    }

    public void setAngebotHaltestelleBestimmung(long angebotHaltestelleBestimmung) {
        this.angebotHaltestelleBestimmung = angebotHaltestelleBestimmung;
    }

    public long getZugID() {
        return zugID;
    }

    public void setZugID(int zugID) {
        this.zugID = (long)zugID;
    }

    public Time getAngebotZeitAbgang() {
        return angebotZeitAbgang;
    }

    public void setAngebotZeitAbgang(Time angebotZeitAbgang) {
        this.angebotZeitAbgang = angebotZeitAbgang;
    }

    public long getAngebotReisender() {
        return angebotReisender;
    }

    public void setAngebotReisender(long angebotReisender) {
        this.angebotReisender = angebotReisender;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    @Override
    public String toString() {
        return "AngebotPO{" +
                "id=" + id +
                "angebotHaltestelleAbgang=" + angebotHaltestelleAbgang +
                "angebotHaltestelleBestimmung=" + angebotHaltestelleBestimmung +
                "zugID=" + zugID +
                "angebotZeitAbgang=" + angebotZeitAbgang +
                "reisender=" + angebotReisender +
                "bemerkung=" + bemerkung + '}';
    }
}