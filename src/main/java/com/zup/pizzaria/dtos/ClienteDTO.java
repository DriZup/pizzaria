package com.zup.pizzaria.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

    @NotBlank(message = "O nome não pode ser vazio ou nulo.")
    private String nome;

    @NotBlank(message = "O email não pode ser vazio ou nulo.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @NotBlank(message = "O telefone não pode ser vazio ou nulo.")
    @Pattern(regexp = "\\d+", message = "O telefone deve conter apenas números.")
    @Size(min = 8, message = "O telefone deve ter no mínimo 8 dígitos.")
    private String telefone;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
