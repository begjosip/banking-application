/**
 *
 * @author Josip Begic
 */
package formsUI;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lib.DbConnection;
import lib.User;

public class PinForm extends JFrame {

	private static final long serialVersionUID = 4877395960908858052L;

	private User user;
	private boolean confirmation;
	private char[] transferPin = new char[4];
	private int transferPinCounter = 0;
	private boolean correctTransfer = false;
	private String amount;
	private String recipientAccount;

	protected char[] pin = new char[4];
	private int pinCounter = 4;
	boolean confirmed = false;
	boolean incorrectPin = false;
	private int pinArrayCnt = 0;
	protected char prevDigit;

	public PinForm(User user, boolean confirmation) {
		this.user = (User) user;
		this.confirmation = confirmation;
		if (confirmation) {
			this.pin = user.getPin();
		}
		initComponents();
	}

	public PinForm(User activeUser, boolean confirmation, String amount, String recipientAccount) {
		this.user = (User) activeUser;
		this.confirmation = confirmation;
		this.amount = amount;
		this.recipientAccount = recipientAccount;
		if (confirmation) {
			this.pin = activeUser.getPin();
		}
		initComponents();
	}

	private DbConnection connection = new DbConnection();

	private void initComponents() {
		btn2 = new javax.swing.JButton();
		btn3 = new javax.swing.JButton();
		btn1 = new javax.swing.JButton();
		btn5 = new javax.swing.JButton();
		btn6 = new javax.swing.JButton();
		btn4 = new javax.swing.JButton();
		btn8 = new javax.swing.JButton();
		btn7 = new javax.swing.JButton();
		btn0 = new javax.swing.JButton();
		btn9 = new javax.swing.JButton();
		pinLabel = new javax.swing.JLabel();
		pinLoader = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				dispose();
				if (!confirmation) {
					RegisterForm regForm = new RegisterForm();
					regForm.setVisible(true);
					regForm.setLocationRelativeTo(null);
				} else {
					TransferForm TransferForm = new TransferForm(user);
					TransferForm.setVisible(true);
					TransferForm.setLocationRelativeTo(null);
				}
			}
		});

		btn2.setText("2");
		btn2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn2ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btn3.setText("3");
		btn3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn3ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btn1.setText("1");
		btn1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn1ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btn5.setText("5");
		btn5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn5ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btn6.setText("6");
		btn6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn6ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btn4.setText("4");
		btn4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn4ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btn8.setText("8");
		btn8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn8ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btn7.setText("7");
		btn7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn7ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btn0.setText("0");
		btn0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn0ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btn9.setText("9");
		btn9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn9ActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		pinLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		pinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pinLabel.setText("PIN");

		pinLoader.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
		pinLoader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pinLoader.setText("****");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(137, 137, 137)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(
														btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createSequentialGroup()
														.addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(
																btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup()
														.addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(
																btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup()
														.addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(pinLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addGap(164, 164, 164).addComponent(pinLabel,
										javax.swing.GroupLayout.PREFERRED_SIZE, 79,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(140, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap(41, Short.MAX_VALUE)
				.addComponent(pinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(
						pinLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(5, 5, 5)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(43, 43, 43)));

		pack();
	}

	private void btn1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn1.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					this.correctTransfer();
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn1.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn1.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private void btn2ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn2.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					this.correctTransfer();
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn2.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn2.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private void btn3ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn3.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					this.correctTransfer();
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn3.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn3.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private void btn4ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn4.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					this.correctTransfer();
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn4.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn4.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private void btn5ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn5.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					this.correctTransfer();
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn5.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn5.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private void btn6ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn6.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					this.correctTransfer();
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn6.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn6.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private void btn7ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn7.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					this.correctTransfer();
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn7.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn7.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private void btn8ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn8.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					this.correctTransfer();
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn8.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn8.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private void btn9ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn9.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					this.correctTransfer();
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn9.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn9.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private void btn0ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (confirmation) {
			if (transferPinCounter == 0)
				pinLoader.setText("");
			pinLoader.setText(pinLoader.getText() + "*");
			transferPin[transferPinCounter++] = btn0.getText().charAt(0);
			if (transferPinCounter > 3) {
				if (Arrays.equals(transferPin, this.user.getPin())) {
					correctTransfer = true;
					dispose();
					JOptionPane.showMessageDialog(this, "Transfer successful!", "Transfer completed",
							JOptionPane.INFORMATION_MESSAGE);
					this.correctTransfer();
					Index index = new Index(user);
					index.setLocationRelativeTo(null);
					index.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
					pinLoader.setText("");
					transferPinCounter = 0;
				}
			}
		}
		if ((pinCounter == 4) && (!confirmation))
			pinLoader.setText("");
		if (confirmed && !confirmation) {
			prevDigit = pin[pinArrayCnt];
			if (prevDigit != btn0.getText().charAt(0)) {
				confirmed = false;
				pinCounter = 4;
				pinArrayCnt = 0;
				incorrectPin = true;
				JOptionPane.showMessageDialog(this, "PIN INCORRECT " + "TRY AGAIN", "ERROR", JOptionPane.OK_OPTION);
				pinLoader.setText("");
			}
		}
		if (!incorrectPin && !confirmation) {
			pinCounter--;
			pin[pinArrayCnt] = btn0.getText().charAt(0);
			pinLoader.setText(pinLoader.getText() + "*");
			pinArrayCnt++;
			if ((pinCounter == 0) && (!confirmed)) {
				pinCounter = 4;
				confirmed = true;
				JOptionPane.showMessageDialog(this, "CONFIRM PIN", "Confirmation", JOptionPane.PLAIN_MESSAGE);
				pinLoader.setText("");
				pinArrayCnt = 0;
			} else if ((pinCounter == 0) && (confirmed)) {
				user.setPin(pin);
				connection.insertData(user);
				dispose();
				Index index = new Index(user);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			}
		}
		incorrectPin = false;
	}

	private boolean correctTransfer() {
		this.dispose();
		BigDecimal subtract = new BigDecimal(amount);
		BigDecimal balance = this.user.getBalance();
		this.user.setBalance(balance.subtract(subtract));
		connection.updateBalance(user);
		connection.addFundsToRecipeint(amount, recipientAccount);
		return correctTransfer;
	}

	private javax.swing.JButton btn0;
	private javax.swing.JButton btn1;
	private javax.swing.JButton btn2;
	private javax.swing.JButton btn3;
	private javax.swing.JButton btn4;
	private javax.swing.JButton btn5;
	private javax.swing.JButton btn6;
	private javax.swing.JButton btn7;
	private javax.swing.JButton btn8;
	private javax.swing.JButton btn9;
	private javax.swing.JLabel pinLabel;
	private javax.swing.JLabel pinLoader;

}
