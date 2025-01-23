package com.zup.pizzaria.enums;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum PagamentoEnum {
    @JsonProperty("Dinheiro")
    DINHEIRO,
    @JsonProperty("Cartão de Crédito")
    CARTAO,
    @JsonProperty("Pix")
    PIX
}