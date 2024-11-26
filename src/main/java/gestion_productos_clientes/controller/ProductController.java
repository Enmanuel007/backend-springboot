package gestion_productos_clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import gestion_productos_clientes.model.Product;
import gestion_productos_clientes.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	//Método que lista todos los productos
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	
	//Método para crear un producto
	@PostMapping("/products")
	public Product crearProducto(@RequestBody Product product) {
		return repository.save(product);
	}
}
