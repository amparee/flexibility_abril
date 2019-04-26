package ar.com.flexibility.examen.domain.model;

import java.math.BigInteger;
import java.time.LocalDate;

public class CustomerModel {

	private String name;
	private String surname;
	private String address;
	private LocalDate birthdate;
	private BigInteger telephone;
	private String email;

	public CustomerModel() {
	}

	public CustomerModel(String name, String surname, String address, LocalDate birthdate, BigInteger telephone,
			String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.birthdate = birthdate;
		this.telephone = telephone;
		this.email = email;
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

	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", address=" + address + ", birthdate=" + birthdate
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}

}
