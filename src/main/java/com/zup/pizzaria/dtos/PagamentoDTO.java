package com.zup.pizzaria.dtos;

import com.zup.pizzaria.enums.PagamentoEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PagamentoDTO {

    @NotNull(message = "O tipo de pagamento não pode ser nulo.")
    private PagamentoEnum formaPagamento;

    @NotBlank(message = "A descrição do pagamento não pode ser vazia ou nula.")
    private String descricao;

    @NotNull(message = "O ID do pedido não pode ser nulo.")
    private Long pedidoId;

    @NotNull(message = "O valor pago não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "O valor pago deve ser maior que zero.")
    private BigDecimal valorPago;

    // Construtor padrão (necessário para o Jackson)
    public PagamentoDTO() {
    }

    // Construtor com todos os campos
    public PagamentoDTO(String formaPagamento, String descricao, Long pedidoId, BigDecimal valorPago) {
        this.formaPagamento = PagamentoEnum.valueOf(formaPagamento);
        this.descricao = descricao;
        this.pedidoId = pedidoId;
        this.valorPago = valorPago;
    }

    // Getters e Setters
    public PagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    public void setTipoPagamento(PagamentoEnum tipoPagamento) {
        this.formaPagamento = tipoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }
}