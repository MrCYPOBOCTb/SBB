package com.SBB.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "halt_x_zug")
@NamedQuery(name = "Fahrplan.getAll", query = "SELECT c from FahrplanPO c")
public class FahrplanPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Haltestelle_ID")
    private long HaltesetelleID;
    @Column(name = "Zug_ID")
    private long ZugID;
    @Column(name = "Zeit")
    private Time Zeit;
    @Column(name = "Bemerkung")
    private String Bemerkung;

    public FahrplanPO(long haltID,long zugID, Time zeit, String bemerkung){
        this.HaltesetelleID=haltID;
        this.ZugID=zugID;
        this.Zeit=zeit;
        this.Bemerkung=bemerkung;
    }
    public FahrplanPO(){}

    public long getId() {
        return id;
    }

    public long getHaltesetelleID() {
        return HaltesetelleID;
    }

    public void setHaltesetelleID(long haltesetelleID) {
        this.HaltesetelleID = haltesetelleID;
    }

    public long getZugID() {
        return ZugID;
    }

    public void setZugID(long zugID) {
        this.ZugID = zugID;
    }

    public Time getZeit() {
        return Zeit;
    }

    public void setZeit(Time zeit) {
        this.Zeit = zeit;
    }

    public String getBemerkung() {
        return Bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.Bemerkung = bemerkung;
    }

    @Override
    public String toString() {
        return "FahrplanPO{" +
                "id=" + id +
                "HaltestelleID=" + HaltesetelleID +
                "ZugID=" + ZugID +
                "Zeit=" + Zeit +
                '}';
    }
}