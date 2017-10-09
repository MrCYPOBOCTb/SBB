package com.SBB.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reisender")
@NamedQuery(name = "Reisender.getAll", query = "SELECT c from ReisenderPO c")
public class ReisenderPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Name")
    private String reisenderName;
    @Column(name = "Vorname")
    private String reisenderVorname;
    @Column(name = "Geburtsdatum")
    private Date geburtsDatum;
    @Column(name = "Bemerkung")
    private String bemerkung;

    public ReisenderPO() {
    }

    public ReisenderPO(String name, String vorname, Date geburtsdatum, String bemerkung) {
        this.reisenderName = name;
        this.reisenderVorname = vorname;
        this.geburtsDatum = geburtsdatum;
        this.bemerkung = bemerkung;
    }

    public long getId() {
        return id;
    }

    public String getReisenderName() {
        return reisenderName;
    }

    public void setReisenderName(String reisenderName) {
        this.reisenderName = reisenderName;
    }

    public String getReisenderVorname() {
        return reisenderVorname;
    }

    public void setReisenderVorname(String reisenderVorname) {
        this.reisenderVorname = reisenderVorname;
    }

    public Date getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    @Override
    public String toString() {
        return "ReisenderPO{" +
                "id=" + id +
                "Name=" + reisenderName +
                "Vorame=" + reisenderVorname +
                "Geburtsdatum=" + geburtsDatum +
                '}';
    }
}
