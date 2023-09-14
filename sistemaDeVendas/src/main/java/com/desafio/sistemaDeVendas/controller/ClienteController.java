package com.desafio.sistemaDeVendas.controller;

import com.desafio.sistemaDeVendas.exceptions.ClienteNaoEncontradoException;
import com.desafio.sistemaDeVendas.model.Cliente;
import com.desafio.sistemaDeVendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return clienteService.adicionarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> bustarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePeloId(@PathVariable Long id) throws ClienteNaoEncontradoException {
        return clienteService.buscarClientePeloId(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) throws ClienteNaoEncontradoException {
        return clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarClientePeloId(@PathVariable Long id) {
        clienteService.deletarClientePeloId(id);
    }
}
