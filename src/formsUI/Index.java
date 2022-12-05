/**
 *
 * @author Josip Begic
 */

package formsUI;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;

import lib.User;

public class Index extends JFrame {
	private static final long serialVersionUID = 7042840663341566122L;

	private User activeUser;

	public Index(User activeUser) {
		this.activeUser = (User) activeUser;
		initComponents();
	}

	private void initComponents() {

		fullNameLabel = new javax.swing.JLabel();
		usernameLabel = new javax.swing.JLabel();
		accLabel = new javax.swing.JLabel();
		accountNumber = new javax.swing.JLabel();
		balanceLabel = new javax.swing.JLabel();
		balanceValue = new javax.swing.JLabel();
		logoutButton = new javax.swing.JButton();
		depositBtn = new javax.swing.JButton();
		transferBtn = new javax.swing.JButton();
		hideBalanceBtn = new javax.swing.JRadioButton();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		fullNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
		fullNameLabel.setText(activeUser.getFirstName() + " " + activeUser.getSurname());

		usernameLabel.setForeground(new java.awt.Color(102, 102, 102));
		usernameLabel.setText("@" + activeUser.getUsername());

		accLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
		accLabel.setText("Account number:");

		accountNumber.setFont(new java.awt.Font("Segoe UI", 1, 12));
		accountNumber.setText(activeUser.printAccountNumber(activeUser.getAccountNumber()));

		balanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
		balanceLabel.setText("Balance (EUR):");

		balanceValue.setFont(new java.awt.Font("Segoe UI", 1, 12));
		balanceValue.setText(activeUser.balanceToString());

		logoutButton.setText("LOGOUT");
		logoutButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logoutButtonActionPerformed(evt);
			}
		});

		depositBtn.setText("DEPOSIT");
		depositBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				depositBtnActionPerformed(evt);
			}
		});

		transferBtn.setText("TRANSFER");
		transferBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				transferBtnActionPerformed(evt);
			}
		});

		hideBalanceBtn.setText("Hide balance");
		hideBalanceBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				hideBalanceBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(31, 31, 31).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(logoutButton)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(fullNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 348,
												Short.MAX_VALUE)
										.addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(layout.createSequentialGroup().addGap(21, 21, 21).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(depositBtn).addGap(18, 18, 18)
										.addComponent(transferBtn))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(balanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(accLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(accountNumber)
												.addGroup(layout.createSequentialGroup()
														.addComponent(balanceValue,
																javax.swing.GroupLayout.PREFERRED_SIZE, 110,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(hideBalanceBtn,
																javax.swing.GroupLayout.PREFERRED_SIZE, 98,
																javax.swing.GroupLayout.PREFERRED_SIZE)))))))
				.addContainerGap(21, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(17, 17, 17).addComponent(fullNameLabel)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(usernameLabel)
				.addGap(26, 26, 26)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(accLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(accountNumber))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(balanceValue, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(hideBalanceBtn))
				.addGap(26, 26, 26)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(depositBtn).addComponent(transferBtn))
				.addGap(54, 54, 54).addComponent(logoutButton).addGap(20, 20, 20)));

		pack();
	}

	private void transferBtnActionPerformed(ActionEvent evt) {
		TransferForm transfer = new TransferForm(activeUser);
		transfer.setLocationRelativeTo(null);
		transfer.setVisible(true);
		dispose();
	}

	private void depositBtnActionPerformed(ActionEvent evt) {
		dispose();
		DepositForm depositForm = new DepositForm(activeUser);
		depositForm.setLocationRelativeTo(null);
		depositForm.setVisible(true);
	}

	private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
		activeUser = null;
		dispose();
		MenuForm login = new MenuForm();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
	}

	private void hideBalanceBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (hideBalanceBtn.isSelected()) {
			balanceValue.setText("****");
			hideBalanceBtn.setText("Show balance");
		} else if (balanceValue.getText().equals("****")) {
			balanceValue.setText(activeUser.balanceToString());
			hideBalanceBtn.setText("Hide balance");
		}
	}

	private javax.swing.JLabel accLabel;
	private javax.swing.JLabel accountNumber;
	private javax.swing.JLabel balanceLabel;
	private javax.swing.JLabel balanceValue;
	private javax.swing.JButton depositBtn;
	private javax.swing.JLabel fullNameLabel;
	private javax.swing.JRadioButton hideBalanceBtn;
	private javax.swing.JButton logoutButton;
	private javax.swing.JButton transferBtn;
	private javax.swing.JLabel usernameLabel;

}
