package ar.com.flexibility.examen.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.flexibility.examen.domain.entity.Sale;
import ar.com.flexibility.examen.domain.service.SaleService;

@RestController
@CrossOrigin
@RequestMapping("/sale")
public class SaleRestController {
	@Autowired
	private SaleService saleService;

	@GetMapping("/get-sales")
	public List<Sale> getSales() {
		return saleService.listSales();
	}

	@GetMapping("/{id}")
	public Sale getSaleById(@PathVariable("id") Long id) {
		Optional<Sale> sale = saleService.findById(id);
		return sale.get();
	}

	@PostMapping("/create")
	public Sale createSale(@RequestBody Sale sale) {
		return saleService.save(sale);
	}

	@PutMapping("/update")
	public Sale update(@RequestBody Sale sale) {
		return saleService.save(sale);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public boolean delete(@PathVariable("id") Long id) {
		return saleService.delete(id);
	}
}
