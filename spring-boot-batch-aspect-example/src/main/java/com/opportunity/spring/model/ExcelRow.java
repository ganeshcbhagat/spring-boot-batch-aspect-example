package com.opportunity.spring.model;

import org.springframework.stereotype.Component;

@Component
public class ExcelRow {

	private String emailAddress;
	private String name;
	private String purchasedPackage;

	public ExcelRow() {
		super();
	}
	
	public ExcelRow(String emailAddress, String name, String purchasedPackage) {
		super();
		this.emailAddress = emailAddress;
		this.name = name;
		this.purchasedPackage = purchasedPackage;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPurchasedPackage() {
		return purchasedPackage;
	}
	public void setPurchasedPackage(String purchasedPackage) {
		this.purchasedPackage = purchasedPackage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((purchasedPackage == null) ? 0 : purchasedPackage.hashCode());
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
		ExcelRow other = (ExcelRow) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (purchasedPackage == null) {
			if (other.purchasedPackage != null)
				return false;
		} else if (!purchasedPackage.equals(other.purchasedPackage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExcelRow [emailAddress=" + emailAddress + ", name=" + name + ", purchasedPackage=" + purchasedPackage
				+ "]";
	}

}
