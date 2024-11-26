package gestion_productos_clientes.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import gestion_productos_clientes.model.Product;

@Repository
public interface ProductRepository extends JpaRepositoryImplementation<Product, Long> {

}
