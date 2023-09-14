package com.desafio.sistemaDeVendas.service;

import com.desafio.sistemaDeVendas.exceptions.ProdutoNaoEncontradoException;
import com.desafio.sistemaDeVendas.model.Produto;
import com.desafio.sistemaDeVendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutosPeloId(Long id) throws ProdutoNaoEncontradoException {
        return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado pelo id " + id));
    }

    public Produto atualizarProduto(Long id, Produto produto) throws ProdutoNaoEncontradoException {
        Produto existeProduto = produtoRepository.findById(id).orElse(produto);

        if (existeProduto != null) {
            existeProduto.setNomeProduto(produto.getNomeProduto());
            existeProduto.setPrecoProduto(produto.getPrecoProduto());
            existeProduto.setQtdProduto(produto.getQtdProduto());
            existeProduto.calcularValorTotal();

            return produtoRepository.save(existeProduto);
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado pelo id " + id);
        }
    }

    public void deletarProdutoPeloId(Long id) {
        produtoRepository.deleteById(id);
    }
}
