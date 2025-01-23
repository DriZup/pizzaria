package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.Pedido;

public class PedidoDTO {
    private String nomeCliente;
    private String emailCliente;
    private String descricaoPedido;



    public PedidoDTO() {

    }

    public PedidoDTO(String nomeCliente, String emailCliente, String descricaoPedido) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.descricaoPedido = descricaoPedido;
    }

    public PedidoDTO(Pedido pedidoSalvo) {
        this.nomeCliente = pedidoSalvo.getCliente().getNome();
        this.emailCliente = pedidoSalvo.getCliente().getEmail();
        this.descricaoPedido = pedidoSalvo.getDescricao();
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
