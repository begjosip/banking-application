/**
 *
 * @author Josip Begic
 */
package formsUI;

import java.awt.Color;
import javax.swing.*;

import lib.DbConnection;
import lib.User;

public class LoginForm extends JFrame {
	private static final long serialVersionUID = 5964972034904903243L;

	protected String usernameInput;
	protected String pinInput;
	private DbConnection connection = new DbConnection();
	private User activeuser;

	public LoginForm() {
		initComponents();
	}

	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		username = new javax.swing.JFormattedTextField();
		usernameLabel = new javax.swing.JLabel();
		pinLabel = new javax.swing.JLabel();
		pin = new javax.swing.JPasswordField();
		login = new javax.swing.JButton();

		jTextField1.setText("jTextField1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		username.setForeground(new java.awt.Color(204, 204, 204));
		username.setText("@username");
		username.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				usernameFocusGained(evt);
			}
		});
		usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		usernameLabel.setText("Username:");

		pinLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		pinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		pinLabel.setText("PIN");

		pin.setColumns(9);
		pin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		pin.setText("xxxx");
		pin.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				pinFocusGained(evt);
			}
		});

		login.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
		login.setText("LOGIN");
		login.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup().addGap(65, 125, Short.MAX_VALUE).addComponent(pinLabel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(usernameLabel)))
						.addGap(35, 35, 35)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pin, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(84, 84, 84))
				.addGroup(layout.createSequentialGroup().addGap(170, 170, 170)
						.addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(101, 101, 101)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(usernameLabel))
								.addGap(43, 43, 43))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(pinLabel).addComponent(pin, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(18, 18, 18).addComponent(login).addContainerGap(92, Short.MAX_VALUE)));

		pack();
	}

	private void usernameFocusGained(java.awt.event.FocusEvent evt) {
		username.setText("");
		username.setForeground(Color.black);
	}

	// error
	private void loginActionPerformed(java.awt.event.ActionEvent evt) {
		this.pinInput = new String(pin.getPassword());
		this.usernameInput = username.getText();
		if (usernameInput.isBlank()) {
			JOptionPane.showMessageDialog(this, "Username cannot be blank", "Wrong Username",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			// PIN and username verification
			activeuser = (User) connection.validation(usernameInput, pinInput);
			if (activeuser != null) {
				dispose();
				Index index = new Index(activeuser);
				index.setLocationRelativeTo(null);
				index.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Incorrect username or PIN", "Wrong Username or PIN",
						JOptionPane.PLAIN_MESSAGE);
				username.setText("");
				pin.setText("");
			}
		}
	}

	private void pinFocusGained(java.awt.event.FocusEvent evt) {
		pin.setText("");
	}

	private javax.swing.JTextField jTextField1;
	private javax.swing.JButton login;
	private javax.swing.JPasswordField pin;
	private javax.swing.JLabel pinLabel;
	private javax.swing.JFormattedTextField username;
	private javax.swing.JLabel usernameLabel;

}
