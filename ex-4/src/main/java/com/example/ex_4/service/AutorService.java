package com.example.ex_4.service;

import com.example.ex_4.model.Autor;
import com.example.ex_4.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;

    public List<Autor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Autor> listarPorId(Long id) {
        return repository.findById(id);
    }

    public Autor criar(Autor a) {
        return repository.save(a);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
