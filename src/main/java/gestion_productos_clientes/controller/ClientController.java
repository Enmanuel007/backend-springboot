package gestion_productos_clientes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion_productos_clientes.exceptions.ResourceNotFoundExceptions;
import gestion_productos_clientes.model.Client;
import gestion_productos_clientes.model.Product;
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
	
	//Método para crear un cliente
		@PostMapping("/clients")
		public Client crearCliente(@RequestBody Client client) {
			return repository.save(client);
		}
	
	//Método para buscar cliente por id
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> obtenerClientePorId(@PathVariable Long id){
		Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("No exite el cliente con el id:" + id));
		return ResponseEntity.ok(client);
	}
	
	//Método para actualizar un cliente por id
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> actualizarClientePorId(@PathVariable Long id, @RequestBody Client detailClient){
		Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("No exite el cliente con el id:" + id));
		
		client.setName(detailClient.getName());
		client.setLastName(detailClient.getLastName());
		client.setEmail(detailClient.getEmail());
		client.setPhone(detailClient.getPhone());
		
		Client clienttUpdate = repository.save(client);
		
		return ResponseEntity.ok(client);
	}
	
	
	//este metodo sirve para eliminar un cliente
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe el cliente con el ID : " + id));

        repository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
