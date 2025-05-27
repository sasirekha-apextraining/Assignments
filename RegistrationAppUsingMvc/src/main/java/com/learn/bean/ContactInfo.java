package com.learn.bean;

public class ContactInfo {

	private String address;
	private String city;
	private String state;
	private String country;
	private String phoneNumber;

	public ContactInfo(String address, String city, String state, String country, String phoneNumber) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ContactInfo [address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
