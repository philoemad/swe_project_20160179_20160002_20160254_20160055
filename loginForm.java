package TheFinder;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class loginForm {

	private JFrame loginFrame;
	JTextField lfUsernameTxt;
	JPasswordField lfPasswordTxt;
	
	UserService us = new UserService();

	/**
	 * Create the application.
	 */
	public loginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLoginFrame(new JFrame());
		getLoginFrame().getContentPane().setBackground(UIManager.getColor("ArrowButton.background"));
		getLoginFrame().getContentPane().setForeground(SystemColor.control);
		getLoginFrame().setTitle("The Finder - Login");
		getLoginFrame().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ammsb\\Desktop\\lenteingrandimento7-512.png"));
		getLoginFrame().setBounds(100, 100, 450, 226);
		getLoginFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getLoginFrame().getContentPane().setLayout(null);

		JLabel loginLbl = new JLabel("Login");
		loginLbl.setFont(new Font("Consolas", Font.PLAIN, 20));
		loginLbl.setBounds(188, 13, 56, 24);
		getLoginFrame().getContentPane().add(loginLbl);

		JLabel lfUsernameLbl = new JLabel("Username: ");
		lfUsernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lfUsernameLbl.setBounds(48, 61, 70, 28);
		getLoginFrame().getContentPane().add(lfUsernameLbl);

		JLabel lfPasswordLbl = new JLabel("Password: ");
		lfPasswordLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lfPasswordLbl.setBounds(48, 93, 70, 28);
		getLoginFrame().getContentPane().add(lfPasswordLbl);

		lfUsernameTxt = new JTextField();
		lfUsernameTxt.setToolTipText("Enter your username");
		lfUsernameTxt.setBounds(130, 62, 220, 28);
		loginFrame.getContentPane().add(lfUsernameTxt);
		lfUsernameTxt.setColumns(10);

		lfPasswordTxt = new JPasswordField();
		lfPasswordTxt.setToolTipText("Enter your password");
		lfPasswordTxt.setBounds(130, 94, 220, 28);
		getLoginFrame().getContentPane().add(lfPasswordTxt);

		JButton lfLoginBtn = new JButton("Login");
		lfLoginBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		lfLoginBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if(lfUsernameTxt.getText().length() == 0)
				{
					JOptionPane optionPane = new JOptionPane("Please enter your username",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else if(lfPasswordTxt.getPassword().length < 8)
				{
					JOptionPane optionPane = new JOptionPane("Your password must be 8 letters at minimum",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else
				{
					profileForm.currentUserID = lfUsernameTxt.getText();

					if(us.login(lfUsernameTxt.getText(), lfPasswordTxt.getPassword().toString()))
					{
						JOptionPane optionPane = new JOptionPane("Login successful",JOptionPane.INFORMATION_MESSAGE);
						JDialog dialog = optionPane.createDialog("Done!");
						dialog.setAlwaysOnTop(true); // to show top of all other application
						dialog.setVisible(true); // to visible the dialog

						profileForm window = new profileForm();
						window.getProfileFrame().setVisible(true);

						loginFrame.hide();
					}
					else
					{
						JOptionPane optionPane = new JOptionPane("Your account is not existed",JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionPane.createDialog("Error!");
						dialog.setAlwaysOnTop(true); // to show top of all other application
						dialog.setVisible(true); // to visible the dialog
					}					
				}

			}
		});
		lfLoginBtn.setToolTipText("Login to the system");
		lfLoginBtn.setBounds(169, 142, 97, 32);
		getLoginFrame().getContentPane().add(lfLoginBtn);

		JButton lfBackBtn = new JButton("<< Back");
		lfBackBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		lfBackBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				welcomeForm window = new welcomeForm();
				window.getWelcomeFrame().setVisible(true);

				loginFrame.hide();

			}
		});
		lfBackBtn.setToolTipText("back to the previous window");
		lfBackBtn.setBounds(12, 13, 97, 25);
		getLoginFrame().getContentPane().add(lfBackBtn);

	}

	public JFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(JFrame loginFrame) {
		this.loginFrame = loginFrame;
		loginFrame.setResizable(false);
	}

	public JTextField getLfUsernameTxt() {
		return lfUsernameTxt;
	}

	public void setLfUsernameTxt(JTextField lfUsernameTxt) {
		this.lfUsernameTxt = lfUsernameTxt;
	}
}