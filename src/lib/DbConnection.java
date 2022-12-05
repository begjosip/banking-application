/**
 *
 * @author Josip Begic
 *
 */
package lib;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import formsUI.PinForm;
import formsUI.TransferForm;

public class DbConnection {

	private static final String SQL_INSERT = "INSERT INTO bankuser (firstname, surname, username, email, pin, accountnumber, balance) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_VERIFY = "SELECT firstname, surname, username, email, pin, accountnumber, balance FROM bankuser WHERE username = ? AND pin = ?";
	private static final String SQL_UPDATE = "UPDATE bankuser SET balance = ? WHERE username = ?";
	private static final String SQL_SENDERBALANCE = "SELECT balance FROM bankuser WHERE username = ?";
	private static final String SQL_TRANSFER = "UPDATE bankuser SET balance = balance + ? WHERE accountnumber = ?";
	private static final String SQL_USERNAMECHECK = "SELECT username FROM bankuser WHERE username = ?";
	private static final String SQL_ACCOUNTCHECK = "SELECT accountnumber FROM bankuser WHERE accountnumber = ?";
	private static final String OWNER = "postgres";
	private static final String PASSWORD = "bazepodataka";

	private Connection connection;

	public DbConnection() {
	}

	public void insertData(User user) throws SQLException {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankingApp", OWNER, PASSWORD);
			System.out.println("Connected to database.");

			String name = user.getFirstName();
			String surname = user.getSurname();
			String username = user.getUsername();
			String mail = user.getEmail();
			String accNum = new String(user.getAccountNumber());
			String pin = new String(user.getPin());
			BigDecimal balance = user.getBalance();

			PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
			statement.setString(1, name);
			statement.setString(2, surname);
			statement.setString(3, username);
			statement.setString(4, mail);
			statement.setString(5, pin);
			statement.setString(6, accNum);
			statement.setBigDecimal(7, balance);
			int rows = statement.executeUpdate();
			if (rows > 0) {
				System.out.println("New user added.");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User validation(String username, String pin) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankingApp", OWNER, PASSWORD);
			System.out.println("Connected to database.");

			PreparedStatement statement = connection.prepareStatement(SQL_VERIFY);
			statement.setString(1, username);
			statement.setString(2, pin);
			ResultSet rs = statement.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					String sqlFirstName = rs.getString(1);
					String sqlSurname = rs.getString(2);
					String sqlUsername = rs.getString(3);
					String sqlEmail = rs.getString(4);
					String sqlPin = rs.getString(5);
					String sqlAccountNumber = rs.getString(6);
					BigDecimal sqlBalance = rs.getBigDecimal(7);
					User user = new User(sqlSurname, sqlFirstName, sqlEmail, sqlUsername, sqlAccountNumber, sqlBalance,
							sqlPin);
					connection.close();
					return user;
				}
			} else {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateBalance(User activeUser) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankingApp", OWNER, PASSWORD);
			System.out.println("Connected to database.");

			PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
			statement.setBigDecimal(1, activeUser.getBalance());
			statement.setString(2, activeUser.getUsername());
			statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JFrame transfer(String recipientAccount, String amount, User activeUser) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankingApp", OWNER, PASSWORD);
			System.out.println("Connected to database.");

			BigDecimal transferAmount = new BigDecimal(amount);
			transferAmount.setScale(4, RoundingMode.DOWN);
			PreparedStatement statement = connection.prepareStatement(SQL_SENDERBALANCE);
			statement.setString(1, activeUser.getUsername());
			ResultSet rs = statement.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					if (activeUser.getBalance().compareTo(transferAmount) == -1) {
						TransferForm transferFrame = new TransferForm(activeUser);
						JOptionPane.showMessageDialog(transferFrame, "Insufficient funds\nTry again", "Invalid amount",
								JOptionPane.PLAIN_MESSAGE);
						return transferFrame;
					} else {
						connection.close();
						// ENOUGH FOUNDS
						// PIN CONFIRMATION
						PinForm pinForm = new PinForm(activeUser, true, amount, recipientAccount);
						return pinForm;
					}
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addFundsToRecipeint(String ammount, String accountNumber) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankingApp", OWNER, PASSWORD);
			System.out.println("Connected to database.");

			BigDecimal balance = new BigDecimal(ammount);
			PreparedStatement statement = connection.prepareStatement(SQL_TRANSFER);
			statement.setBigDecimal(1, balance);
			statement.setString(2, accountNumber);
			statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkUsername(String usernameInput) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankingApp", OWNER, PASSWORD);
			System.out.println("Connected to database.");

			PreparedStatement statement = connection.prepareStatement(SQL_USERNAMECHECK);
			statement.setString(1, usernameInput);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return false;
			}
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean checkAccountNumber(char[] accountNumber) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankingApp", OWNER, PASSWORD);
			System.out.println("Connected to database.");

			String account = new String(accountNumber);
			PreparedStatement statement = connection.prepareStatement(SQL_ACCOUNTCHECK);
			statement.setString(1, account);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return false;
			}
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
