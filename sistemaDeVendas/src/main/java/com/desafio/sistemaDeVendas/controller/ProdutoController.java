package com.desafio.sistemaDeVendas.controller;

import com.desafio.sistemaDeVendas.exceptions.ProdutoNaoEncontradoException;
import com.desafio.sistemaDeVendas.model.Produto;
import com.desafio.sistemaDeVendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    @GetMapping
    public List<Produto> buscarProdutos() {
        return produtoService.buscarProdutos();
    }

    @GetMapping("/{id}")
    public Produto buscarProdutosPeloId(@PathVariable Long id) throws ProdutoNaoEncontradoException {
        return produtoService.buscarProdutosPeloId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) throws ProdutoNaoEncontradoException {
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProdutoPeloId(@PathVariable Long id) {
        produtoService.deletarProdutoPeloId(id);
    }
}
