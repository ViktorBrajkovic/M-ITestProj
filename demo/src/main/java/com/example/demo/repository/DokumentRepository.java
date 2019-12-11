package com.example.demo.repository;

import com.example.demo.model.Dokument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DokumentRepository extends JpaRepository<Dokument, Long> {
}
