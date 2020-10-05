package com.sicredi.assembleia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicredi.assembleia.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {

}
