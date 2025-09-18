package com.desafio.ntconsult.service;

import com.desafio.ntconsult.exception.LivroException;
import com.desafio.ntconsult.DTO.LivroDTO;
import com.desafio.ntconsult.DTO.ResponseDTO;
import com.desafio.ntconsult.model.Livro;
import com.desafio.ntconsult.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Object salvarLivro(LivroDTO livroDTO) {
        Optional<Livro> livro = livroRepository.findByTituloAndAutor(livroDTO.getTitulo(), livroDTO.getAutor());
        if(livro.isPresent()){
            throw new LivroException("Livro já esta cadastrado");
        }
        Livro novoLivro = new Livro();
        BeanUtils.copyProperties(livroDTO, novoLivro);
        livroRepository.save(novoLivro);
        return new ResponseDTO("Livro salvo com sucesso!");
    }

    public Object atualizarLivro(Integer idLivro, LivroDTO livroDTO) {
        Optional<Livro> livro = livroRepository.findById(idLivro);
        if (livro.isEmpty()) {
            throw new LivroException("Id do livro não encontrado");
        }
        Livro atualizarLivro = livro.get();
        BeanUtils.copyProperties(livroDTO, atualizarLivro);
        livroRepository.save(atualizarLivro);
        return new ResponseDTO("Livro atualizado com sucesso id: " + idLivro);
    }

    public Object deletarLivro(Integer idLivro) {
        Optional<Livro> livro = livroRepository.findById(idLivro);
        if (livro.isEmpty()) {
            throw new LivroException("Id do livro não encontrado");
        }
        livroRepository.deleteById(idLivro);
        return new ResponseDTO("Livro deletado com sucesso id: " + idLivro);
    }

    public ArrayList<Livro> buscarLivros() {
        ArrayList<Livro> livros = (ArrayList<Livro>) livroRepository.findAll();
        if (livros.isEmpty()) {
            throw new LivroException("Não há livros para mostrar");
        }
        return livros;
    }

}
