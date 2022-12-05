/**
 * @author Josip Begic
 * 
 */
package lib;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class User {

	private String firstName;
	private String surname;
	private String email;
	private String username;
	private char[] accountNumber;
	private char[] pin;
	private BigDecimal balance;
	private DbConnection connection = new DbConnection();
	double value = 0;
	int scale = 4;

	@SuppressWarnings("deprecation")
	public User(String surname, String firstName, String email, String username) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.username = username;
		accountNumGenerator();
		while (!connection.checkAccountNumber(this.accountNumber)) {
			accountNumGenerator();
		}
		balance = new BigDecimal(Double.toString(value));
		balance = balance.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
	}

	public User(String surname, String firstName, String email, String username, String accountNumber,
			BigDecimal balance, String pin) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.accountNumber = accountNumber.toCharArray();
		this.balance = balance;
		this.pin = pin.toCharArray();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String sqlAccountNumber) {
		for (int i = 0; i < sqlAccountNumber.length(); i++) {
			this.accountNumber[i] = sqlAccountNumber.charAt(i);
		}
	}

	public char[] getPin() {
		return pin;
	}

	public void setPin(char[] pin) {
		this.pin = pin;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public String printAccountNumber(char[] accountNumber) {
		String accNum = new String(accountNumber);
		return accNum;
	}

	public void setBalance(BigDecimal deposit) {
		this.balance = deposit;
	}

	public String balanceToString() {
		return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(this.balance);
	}

	private void accountNumGenerator() {
		this.accountNumber = new char[11];
		accountNumber[0] = 'H';
		accountNumber[1] = 'R';
		accountNumber[2] = '-';
		Random rnd = new Random();
		for (int i = 3; i < 11; i++) {
			char c = (char) ('0' + rnd.nextInt(10));
			accountNumber[i] = c;
		}
	}
}
