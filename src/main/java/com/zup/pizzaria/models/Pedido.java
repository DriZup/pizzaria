package com.zup.pizzaria.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Relacionamento com Cliente
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @NotNull(message = "A descrição do pedido é obrigatória.")
    private String descricao;

    public Pedido() {}

    public Pedido(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}