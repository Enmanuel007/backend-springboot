package gestion_productos_clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion_productos_clientes.model.Client;
import gestion_productos_clientes.repository.ClientRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

	@Autowired
	private ClientRepository repository;
	
	//Método que lista todos los clientes
	@GetMapping("/clients")
	public List<Client> getAllEmpleados() {
		return repository.findAll();
	}
}
