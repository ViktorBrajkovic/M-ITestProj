package com.example.demo.controller;

import com.example.demo.model.Roba;
import com.example.demo.repository.RobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/roba")
public class RobaController {
    private RobaRepository repository;

    @Autowired
    public RobaController(RobaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Roba> returnRoba(@PathVariable Long id) {
        Optional<Roba> roba = repository.findById(id);
        return new ResponseEntity<>(roba.get(), HttpStatus.OK);
    }

    @PostMapping( value = "/create")
    public ResponseEntity<Roba> createRoba(@RequestBody Roba roba) {
      repository.save(roba);
      Optional<Roba> novaRoba = repository.findById(roba.getId());
      return new ResponseEntity<Roba>(novaRoba.get(),HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Roba> deleteRoba(@PathVariable Long id) {
        Optional<Roba> deleteRoba = repository.findById(id);
        repository.deleteById(id);
        return new ResponseEntity<Roba>(deleteRoba.get(),HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Roba> updateRoba(@RequestBody Roba roba) {
        Roba updateRoba = repository.save(roba);
        return new ResponseEntity<Roba>(updateRoba,HttpStatus.OK);
    }

}
