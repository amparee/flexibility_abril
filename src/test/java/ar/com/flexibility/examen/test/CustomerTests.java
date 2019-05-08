package ar.com.flexibility.examen.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ar.com.flexibility.examen.domain.entity.Customer;
import ar.com.flexibility.examen.domain.service.CustomerService;

public class CustomerTests {

	private Customer customer;

	@Mock
	private CustomerService customerService;

	@Before
	public void init() {

		LocalDate birthdate = LocalDate.of(1991, Month.AUGUST, 2);

		customer = new Customer();
		customer.setName("Ricardo");
		customer.setTelephone(BigInteger.valueOf(48426895L));
		customer.setAddress("Ascasubi 1020");
		customer.setBirthdate(birthdate);
		customer.setEmail("mail@mail.com");
		customer.setSurname("Ruben");
		customer.setId(1L);

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListAllCustomers() throws Exception {
		List<Customer> list = new ArrayList<Customer>();
		Customer custOne = new Customer();
		Customer custTwo = new Customer();
		Customer custThree = new Customer();
		list.add(custOne);
		list.add(custTwo);
		list.add(custThree);
		when(customerService.listCustomers()).thenReturn(list);
		List<Customer> custList = customerService.listCustomers();
		assertEquals(3, custList.size());
		verify(customerService, times(1)).listCustomers();
	}

	@Test
	public void testSaveCustomer() throws Exception {
		when(customerService.save(customer)).thenReturn(customer);
		Customer customTest = customerService.save(customer);
		assertEquals(1, customTest.getId().longValue());
	}

	@Test
	public void testFindCustomerById() throws Exception {
		when(customerService.findById(1L)).thenReturn(customer);
		Customer customTest = customerService.findById(1L);
		assertNotNull(customTest);
	}

	@Test
	public void testDeleteCustomer() throws Exception {
		when(customerService.delete(1L)).thenReturn(true);
		boolean value = customerService.delete(1L);
		assertTrue(value);
	}

}
