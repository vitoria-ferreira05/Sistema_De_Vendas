package com.desafio.sistemaDeVendas.service;

import com.desafio.sistemaDeVendas.exceptions.ClienteNaoEncontradoException;
import com.desafio.sistemaDeVendas.model.Cliente;
import com.desafio.sistemaDeVendas.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente adicionarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodosClientes(){
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePeloId(Long id) throws ClienteNaoEncontradoException {
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException ("Cliente não encontrado pelo id: " + id));
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) throws ClienteNaoEncontradoException {
        Cliente existeCliente = clienteRepository.findById(id).orElse(cliente);

       if (existeCliente != null){
           existeCliente.setNome(cliente.getNome());
           existeCliente.setEmail(cliente.getEmail());
           existeCliente.setCpf(cliente.getCpf());
           existeCliente.setEndereco(cliente.getEndereco());
           return clienteRepository.save(existeCliente);
       }else {
           throw new ClienteNaoEncontradoException("Cliente não encontrado com o id " + id);
       }
    }

    public void deletarClientePeloId(Long id){
        clienteRepository.deleteById(id);
    }
}
