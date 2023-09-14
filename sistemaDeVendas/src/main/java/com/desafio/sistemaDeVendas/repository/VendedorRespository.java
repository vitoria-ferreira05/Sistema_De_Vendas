package com.desafio.sistemaDeVendas.repository;

import com.desafio.sistemaDeVendas.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRespository extends JpaRepository<Vendedor, Long> {

}
