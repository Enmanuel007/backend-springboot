package gestion_productos_clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion_productos_clientes.exceptions.ResourceNotFoundExceptions;
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
	
	//Método para buscar producto por id
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> obtenerProductoPorId(@PathVariable Long id){
		Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("No exite el producto con el id:" + id));
		return ResponseEntity.ok(product);
	}
	
	//Método para actualizar un producto por id
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> actualizarProductoPorId(@PathVariable Long id, @RequestBody Product detailProduct){
		Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("No exite el producto con el id:" + id));
		
		product.setName(detailProduct.getName());
		product.setDescription(detailProduct.getDescription());
		product.setPrice(detailProduct.getPrice());
		product.setQuantity(detailProduct.getQuantity());
		product.setPicture(detailProduct.getPicture());
		
		Product productUpdate = repository.save(product);
		
		return ResponseEntity.ok(product);
	}
}
