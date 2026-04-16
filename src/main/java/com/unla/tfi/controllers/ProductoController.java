package com.unla.tfi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.tfi.model.Producto;
import com.unla.tfi.services.ProductoService;



@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }
    
    @GetMapping("/hola")
    public String hola() {
        return "La API funciona";
    }

    @GetMapping
    public List<Producto> obtenerTodos() {
        return service.obtenerTodos();
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = service.obtenerTodos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/guardar")
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        Producto nuevoProducto = service.guardar(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PostMapping("/guardar2")
    public Producto guardar2(@RequestBody Producto producto) {
        return service.guardar(producto);
    }
}
