package com.SBB.entity;

import javax.persistence.*;

@Entity
@Table(name = "zug")
@NamedQueries({
@NamedQuery(name = "Zug.getAll", query = "SELECT c from ZugPO c"),
@NamedQuery(name = "Zug.getZugByBezeichnung", query="SELECT c FROM ZugPO c WHERE c.Bemerkung = :bemerkung")})
public class ZugPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name = "platz", length = 7)
    private int Platz;
    @Column(name = "Bemerkung")
    private String Bemerkung;

    public ZugPO() {
    }
    public ZugPO(int platz,String bemerkung){
        this.Platz=platz;
        this.Bemerkung=bemerkung;
    }

    public long getId() {
        return Id;
    }

    public int getPlatz() {
        return Platz;
    }

    public void setPlatz(int platz) {
        this.Platz = platz;
    }

    public String getBemerkung() {
        return Bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.Bemerkung = bemerkung;
    }

    @Override
    public String toString() {
        return "HaltestellePO{" +
                "id=" + Id +
                "Platz=" + Platz +
                "}";
    }
}