package com.atech.api.model;

public class CustomerDTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private String url;
	
	public CustomerDTO(int id, String firstName, String lastName, String url) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.url = url;
	}

	public CustomerDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", url=" + url + "]";
	}
	
		
}
