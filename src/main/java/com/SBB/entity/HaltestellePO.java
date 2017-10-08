package com.SBB.entity;

import javax.persistence.*;

@Entity
@Table(name = "haltestelle")
@NamedQuery(name = "Haltestelle.getAll", query = "SELECT c from HaltestellePO c")
public class HaltestellePO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name = "uic", length = 7)
    private Integer UIC_CODE;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Bemerkung")
    private String Bemerkung;

    public HaltestellePO(Integer UIC_CODE, String Name, String Bemerkung) {
        this.UIC_CODE = UIC_CODE;
        this.Name = Name;
        this.Bemerkung = Bemerkung;
    }

    public HaltestellePO() {
    }

    public Integer getUIC_CODE() {
        return UIC_CODE;
    }

    public void setUIC_CODE(Integer uic_code) {
        this.UIC_CODE = uic_code;
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
                "UIC_CODE=" + UIC_CODE +
                "Name=" + Name + '}';
    }
}
