package com.tcs.bank.Customer;

import java.util.Date;

public class AccountDetails {
private int accountNo;
private String name;
private String dob;
private String address;
private String email;
private String typeOfAccount;
private double balance;
private String user_id;
private String creationDate;
public int getAccountNo() {
	return accountNo;
}
public void setAccountNo(int accountNo) {
	this.accountNo = accountNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTypeOfAccount() {
	return typeOfAccount;
}
public void setTypeOfAccount(String typeOfAccount) {
	this.typeOfAccount = typeOfAccount;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getCreationDate() {
	return creationDate;
}
public void setCreationDate(String creationDate) {
	this.creationDate = creationDate;
}
public AccountDetails(String name, String dob, String address, String email, String typeOfAccount, double balance,
		String user_id, String creationDate) {
	
	this.name = name;
	this.dob = dob;
	this.address = address;
	this.email = email;
	this.typeOfAccount = typeOfAccount;
	this.balance = balance;
	this.user_id = user_id;
	this.creationDate = creationDate;
}

public AccountDetails(){
	
}
@Override
public String toString() {
	return "AccountDetails [accountNo=" + accountNo + ", name=" + name + ", dob=" + dob + ", address=" + address
			+ ", email=" + email + ", typeOfAccount=" + typeOfAccount + ", balance=" + balance + ", user_id=" + user_id
			+ ", creationDate=" + creationDate + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + accountNo;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	long temp;
	temp = Double.doubleToLongBits(balance);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
	result = prime * result + ((dob == null) ? 0 : dob.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((typeOfAccount == null) ? 0 : typeOfAccount.hashCode());
	result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
	AccountDetails other = (AccountDetails) obj;
	if (accountNo != other.accountNo)
		return false;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
		return false;
	if (creationDate == null) {
		if (other.creationDate != null)
			return false;
	} else if (!creationDate.equals(other.creationDate))
		return false;
	if (dob == null) {
		if (other.dob != null)
			return false;
	} else if (!dob.equals(other.dob))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (typeOfAccount == null) {
		if (other.typeOfAccount != null)
			return false;
	} else if (!typeOfAccount.equals(other.typeOfAccount))
		return false;
	if (user_id == null) {
		if (other.user_id != null)
			return false;
	} else if (!user_id.equals(other.user_id))
		return false;
	return true;
}

}
