/**
 *
 * @author Josip Begic
 */

package formsUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lib.DbConnection;
import lib.User;

public class TransferForm extends JFrame {
	private static final long serialVersionUID = 1508700759389473415L;

	private DbConnection connection = new DbConnection();
	private User user;

	public TransferForm(User activeUser) {
		initComponents();
		this.user = (User) activeUser;
	}

	private boolean first = true;
	private boolean firstAmount = true;

	private void initComponents() {

		recipientLabel = new javax.swing.JLabel();
		accountNumber = new javax.swing.JTextField();
		signHR = new javax.swing.JLabel();
		amountLabel = new javax.swing.JLabel();
		transferAmount = new javax.swing.JTextField();
		transferBtn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		recipientLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
		recipientLabel.setText("Account number of  recipient:");

		accountNumber.setFont(new java.awt.Font("Segoe UI", 1, 12));
		accountNumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		accountNumber.setText("12345678");
		accountNumber.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				accountNumberFocusGained(evt);
			}
		});
		accountNumber.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				accountNumberActionPerformed(evt);
			}
		});

		signHR.setFont(new java.awt.Font("Segoe UI", 1, 12));
		signHR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		signHR.setText("HR -");

		amountLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
		amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		amountLabel.setText("Amount:");

		transferAmount.setText("00,00");
		transferAmount.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				transferAmountFocusGained(evt);
			}
		});

		transferBtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
		transferBtn.setText("TRANSFER");
		transferBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					transferBtnActionPerformed(evt);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(40, Short.MAX_VALUE).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addComponent(amountLabel)
														.addGap(18, 18, 18).addComponent(transferAmount))
										.addComponent(recipientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(signHR, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(accountNumber, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(56, 56, 56)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(38, 38, 38)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(recipientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(accountNumber, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(signHR, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(79, 79, 79)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(transferAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
						.addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(45, 45, 45)));

		pack();
	}

	private void accountNumberActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void accountNumberFocusGained(java.awt.event.FocusEvent evt) {
		if (first) {
			this.accountNumber.setText("");
		}
		first = false;
	}

	private void transferAmountFocusGained(java.awt.event.FocusEvent evt) {
		if (firstAmount) {
			this.transferAmount.setText("");
		}
		firstAmount = false;
	}

	private void transferBtnActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
		String recipientAcc = "HR-";
		recipientAcc += accountNumber.getText().trim();
		String amount = transferAmount.getText();
		if (amount.contains(","))
			amount = amount.replace(",", ".");
		if (!amount.matches("(?<=^| )\\d+(\\.\\d+)?(?=$| )")) {
			JOptionPane.showMessageDialog(this, "Invalid transfer amount", "Invalid amount", JOptionPane.PLAIN_MESSAGE);
			transferAmount.setText("");
		} else {
			JFrame frame = connection.transfer(recipientAcc, amount, this.user);
			if (frame != null) {
				if (frame instanceof PinForm) {
					dispose();
					PinForm pinForm = (PinForm) frame;
					pinForm.setVisible(true);
					pinForm.setLocationRelativeTo(null);
				}
			} else {
				dispose();
				TransferForm transferFrame = new TransferForm(user);
				transferFrame.setVisible(true);
				transferFrame.setLocationRelativeTo(null);
			}
		}
	}

	private javax.swing.JTextField accountNumber;
	private javax.swing.JLabel amountLabel;
	private javax.swing.JLabel recipientLabel;
	private javax.swing.JLabel signHR;
	private javax.swing.JTextField transferAmount;
	private javax.swing.JButton transferBtn;
}
