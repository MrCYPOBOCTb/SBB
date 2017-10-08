package com.SBB.entity;
import com.sun.javafx.beans.IDProperty;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import javax.persistence.*;

@Entity
@Table (name="Angebot")
public class AngebotPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column (name ="Reisender_ID")
    private long Reisender;
    @Column (name ="Zug_ID")
    private long Zug;
    @Column (name = "Bemerkung")
    private String Bemerkung;

    public AngebotPO(){}
    public AngebotPO(long reisender, long zug, String bemerkung){
        this.Reisender=reisender;
        this.Zug=zug;
        this.Bemerkung=bemerkung;
    }
    public long getId(){
        return Id;
    }

    public long getReisender() {
        return Reisender;
    }

    public void setReisender(long reisender) {
        this.Reisender = reisender;
    }

    public long getZug() {
        return Zug;
    }

    public void setZug(long zug) {
        this.Zug = zug;

    }

    public String getBemerkung() {
        return Bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.Bemerkung = bemerkung;
    }
    @Override
    public String toString() {
        return "AngebotPO{" +
                "id=" + Id +
                "Reisender=" + Reisender+
                "Zug=" + Zug+ '}';
    }
}