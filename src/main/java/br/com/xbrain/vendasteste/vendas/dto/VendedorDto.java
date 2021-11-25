package br.com.xbrain.vendasteste.vendas.dto;

import javax.validation.constraints.NotBlank;

public class VendedorDto {

    @NotBlank
    private String nome;
    private Long id;

    public VendedorDto() {
    }

    public VendedorDto(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
