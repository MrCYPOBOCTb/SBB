package com.SBB.entity;

import javax.persistence.*;

@Entity
@Table(name = "haltestelle")
@NamedQuery(name = "Haltestelle.getAll", query = "SELECT c from HaltestellePO c")
public class HaltestellePO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name = "Uic")
    private long Uic;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Bemerkung")
    private String Bemerkung;

    public HaltestellePO(long Uic, String Name, String Bemerkung) {
        this.Uic = Uic;
        this.Name = Name;
        this.Bemerkung = Bemerkung;
    }

    public HaltestellePO() {
    }

    public long getUIC_CODE() {
        return Uic;
    }

    public void setUIC_CODE(long uic) {
        this.Uic = uic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getBemerkung() {
        return Bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.Bemerkung = bemerkung;
    }

    public long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "HaltestellePO{" +
                "id=" + Id +
                "Uic=" + Uic +
                "Name=" + Name + '}';
    }
}
