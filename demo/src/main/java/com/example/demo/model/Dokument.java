package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Dokument {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String naziv;

    @Column
    private int iznos;

    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "dokument")
    private List<DokumentStavka> stavke = new ArrayList<>();

    public Dokument() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public List<DokumentStavka> getStavke() {
        return stavke;
    }

    public void setStavke(List<DokumentStavka> stavke) {
        this.stavke = stavke;
    }


}
