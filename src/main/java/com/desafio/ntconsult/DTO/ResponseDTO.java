package com.desafio.ntconsult.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    private String mensagem;

    private Long idLivro;

    public ResponseDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public ResponseDTO(String mensagem, Long idLivro) {
        this.mensagem = mensagem;
        this.idLivro = idLivro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }
}
