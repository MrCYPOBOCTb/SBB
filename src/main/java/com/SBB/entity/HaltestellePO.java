package com.SBB.entity;

import javax.persistence.*;

@Entity
@Table(name = "haltestelle")
@NamedQueries({
        @NamedQuery(name = "Haltestelle.getAll", query = "SELECT c from HaltestellePO c"),
        @NamedQuery(name = "Haltestelle.getHaltByUic", query = "SELECT c from HaltestellePO c WHERE c.uic = :uic")
})
public class HaltestellePO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "uic")
    private long uic;
    @Column(name = "name")
    private String name;
    @Column(name = "bemerkung")
    private String bemerkung;

    public HaltestellePO(long uic, String name, String bemerkung) {
        this.uic = uic;
        this.name = name;
        this.bemerkung = bemerkung;
    }

    public HaltestellePO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUic() {
        return uic;
    }

    public void setUic(long uic) {
        this.uic = uic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    @Override
    public String toString() {
        return "HaltestellePO{" +
                "id=" + id +
                "uic=" + uic +
                "name=" + name + '}';
    }
}
