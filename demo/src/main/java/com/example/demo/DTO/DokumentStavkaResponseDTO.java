package com.example.demo.DTO;

public class DokumentStavkaResponseDTO {

    private Long id;

    private int kolicina;

    private int cena;

    private Long dokument_id;

    private Long  roba_id;

    public DokumentStavkaResponseDTO() {
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

    public Long getRoba_id() {
        return roba_id;
    }

    public void setRoba_id(Long roba_id) {
        this.roba_id = roba_id;
    }

}
