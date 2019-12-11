package com.example.demo.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class DokumentStavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int kolicina;

    @Column
    private int cena;


    @ManyToOne
    @JoinColumn(name="dokument_id")
    private Dokument dokument;

    @OneToOne
    private Roba roba;

    public DokumentStavka() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Dokument getDokument() {
        return dokument;
    }

    public void setDokument(Dokument dokument) {
        this.dokument = dokument;
    }

    public Roba getRoba() {
        return this.roba;
    }

    public void setRoba(Roba roba) {
        this.roba = roba;
    }

    public void setRoba(Optional<Roba> byId) {
        this.roba=byId.get();
    }

    public void setDokument(Optional<Dokument> byId) {
        this.dokument=byId.get();
    }
}
