/**
 *
 * @author Josip Begic
 */
package formsUI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lib.DbConnection;
import lib.User;

public class DepositForm extends JFrame {
	private static final long serialVersionUID = 7371123260915795305L;

	private DbConnection connection = new DbConnection();
	private User activeUser;
	private static final BigDecimal euroRate = new BigDecimal("7.5345");

	public DepositForm(User activeuser) {
		this.activeUser = (User) activeuser;
		initComponents();
	}

	private void initComponents() {

		currencyCombo = new javax.swing.JComboBox<>();
		depositInput = new javax.swing.JTextField();
		depositBtn = new javax.swing.JButton();
		feeText = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		currencyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EUR", "HRK" }));
		currencyCombo.setFont(new java.awt.Font("Segoe UI", 1, 12));
		depositInput.setText("00,00");
		depositInput.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				depositInputActionPerformed(evt);
			}
		});

		depositBtn.setText("DEPOSIT");
		depositBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				depositBtnActionPerformed(evt);
			}
		});

		feeText.setForeground(new java.awt.Color(102, 102, 102));
		feeText.setText("no fee");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(93, 93, 93)
								.addComponent(currencyCombo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(depositInput, javax.swing.GroupLayout.PREFERRED_SIZE, 133,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(feeText))
						.addGroup(layout.createSequentialGroup().addGap(150, 150, 150).addComponent(depositBtn,
								javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(44, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(126, 126, 126)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(depositInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(currencyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(feeText))
						.addGap(43, 43, 43).addComponent(depositBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(65, Short.MAX_VALUE)));
		pack();
	}

	private void depositInputActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void depositBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int currency = currencyCombo.getSelectedIndex();
		String value = depositInput.getText();
		if (value.contains(","))
			value = value.replace(",", ".");
		if (!value.matches("(?<=^| )\\d+(\\.\\d+)?(?=$| )")) {
			JOptionPane.showMessageDialog(this, "Type only numbers", "Invalid amount", JOptionPane.PLAIN_MESSAGE);
			depositInput.setText("00,00");
		} else {
			if (currency == 0) {
				BigDecimal depositValue = new BigDecimal(value);
				BigDecimal sum = activeUser.getBalance().add(depositValue);
				activeUser.setBalance(sum);
				connection.updateBalance(activeUser);
			} else {
				BigDecimal depositValue = new BigDecimal(value);
				depositValue = depositValue.divide(euroRate, 4, RoundingMode.HALF_DOWN);
				BigDecimal sum = activeUser.getBalance().add(depositValue);
				activeUser.setBalance(sum);
				connection.updateBalance(activeUser);
			}
			dispose();
			Index index = new Index(activeUser);
			index.setLocationRelativeTo(null);
			index.setVisible(true);
		}
	}

	private javax.swing.JComboBox<String> currencyCombo;
	private javax.swing.JButton depositBtn;
	private javax.swing.JTextField depositInput;
	private javax.swing.JLabel feeText;
}
