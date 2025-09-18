package com.desafio.ntconsult.DTO;

public class ResponseDTO {

    private String mensagem;

    public ResponseDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
