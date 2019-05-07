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

import ar.com.flexibility.examen.domain.entity.SaleDetail;
import ar.com.flexibility.examen.domain.service.SaleDetailService;

@RestController
@CrossOrigin
@RequestMapping("/sale-detail")
public class SaleDetailRestController {
	@Autowired
	private SaleDetailService saleDetailService;

	@GetMapping("/get-details")
	public ResponseEntity<List<SaleDetail>> getSaleDetails() {
		return new ResponseEntity<List<SaleDetail>>(saleDetailService.listSaleDetails(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getSaleDetailById(@PathVariable("id") Long id) {
		try {
			SaleDetail saleDetail = saleDetailService.findById(id);
			return new ResponseEntity<SaleDetail>(saleDetail, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<SaleDetail> createSaleDetail(@RequestBody SaleDetail saleDetail) {
		SaleDetail saleDetailSaved = saleDetailService.save(saleDetail);
		return new ResponseEntity<SaleDetail>(saleDetailSaved, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<SaleDetail> update(@RequestBody SaleDetail saleDetail) {
		SaleDetail saleDetailUpdated = saleDetailService.save(saleDetail);
		return new ResponseEntity<SaleDetail>(saleDetailUpdated, HttpStatus.OK);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		boolean deleted = saleDetailService.delete(id);

		if (deleted) {
			return new ResponseEntity<String>("SaleDetail with id:" + id + " has been deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("SaleDetail with id:" + id + " has not been deleted",
					HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}
