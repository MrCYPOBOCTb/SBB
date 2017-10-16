package com.SBB.entity;

import javax.persistence.*;

@Entity
@Table(name = "reise")
@NamedQuery(name = "ReisePO.getAll", query = "SELECT c from ReisePO c")
public class ReisePO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name = "Zug_ID")
    private long ZugID;
    @Column(name = "Halt_ID")
    private long HaltestelleID;
    @Column(name = "Bemerkung")
    private String Bemerkung;

    public ReisePO() {

    }

    public ReisePO(long zugID, long haltestelleID, String bemerkung) {
        this.ZugID = zugID;
        this.HaltestelleID = haltestelleID;
        this.Bemerkung = bemerkung;
    }

    public long getId() {
        return Id;
    }

    public long getZugID() {
        return ZugID;
    }

    public void setZugID(long zugID) {
        this.ZugID = zugID;
    }

    public long getHaltestelleID() {
        return HaltestelleID;
    }

    public void setHaltestelleID(long haltestelleID) {
        this.HaltestelleID = haltestelleID;
    }

    public String getBemerkung() {
        return Bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.Bemerkung = bemerkung;
    }


    @Override
    public String toString() {
        return "ReisePO{" +
                "id=" + Id +
                "Zug=" + ZugID+
                "Haltestelle=" + HaltestelleID + '}';
    }
}
