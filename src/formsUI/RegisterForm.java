/**
 *
 * @author Josip Begic
 */
package formsUI;

import java.awt.Color;
import javax.swing.*;
import lib.DbConnection;
import lib.User;

import java.awt.event.*;

public class RegisterForm extends JFrame {
	private static final long serialVersionUID = 3874853855468027526L;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	protected String usernameInput;
	protected String surnameInput;
	protected String nameInput;
	protected String mailInput;
	private boolean first = true;
	private DbConnection connection = new DbConnection();

	public RegisterForm() {
		initComponents();
	}

	private void initComponents() {

		surnameLabel = new JLabel();
		nameLabel = new JLabel();
		usernameLabel = new JLabel();
		mailLabel = new JLabel();
		surname = new JFormattedTextField();
		firstName = new JFormattedTextField();
		username = new JFormattedTextField();
		mail = new JFormattedTextField();
		validate = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		surnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		surnameLabel.setText("Surname:");

		nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		nameLabel.setText("First name:");

		usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		usernameLabel.setText("Username:");

		mailLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		mailLabel.setText("Mail:");

		surname.setForeground(new java.awt.Color(153, 153, 153));
		surname.setText("Surname");
		surname.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt) {
				surnameFocusGained(evt);
			}

			public void focusLost(FocusEvent evt) {
				surnameFocusLost(evt);
			}
		});

		firstName.setForeground(new java.awt.Color(153, 153, 153));
		firstName.setText("First name");
		firstName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt) {
				firstNameFocusGained(evt);
			}

			public void focusLost(FocusEvent evt) {
				firstNameFocusLost(evt);
			}
		});
		firstName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				actionPerformed(evt);
			}
		});

		username.setForeground(new java.awt.Color(153, 153, 153));
		username.setText("@username");
		username.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt) {
				usernameFocusGained(evt);
			}

			public void focusLost(FocusEvent evt) {
				usernameFocusLost(evt);
			}
		});
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				actionPerformed(evt);
			}
		});

		mail.setForeground(new java.awt.Color(153, 153, 153));
		mail.setText("example@mail.com");
		mail.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
		mail.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt) {
				mailFocusGained(evt);
			}

			public void focusLost(FocusEvent evt) {
				mailFocusLost(evt);
			}
		});
		mail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				actionPerformed(evt);
			}
		});

		validate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		validate.setText("Validate");
		validate.setEnabled(false);
		validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				validateActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(validate, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addGap(43, 43, 43))
				.addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
								.addComponent(mailLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(mail, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(usernameLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(username, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(surnameLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(surname, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addComponent(nameLabel).addGap(18, 18, 18)
								.addComponent(firstName, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(165, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(45, 45, 45)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(surnameLabel).addComponent(surname, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(nameLabel).addComponent(firstName, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(usernameLabel).addComponent(username, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(mailLabel).addComponent(mail, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
								.addComponent(validate).addGap(41, 41, 41)));

		pack();
	}

	private void surnameFocusGained(FocusEvent evt) {
		if (first)
			surname.setText("");
		surname.setForeground(Color.black);
	}

	private void firstNameFocusGained(FocusEvent evt) {
		if (first)
			firstName.setText("");
		firstName.setForeground(Color.black);
	}

	private void usernameFocusGained(FocusEvent evt) {
		if (first)
			username.setText("");
		username.setForeground(Color.black);
	}

	private void mailFocusGained(FocusEvent evt) {
		if (first)
			mail.setText("");
		mail.setForeground(Color.black);
		mail.setFont(new java.awt.Font("sansserif", 0, 12));
		validate.setEnabled(true);
	}

	private void validateActionPerformed(ActionEvent evt) {
		this.usernameInput = username.getText();
		this.mailInput = mail.getText();
		this.nameInput = firstName.getText();
		this.surnameInput = surname.getText();

		if (!mailInput.matches(EMAIL_PATTERN)) {
			JOptionPane.showMessageDialog(this, "Mail not valid", "Mail not valid", JOptionPane.PLAIN_MESSAGE);
			mail.setForeground(new java.awt.Color(153, 153, 153));
			mail.setText("example@mail.com");
		} else if (usernameInput.isBlank() || nameInput.isBlank() || surnameInput.isBlank()) {
			JOptionPane.showMessageDialog(this, "Form not valid", "Fill Form", JOptionPane.PLAIN_MESSAGE);
		} else if (!connection.checkUsername(usernameInput)) {
			JOptionPane.showMessageDialog(this, "Username already taken", "Enter new Username",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			User user = new User(surnameInput, nameInput, mailInput, usernameInput);
			dispose();
			PinForm pinWindow = new PinForm(user, false);
			pinWindow.setLocationRelativeTo(null);
			pinWindow.setTitle("TYPE PIN");
			pinWindow.setVisible(true);
		}
	}

	private void surnameFocusLost(FocusEvent evt) {
		this.surnameInput = surname.getText();
	}

	private void firstNameFocusLost(FocusEvent evt) {
		this.nameInput = firstName.getText();
	}

	private void usernameFocusLost(FocusEvent evt) {
		this.usernameInput = username.getText();
		if (!connection.checkUsername(usernameInput)) {
			JOptionPane.showMessageDialog(this, "Username already taken", "Enter new Username",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void mailFocusLost(FocusEvent evt) {
		this.mailInput = mail.getText();
	}

	private JFormattedTextField firstName;
	private JFormattedTextField mail;
	private JLabel mailLabel;
	private JLabel nameLabel;
	private JFormattedTextField surname;
	private JLabel surnameLabel;
	private JFormattedTextField username;
	private JLabel usernameLabel;
	private JButton validate;

}
