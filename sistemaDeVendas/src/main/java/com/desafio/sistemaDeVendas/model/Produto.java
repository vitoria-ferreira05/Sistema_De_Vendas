package com.desafio.sistemaDeVendas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduto;
    @Column(name = "nomeProduto")
    private String nomeProduto;
    @Column(name = "precoProduto")
    private double precoProduto;
    @Column(name = "qtdProduto")
    private int qtdProduto;
    @Column(name = "valorTotal")
    private double valorTotal;

    @PrePersist
    @PreUpdate
    public void calcularValorTotal() {
        this.valorTotal = this.precoProduto * this.qtdProduto;
    }

    public Long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
