package com.example.demo.controller;

import com.example.demo.DTO.DokumentResponseDTO;
import com.example.demo.DTO.DokumentStavkaResponseDTO;
import com.example.demo.DTO.DokumentStavkaResponseDokDTO;
import com.example.demo.model.Dokument;
import com.example.demo.model.DokumentStavka;
import com.example.demo.repository.DokumentRepository;
import com.example.demo.repository.RobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/dokument")
public class DokumentController {

    private DokumentRepository repository;
    private RobaRepository robaRepository;

    @Autowired
    public DokumentController(DokumentRepository repository,RobaRepository robaRepository) {
        this.repository = repository;
        this.robaRepository=robaRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> returnDokument(@PathVariable Long id) {

        Optional<Dokument> doc = repository.findById(id);
        DokumentResponseDTO newDokDTO = new DokumentResponseDTO();

        newDokDTO.setId(doc.get().getId());
        newDokDTO.setNaziv(doc.get().getNaziv());
        newDokDTO.setIznos(doc.get().getIznos());

        List<DokumentStavkaResponseDokDTO> stavkeDTO = new ArrayList<>();

        for(DokumentStavka ds : doc.get().getStavke())
        {
            stavkeDTO.add(new DokumentStavkaResponseDokDTO());
        }

        for(int i=0;i<doc.get().getStavke().size();i++)
        {
            stavkeDTO.get(i).setId(doc.get().getStavke().get(i).getId());
            stavkeDTO.get(i).setKolicina(doc.get().getStavke().get(i).getKolicina());
            stavkeDTO.get(i).setCena(doc.get().getStavke().get(i).getCena());
            stavkeDTO.get(i).setDokument_id(doc.get().getId());
            stavkeDTO.get(i).setRoba(robaRepository.findById(doc.get().getStavke().get(i).getRoba().getId()));
        }

        newDokDTO.setStavke(stavkeDTO);

        return new ResponseEntity<>(newDokDTO, HttpStatus.OK);
    }

    @PostMapping( value = "/create")
    public  ResponseEntity<?> createDokument(@RequestBody DokumentResponseDTO doc) {

        Dokument newDoc = new Dokument();

        newDoc.setIznos(doc.getIznos());
        newDoc.setNaziv(doc.getNaziv());

        repository.save(newDoc);

        return new ResponseEntity<>(newDoc, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public  ResponseEntity<?> deleteDokument(@PathVariable Long id) {

        Optional<Dokument> doc = repository.findById(id);
        DokumentResponseDTO deleteDokDTO = new DokumentResponseDTO();

        deleteDokDTO.setId(doc.get().getId());
        deleteDokDTO.setNaziv(doc.get().getNaziv());
        deleteDokDTO.setIznos(doc.get().getIznos());

        List<DokumentStavkaResponseDokDTO> stavkeDTO = new ArrayList<>();

        for(DokumentStavka ds : doc.get().getStavke())
        {
            stavkeDTO.add(new DokumentStavkaResponseDokDTO());
        }

        for(int i=0;i<doc.get().getStavke().size();i++)
        {
            stavkeDTO.get(i).setId(doc.get().getStavke().get(i).getId());
            stavkeDTO.get(i).setKolicina(doc.get().getStavke().get(i).getKolicina());
            stavkeDTO.get(i).setCena(doc.get().getStavke().get(i).getCena());
            stavkeDTO.get(i).setDokument_id(doc.get().getId());
            stavkeDTO.get(i).setRoba(robaRepository.findById(doc.get().getStavke().get(i).getRoba().getId()));
        }

        deleteDokDTO.setStavke(stavkeDTO);

        repository.deleteById(id);
        return new ResponseEntity<>(deleteDokDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public  ResponseEntity<?> updateDokument(@RequestBody DokumentResponseDTO doc) {

        Optional<Dokument> updatedDoc = repository.findById(doc.getId());

        updatedDoc.get().setNaziv(doc.getNaziv());
        updatedDoc.get().setIznos(doc.getIznos());

        repository.save(updatedDoc.get());

        DokumentResponseDTO updatedDocDTO = new DokumentResponseDTO();

        updatedDocDTO.setId(updatedDoc.get().getId());
        updatedDocDTO.setNaziv(updatedDoc.get().getNaziv());
        updatedDocDTO.setIznos(updatedDoc.get().getIznos());


        List<DokumentStavkaResponseDokDTO> stavke = new ArrayList<>();

        for(DokumentStavka ds : updatedDoc.get().getStavke())
        {
            stavke.add(new DokumentStavkaResponseDokDTO());
        }

        for(int i=0;i<stavke.size();i++)
        {
            stavke.get(i).setId(updatedDoc.get().getStavke().get(i).getId());
            stavke.get(i).setKolicina(updatedDoc.get().getStavke().get(i).getKolicina());
            stavke.get(i).setCena(updatedDoc.get().getStavke().get(i).getCena());
            stavke.get(i).setDokument_id(updatedDoc.get().getId());
            stavke.get(i).setRoba(robaRepository.findById(updatedDoc.get().getStavke().get(i).getRoba().getId()));
        }

        updatedDocDTO.setStavke(stavke);

        return new ResponseEntity<>(updatedDocDTO, HttpStatus.OK);
    }

}

