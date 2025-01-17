package com.zup.pizzaria.dtos;


import com.zup.pizzaria.enums.PagamentoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PagamentoDTO {

    @NotNull(message = "O valor do pagamento não pode ser nulo.")
    @Positive(message = "O valor do pagamento deve ser positivo.")
    private Double valor;

    @NotNull(message = "O tipo de pagamento não pode ser nulo.")
    private PagamentoEnum tipoPagamento;

    @NotBlank(message = "A descrição do pagamento não pode ser vazia ou nula.")
    private String descricao;

    // Getters e Setters
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public PagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(PagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}