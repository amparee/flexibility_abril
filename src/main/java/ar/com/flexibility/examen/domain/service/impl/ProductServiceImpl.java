package ar.com.flexibility.examen.domain.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.Product;
import ar.com.flexibility.examen.domain.repository.ProductJpaRepository;
import ar.com.flexibility.examen.domain.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductJpaRepository productJpaRepository;

	private final Log LOG = LogFactory.getLog(ProductServiceImpl.class);

	@Override
	public List<Product> listProducts() {
		return productJpaRepository.findAll();
	}

	@Override
	public Product findById(Long id) throws NoSuchElementException {
		return productJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Product doesn't exist with id: " + id));
	}

	@Override
	public Product save(Product product) {
		return productJpaRepository.save(product);
	}

	@Override
	public boolean delete(Long id) {
		Product product = productJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Product doesn't exist with id: " + id));
		if (product != null) {
			productJpaRepository.delete(product);
			return true;
		} else {
			return false;
		}

	}

}
