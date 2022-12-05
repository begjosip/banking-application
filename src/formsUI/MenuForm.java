/**
 * 
 * @author Josip Begic
 */

package formsUI;

import javax.swing.JFrame;

public class MenuForm extends JFrame {
	private static final long serialVersionUID = -8177807346870145372L;

	public MenuForm() {
		initComponents();
	}

	private void initComponents() {

		title = new javax.swing.JLabel();
		loginButton = new javax.swing.JButton();
		registerButton = new javax.swing.JButton();
		versionText = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(new java.awt.Color(219, 250, 245));
		title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		title.setLabelFor(this);
		title.setText("Banking Application");
		title.setName("Banking Application"); // NOI18N

		loginButton.setBackground(new java.awt.Color(102, 153, 255));
		loginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		loginButton.setForeground(new java.awt.Color(255, 255, 255));
		loginButton.setText("Login");
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginButtonActionPerformed(evt);
			}
		});

		registerButton.setBackground(new java.awt.Color(102, 153, 255));
		registerButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		registerButton.setForeground(new java.awt.Color(255, 255, 255));
		registerButton.setText("Register");
		registerButton.setToolTipText("");
		registerButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerButtonActionPerformed(evt);
			}
		});

		versionText.setForeground(new java.awt.Color(204, 204, 204));
		versionText.setText("version 1.0.0");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(82, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(38, 38, 38).addComponent(registerButton,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(title))
								.addGap(81, 81, 81))
				.addGroup(layout.createSequentialGroup().addGap(170, 170, 170).addComponent(versionText)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(66, 66, 66)
				.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(42, 42, 42)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(registerButton).addComponent(loginButton))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
				.addComponent(versionText).addContainerGap()));

		pack();
	}

	private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
		LoginForm loginwindow = new LoginForm();
		loginwindow.setLocationRelativeTo(null);
		loginwindow.setTitle("Login");
		loginwindow.setVisible(true);
		loginwindow.requestFocus();
	}

	private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
		RegisterForm registerWindows = new RegisterForm();
		registerWindows.setLocationRelativeTo(null);
		registerWindows.setTitle("Register");
		registerWindows.setVisible(true);
		registerWindows.requestFocus();
	}

	private javax.swing.JButton loginButton;
	private javax.swing.JButton registerButton;
	private javax.swing.JLabel title;
	private javax.swing.JLabel versionText;

}
