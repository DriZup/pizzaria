package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.Pedido;

public class PedidoDTO {
    private String nomeCliente;
    private String emailCliente;
    private String descricaoPedido;

    public PedidoDTO(String nomeCliente, String emailCliente, String descricaoPedido) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.descricaoPedido = descricaoPedido;
    }

    public PedidoDTO() {

    }

    public PedidoDTO(String descricao) {
        this.descricaoPedido = descricao;
    }

    public PedidoDTO(Pedido pedido) {
        this.nomeCliente = pedido.getCliente().getNome();
        this.emailCliente = pedido.getCliente().getEmail();
        this.descricaoPedido = pedido.getDescricao();
    }


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }
}
