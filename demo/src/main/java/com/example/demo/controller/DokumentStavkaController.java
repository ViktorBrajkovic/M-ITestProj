package com.example.demo.controller;

import com.example.demo.DTO.DokumentStavkaResponseDTO;
import com.example.demo.DTO.DokumentStavkaResponseDokDTO;
import com.example.demo.model.DokumentStavka;
import com.example.demo.repository.DokumentRepository;
import com.example.demo.repository.DokumentStavkaRepository;
import com.example.demo.repository.RobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/stavka")
public class DokumentStavkaController {

    private DokumentStavkaRepository repository;
    private RobaRepository robaRepository;
    private DokumentRepository dokumentRrepository;

    @Autowired
    public DokumentStavkaController(DokumentStavkaRepository repository , RobaRepository robaRepository ,DokumentRepository dokumentRrepository) {
        this.repository = repository;
        this.robaRepository=robaRepository;
        this.dokumentRrepository=dokumentRrepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> returnStavka(@PathVariable Long id) {
        Optional<DokumentStavka> stavka = repository.findById(id);
        if(stavka.isPresent()) {
            DokumentStavkaResponseDokDTO returnStavka = new DokumentStavkaResponseDokDTO();
            returnStavka.setId(stavka.get().getId());
            returnStavka.setCena(stavka.get().getCena());
            returnStavka.setKolicina(stavka.get().getKolicina());
            returnStavka.setDokument_id(stavka.get().getDokument().getId());
            returnStavka.setRoba(robaRepository.findById(stavka.get().getRoba().getId()));

            return ResponseEntity.ok(returnStavka);
        }
        return  ResponseEntity.badRequest().build();
    }

    @PostMapping( value = "/create")
    public ResponseEntity<?> createStavka(@RequestBody DokumentStavkaResponseDTO stavkaDTD) {
        DokumentStavka stavka = new DokumentStavka();

        DokumentStavkaResponseDokDTO newStavkaDTD = new DokumentStavkaResponseDokDTO();

        stavka.setId(stavkaDTD.getId());
        stavka.setCena(stavkaDTD.getCena());
        stavka.setKolicina(stavkaDTD.getKolicina());
        stavka.setRoba(robaRepository.findById(stavkaDTD.getRoba_id()));
        stavka.setDokument(dokumentRrepository.findById(stavkaDTD.getDokument_id()));

        System.out.print(stavka.getRoba().getNaziv());
        System.out.print(stavka.getRoba().getId());

        repository.save(stavka);

        newStavkaDTD.setId(stavka.getId());
        newStavkaDTD.setCena(stavka.getCena());
        newStavkaDTD.setKolicina(stavka.getKolicina());
        newStavkaDTD.setDokument_id(stavkaDTD.getDokument_id());
        newStavkaDTD.setRoba(robaRepository.findById(stavkaDTD.getRoba_id()));


        return new ResponseEntity<>(newStavkaDTD, HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteStavka(@PathVariable Long id) {

        Optional<DokumentStavka> stavka = repository.findById(id);

        repository.deleteById(id);

        DokumentStavkaResponseDokDTO deleteStavka = new DokumentStavkaResponseDokDTO();
        deleteStavka.setId(stavka.get().getId());
        deleteStavka.setCena(stavka.get().getCena());
        deleteStavka.setKolicina(stavka.get().getKolicina());
        deleteStavka.setDokument_id(stavka.get().getDokument().getId());
        deleteStavka.setRoba(robaRepository.findById(stavka.get().getRoba().getId()));
        return new ResponseEntity<>(deleteStavka, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateStavka(@RequestBody DokumentStavkaResponseDTO stavkaDTD) {

        DokumentStavka stavka = new DokumentStavka();

        stavka.setId(stavkaDTD.getId());
        stavka.setCena(stavkaDTD.getCena());
        stavka.setKolicina(stavkaDTD.getKolicina());
        stavka.setRoba(robaRepository.findById(stavkaDTD.getRoba_id()));
        stavka.setDokument(dokumentRrepository.findById(stavkaDTD.getDokument_id()));

        repository.save(stavka);

        DokumentStavkaResponseDokDTO updateStavkaDTO = new DokumentStavkaResponseDokDTO();

        updateStavkaDTO.setId(stavka.getId());
        updateStavkaDTO.setCena(stavka.getCena());
        updateStavkaDTO.setKolicina(stavka.getKolicina());
        updateStavkaDTO.setDokument_id(stavkaDTD.getDokument_id());
        updateStavkaDTO.setRoba(robaRepository.findById(stavkaDTD.getRoba_id()));
        updateStavkaDTO.setRoba(robaRepository.findById(stavka.getRoba().getId()));

        return new ResponseEntity<>(updateStavkaDTO, HttpStatus.OK);
    }
}
