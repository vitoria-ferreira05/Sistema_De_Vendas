package com.desafio.sistemaDeVendas.service;

import com.desafio.sistemaDeVendas.exceptions.ClienteNaoEncontradoException;
import com.desafio.sistemaDeVendas.exceptions.VendedorNaoEncontradoException;
import com.desafio.sistemaDeVendas.model.Vendedor;
import com.desafio.sistemaDeVendas.repository.VendedorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {
    private final VendedorRespository vendedorRespository;

    @Autowired
    public VendedorService(VendedorRespository vendedorRespository) {
        this.vendedorRespository = vendedorRespository;
    }

    public Vendedor adiconarVendedor(Vendedor vendedor) {
        return vendedorRespository.save(vendedor);
    }

    public List<Vendedor> buscarVendedores() {
        return vendedorRespository.findAll();
    }

    public Vendedor buscarVendedorPeloId(Long id) throws VendedorNaoEncontradoException {
        return vendedorRespository.findById(id).orElseThrow(() -> new VendedorNaoEncontradoException("Vendedor não encontrado pelo id" + id));
    }

    public Vendedor atualizarVendedor(Long id, Vendedor vendedor) throws VendedorNaoEncontradoException {
        Vendedor existeVendedor = vendedorRespository.findById(id).orElse(vendedor);

        if (existeVendedor != null) {
            existeVendedor.setNome(vendedor.getNome());
            existeVendedor.setEmail(vendedor.getEmail());
            existeVendedor.setCpf(vendedor.getCpf());
            existeVendedor.setSalario(vendedor.getSalario());

            return vendedorRespository.save(existeVendedor);
        } else {
            throw new VendedorNaoEncontradoException("Vendedor não encontrado com o id " + id);
        }
    }

    public void deletarVendedorPeloId(Long id) {
        vendedorRespository.deleteById(id);
    }
}

