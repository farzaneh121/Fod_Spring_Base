package com.farzaneh.fod.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonDto {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String principalName;

	@NotBlank
	@Size(min = 3, max = 15, message = "First name should be between 3 and 20 char")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotBlank
	@Size(min = 3, max = 15, message = "Last name should be between 3 and 20 char")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@NotBlank
	@Email
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@NotBlank
	@Size(min = 3, max = 15, message = "User name should be between 3 and 20 char")
	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((principalName == null) ? 0 : principalName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDto other = (PersonDto) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else {
			if (!emailAddress.equals(other.emailAddress))
				return false;
		}

		if (principalName == null) {
			if (other.principalName != null)
				return false;
		} else {
			if (!principalName.equals(other.principalName))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PersonDto [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", principalName=" + principalName + "]";
	}

}
