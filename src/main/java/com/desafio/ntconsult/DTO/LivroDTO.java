package com.desafio.ntconsult.DTO;

import jakarta.validation.constraints.NotNull;


public class LivroDTO {

    @NotNull(message = "Titulo não pode ser nulo!")
    private String titulo;
    @NotNull(message = "Autor não pode ser nulo!")
    private String autor;
    @NotNull(message = "Ano de Publicação não pode ser nulo!")
    private Integer anoPublicacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
