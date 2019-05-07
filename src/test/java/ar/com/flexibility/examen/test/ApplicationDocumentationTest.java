package ar.com.flexibility.examen.test;

import static org.junit.Assert.assertEquals;
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
import org.springframework.test.web.servlet.MockMvc;

import ar.com.flexibility.examen.domain.entity.Customer;
import ar.com.flexibility.examen.domain.service.CustomerService;

public class ApplicationDocumentationTest {

	private MockMvc mockMvc;
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

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListAllUsers() throws Exception {

		List<Customer> list = new ArrayList<Customer>();
		Customer empOne = new Customer();
		Customer empTwo = new Customer();
		Customer empThree = new Customer();

		list.add(empOne);
		list.add(empTwo);
		list.add(empThree);

		when(customerService.listCustomers()).thenReturn(list);

		List<Customer> empList = customerService.listCustomers();

		assertEquals(3, empList.size());
		verify(customerService, times(1)).listCustomers();

	}

	@Test
	public void testSaveCustomer() throws Exception {
		when(customerService.save(customer)).thenReturn(customer);

		Customer customTest = customerService.save(customer);

		assertEquals();

	}

	@Test
	public void testFindCustomerById() throws Exception {

		when(customerService.findById(1L)).thenReturn(customer);
		Customer customTest = customerService.findById(1L);
		assertEquals();

	}

	@Test
	public void testDeleteCustomer() throws Exception {
		when(customerService.delete(1L)).thenReturn(true);

		assertEquals();

	}

}
