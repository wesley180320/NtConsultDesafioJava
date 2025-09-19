package com.desafio.ntconsult.controller;

import com.desafio.ntconsult.DTO.LivroDTO;
import com.desafio.ntconsult.DTO.ResponseDTO;
import com.desafio.ntconsult.model.Livro;
import com.desafio.ntconsult.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/")
    private ResponseEntity<ResponseDTO> salvarLivro(@RequestBody @Valid LivroDTO livroDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.salvarLivro(livroDTO));
    }

    @PutMapping("/atualizar/{idLivro}")
    private ResponseEntity<ResponseDTO> atualizarLivro(@PathVariable Long idLivro, @RequestBody @Valid LivroDTO livroDTO) {
        return ResponseEntity.ok().body(livroService.atualizarLivro(idLivro, livroDTO));
    }

    @DeleteMapping("/deletar/{idLivro}")
    private ResponseEntity<ResponseDTO> deletarLivro(@PathVariable Long idLivro) {
        return ResponseEntity.ok().body(livroService.deletarLivro(idLivro));
    }

    @GetMapping("/buscarlivros")
    private ResponseEntity<ArrayList<Livro>> buscarLivros() {
        return ResponseEntity.ok().body(livroService.buscarLivros());
    }

}
