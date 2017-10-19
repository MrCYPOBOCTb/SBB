package com.SBB.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "HALT_X_ZUG")
@NamedQueries({
@NamedQuery(name = "Fahrplan.getAll", query = "SELECT c from FahrplanPO c"),
@NamedQuery(name = "Fahrplan.getFahrplanByZug", query="SELECT c FROM FahrplanPO c WHERE c.zugID = :zug")
})
public class FahrplanPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "HALTESTELLE_ABGANG")
    private long haltesetelleAbgang;
    @Column(name = "HALTESTELLE_BESTIMMUNG")
    private long haltesetelleBestimmung;
    @Column(name = "Zug_ID")
    private long zugID;
    @Column(name = "ZEIT_ABGANG")
    private Time zeitAbgang;
    @Column(name = "ZEIT_BESTIMMUNG")
    private Time zeitBestimmung;
    @Column(name = "REIHENFOLGE")
    private long reihenfolge;
    @Column(name = "Bemerkung")
    private String bemerkung;

    public FahrplanPO(long haltAbgang, long haltBestimmung, long zugID, Time zeitAbgang, Time zeitBestimmung, long reihenfolge, String bemerkung) {
        this.haltesetelleAbgang = haltAbgang;
        this.haltesetelleBestimmung = haltBestimmung;
        this.zugID = zugID;
        this.zeitAbgang = zeitAbgang;
        this.zeitBestimmung = zeitBestimmung;
        this.reihenfolge = reihenfolge;
        this.bemerkung = bemerkung;
    }

    public FahrplanPO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHaltesetelleAbgang() {
        return haltesetelleAbgang;
    }

    public void setHaltesetelleAbgang(long haltesetelleAbgang) {
        this.haltesetelleAbgang = haltesetelleAbgang;
    }

    public long getHaltesetelleBestimmung() {
        return haltesetelleBestimmung;
    }

    public void setHaltesetelleBestimmung(long haltesetelleBestimmung) {
        this.haltesetelleBestimmung = haltesetelleBestimmung;
    }

    public long getZugID() {
        return zugID;
    }

    public void setZugID(long zugID) {
        this.zugID = zugID;
    }

    public Time getZeitAbgang() {
        return zeitAbgang;
    }

    public void setZeitAbgang(Time zeitAbgang) {
        this.zeitAbgang = zeitAbgang;
    }

    public Time getZeitBestimmung() {
        return zeitBestimmung;
    }

    public void setZeitBestimmung(Time zeitBestimmung) {
        this.zeitBestimmung = zeitBestimmung;
    }

    public long getReihenfolge() {
        return reihenfolge;
    }

    public void setReihenfolge(long reihenfolge) {
        this.reihenfolge = reihenfolge;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    @Override
    public String toString() {
        return "FahrplanPO{" +
                "id=" + id +
                "HaltestelleAbgang=" + haltesetelleAbgang +
                "HaltestelleBestimmung=" + haltesetelleBestimmung+
                "ZugID=" + zugID +
                "ZeitAbgang=" + zeitAbgang+
                "ZeitBestimmung=" + zeitBestimmung+
                '}';
    }
}