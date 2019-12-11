package com.example.demo.DTO;

import com.example.demo.model.Roba;

import java.util.Optional;

public class DokumentStavkaResponseDokDTO {

    private Long id;

    private int kolicina;

    private int cena;

    private Long dokument_id;

    private Optional<Roba> roba;

    public DokumentStavkaResponseDokDTO() {
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

    public Long getDokument_id() {
        return dokument_id;
    }

    public void setDokument_id(Long dokument_id) {
        this.dokument_id = dokument_id;
    }

    public Roba getRoba() {
        return this.roba.get();
    }

  /*  public void setRoba(Roba roba) {
        this.roba=roba;
    }
    */
    public void setRoba(Optional<Roba> byId) {
        this.roba=byId;
    }


   /* public void setRoba(Optional<Roba> byId) {
        this.roba=byId.get();
    }
    */
}
