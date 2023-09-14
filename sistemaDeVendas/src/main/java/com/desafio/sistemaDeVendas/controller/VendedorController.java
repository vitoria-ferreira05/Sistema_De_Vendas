package com.desafio.sistemaDeVendas.controller;

import com.desafio.sistemaDeVendas.exceptions.VendedorNaoEncontradoException;
import com.desafio.sistemaDeVendas.model.Vendedor;
import com.desafio.sistemaDeVendas.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    private final VendedorService vendedorService;

    @Autowired
    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @PostMapping
    public Vendedor adicionarVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.adiconarVendedor(vendedor);
    }

    @GetMapping
    public List<Vendedor> buscarVendedores() {
        return vendedorService.buscarVendedores();
    }

    @GetMapping("/{id}")
    public Vendedor buscarVendedorPeloId(@PathVariable Long id) throws VendedorNaoEncontradoException {
        return vendedorService.buscarVendedorPeloId(id);
    }

    @PutMapping("/{id}")
    public Vendedor atualizarVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) throws VendedorNaoEncontradoException {
        return vendedorService.atualizarVendedor(id, vendedor);
    }

    @DeleteMapping("/{id}")
    public void deletarVendedorPeloId(@PathVariable Long id) {
        vendedorService.deletarVendedorPeloId(id);
    }
}
