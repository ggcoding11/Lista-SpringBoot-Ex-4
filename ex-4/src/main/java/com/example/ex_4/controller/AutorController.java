package com.example.ex_4.controller;

import com.example.ex_4.model.Autor;
import com.example.ex_4.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService service;

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        List<Autor> request = service.listarTodos();

        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> listarPorId(@PathVariable Long id) {
        Autor request = service.listarPorId(id).get();

        return ResponseEntity.ok().body(request);
    }

    @PostMapping
    public ResponseEntity<Autor> criar(@RequestBody Autor p) {
        Autor request = service.criar(p);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
