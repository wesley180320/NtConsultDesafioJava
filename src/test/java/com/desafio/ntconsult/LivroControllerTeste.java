package com.desafio.ntconsult;

import com.desafio.ntconsult.DTO.LivroDTO;
import com.desafio.ntconsult.DTO.ResponseDTO;
import com.desafio.ntconsult.exception.LivroException;
import com.desafio.ntconsult.model.Livro;
import org.springframework.http.MediaType;
import com.desafio.ntconsult.service.LivroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LivroControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LivroService livroService;


    @Test
    void dadoLivroValido_quandoSalvar_entaoRetornarCreated() throws Exception {

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setAutor("Wesley");
        livroDTO.setAnoPublicacao(2025);
        livroDTO.setTitulo("Ola mundo");

        mockMvc.perform(post("/livro/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livroDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void dadoLivroJaCadastrado_quandoSalvar_entaoRetornarBadRequest() throws Exception {

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setAutor("Wesley");
        livroDTO.setAnoPublicacao(2025);
        livroDTO.setTitulo("Ola mundo");

        Mockito.when(livroService.salvarLivro(Mockito.any(LivroDTO.class)))
                .thenThrow(new LivroException("Livro já está cadastrado"));

        mockMvc.perform(post("/livro/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livroDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").value("Livro já está cadastrado"));
    }

    @Test
    void dadoLivroComCamposVazios_quandoSalvar_entaoRetornarMensagensDeErro() throws Exception {

        LivroDTO livroDTO = new LivroDTO();

        mockMvc.perform(post("/livro/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livroDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.titulo").value("Titulo não pode ser nulo!"))
                .andExpect(jsonPath("$.errors.autor").value("Autor não pode ser nulo!"))
                .andExpect(jsonPath("$.errors.anoPublicacao").value("Ano de Publicação não pode ser nulo!"));

    }

    @Test
    void dadoLivroExistente_quandoAtualizar_entaoRetornarSucesso() throws Exception {

        Long idLivro = 1L;

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setAutor("Wesley2");
        livroDTO.setAnoPublicacao(2025);
        livroDTO.setTitulo("Ola mundo");


        mockMvc.perform(put("/livro/atualizar/{idLivro}", idLivro)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livroDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void dadoLivroComCamposVazios_quandoAtualizar_entaoRetornarMensagensDeErro() throws Exception {

        Long idLivro = 1L;
        LivroDTO livroDTO = new LivroDTO();

        mockMvc.perform(put("/livro/atualizar/{idLivro}", idLivro)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livroDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.titulo").value("Titulo não pode ser nulo!"))
                .andExpect(jsonPath("$.errors.autor").value("Autor não pode ser nulo!"))
                .andExpect(jsonPath("$.errors.anoPublicacao").value("Ano de Publicação não pode ser nulo!"));
    }

    @Test
    void dadoIdValido_quandoDeletar_entaoRetornarSucesso() throws Exception {

        Long idLivro = 1L;

        Mockito.when(livroService.deletarLivro(idLivro))
                .thenReturn(new ResponseDTO("Livro deletado com sucesso id: " + idLivro));

        mockMvc.perform(delete("/livro/deletar/{idLivro}", idLivro))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensagem").value("Livro deletado com sucesso id: " + idLivro));
    }

    @Test
    void dadoIdInexistente_quandoDeletar_entaoRetornarBadRequest() throws Exception {

        Long idLivro = 3L;

        Mockito.when(livroService.deletarLivro(idLivro))
                .thenThrow(new LivroException("Id do livro não encontrado"));

        mockMvc.perform(delete("/livro/deletar/{idLivro}", idLivro))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").value("Id do livro não encontrado"));
    }


    @Test
    void dadoLivrosExistentes_quandoBuscarTodos_entaoRetornarOk() throws Exception {

        ArrayList<Livro> livros = new ArrayList<>();

        Mockito.when(livroService.buscarLivros())
                .thenReturn(livros);

        mockMvc.perform(get("/livro/buscarlivros"))
                .andExpect(status().isOk());
    }

    @Test
    void dadoNenhumLivro_quandoBuscarTodos_entaoRetornarBadRequest() throws Exception {

        Mockito.when(livroService.buscarLivros())
                .thenThrow(new LivroException("Não há livros para mostrar"));

        mockMvc.perform(get("/livro/buscarlivros"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").value("Não há livros para mostrar"));

    }
}
