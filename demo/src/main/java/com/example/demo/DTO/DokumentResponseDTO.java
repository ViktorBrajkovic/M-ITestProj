package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DokumentResponseDTO {


    private Long id;

    private String naziv;

    private int iznos;

    private List<DokumentStavkaResponseDokDTO> stavke = new ArrayList<>();

    public DokumentResponseDTO() {

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

    public List<DokumentStavkaResponseDokDTO> getStavke() {
        return stavke;
    }

    public void setStavke(List<DokumentStavkaResponseDokDTO> stavke) {
        this.stavke = stavke;
    }
}
