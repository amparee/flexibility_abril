package ar.com.flexibility.examen.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.Product;

@Service
public interface ProductService {

	public abstract List<Product> listProducts();

	public abstract Optional<Product> findById(Long id);

	public abstract Product save(Product products);

	public abstract boolean delete(Long id);

}
