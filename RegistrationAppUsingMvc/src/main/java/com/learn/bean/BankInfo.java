package com.learn.bean;

public class BankInfo {
	private String bankName;
	private String accountNumber;
	private String ssn;

	public BankInfo(String bankName, String accountNumber, String ssn) {
		super();
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "BankInfo [bankName=" + bankName + ", accountNumber=" + accountNumber + ", ssn=" + ssn + "]";
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}
