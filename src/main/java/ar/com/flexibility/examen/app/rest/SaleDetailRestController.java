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

import ar.com.flexibility.examen.domain.entity.SaleDetail;
import ar.com.flexibility.examen.domain.service.SaleDetailService;

@RestController
@CrossOrigin
@RequestMapping("/sale-detail")
public class SaleDetailRestController {
	@Autowired
	private SaleDetailService saleDetailService;

	@GetMapping("/get-details")
	public List<SaleDetail> getSaleDetails() {
		return saleDetailService.listSaleDetails();
	}

	@GetMapping("/{id}")
	public SaleDetail getSaleDetailById(@PathVariable("id") Long id) {
		Optional<SaleDetail> saleDetail = saleDetailService.findById(id);
		return saleDetail.get();
	}

	@PostMapping("/create")
	public SaleDetail createSaleDetail(@RequestBody SaleDetail saleDetail) {
		return saleDetailService.save(saleDetail);
	}

	@PutMapping("/update")
	public SaleDetail update(@RequestBody SaleDetail saleDetail) {
		return saleDetailService.save(saleDetail);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public boolean delete(@PathVariable("id") Long id) {
		return saleDetailService.delete(id);
	}
}
