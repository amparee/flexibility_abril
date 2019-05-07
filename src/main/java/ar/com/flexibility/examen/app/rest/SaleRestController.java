package ar.com.flexibility.examen.app.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import ar.com.flexibility.examen.domain.entity.Sale;
import ar.com.flexibility.examen.domain.service.SaleService;

@RestController
@CrossOrigin
@RequestMapping("/sale")
public class SaleRestController {
	@Autowired
	private SaleService saleService;

	@GetMapping("/get-sales")
	public ResponseEntity<List<Sale>> getSales() {
		return new ResponseEntity<List<Sale>>(saleService.listSales(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getSaleById(@PathVariable("id") Long id) {
		try {
			Sale sale = saleService.findById(id);
			return new ResponseEntity<Sale>(sale, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
		Sale saleSaved = saleService.save(sale);
		return new ResponseEntity<Sale>(saleSaved, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Sale> update(@RequestBody Sale sale) {
		Sale saleUpdated = saleService.save(sale);
		return new ResponseEntity<Sale>(saleUpdated, HttpStatus.OK);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		boolean deleted = saleService.delete(id);

		if (deleted) {
			return new ResponseEntity<String>("Sale with id:" + id + " has been deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Sale with id:" + id + " has not been deleted",
					HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}
