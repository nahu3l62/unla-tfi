package com.unla.tfi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unla.tfi.model.Producto;
import com.unla.tfi.repository.ProductoRepository;


@Service
public class ProductoService {

    private final ProductoRepository repository;
    
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }
}
