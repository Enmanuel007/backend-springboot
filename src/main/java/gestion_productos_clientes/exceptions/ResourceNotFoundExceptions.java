package gestion_productos_clientes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptions extends RuntimeException{
	private static final long serialVersionID = 1l;
	
	public ResourceNotFoundExceptions(String mensaje) {
		super(mensaje);
	}
}
