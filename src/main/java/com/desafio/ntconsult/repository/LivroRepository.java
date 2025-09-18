package com.desafio.ntconsult.repository;

import com.desafio.ntconsult.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    Optional<Livro> findByTituloAndAutor(String Titulo, String autor);
}
