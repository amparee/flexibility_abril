package ar.com.flexibility.examen.domain.entity;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "customer_id")
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "surname")
	private String surname;

	@NotNull
	@Column(name = "address")
	private String address;

	@Column(name = "birthdate")
	private LocalDate birthdate;

	@NotNull
	@Column(name = "telephone")
	private BigInteger telephone;

	@Column(name = "email")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
	private List<Sale> sales;

	public Customer() {
	}

	public Customer(Long id, String name, String surname, String address, LocalDate birthdate, BigInteger telephone,
			String email, List<Sale> sales) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.birthdate = birthdate;
		this.telephone = telephone;
		this.email = email;
		this.sales = sales;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public BigInteger getTelephone() {
		return telephone;
	}

	public void setTelephone(BigInteger telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address
				+ ", birthdate=" + birthdate + ", telephone=" + telephone + ", email=" + email + ", sales=" + sales
				+ "]";
	}

}
