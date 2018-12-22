package TheFinder;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class registerForm {
	
	private JFrame registerFrame;
	private JPasswordField rfPasswordTxt;
	private JTextField rfUsernameTxt;
	private JTextField rfNameTxt;
	private JTextField rfPhoneTxt;
	private JTextField rfAddressTxt;
	private JTextField rfEmailTxt;
	
	UserService us = new UserService();
		
	/**
	 * Create the application.
	 */
	public registerForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setRegisterFrame(new JFrame());
		getRegisterFrame().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ammsb\\Desktop\\lenteingrandimento7-512.png"));
		getRegisterFrame().setTitle("The Finder - Register");
		getRegisterFrame().setBounds(100, 100, 440, 331);
		getRegisterFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRegisterFrame().getContentPane().setLayout(null);
		
		JLabel registerLbl = new JLabel("Register");
		registerLbl.setFont(new Font("Consolas", Font.PLAIN, 20));
		registerLbl.setBounds(169, 23, 88, 32);
		getRegisterFrame().getContentPane().add(registerLbl);
		
		JLabel rfUsernameLbl = new JLabel("UserName: ");
		rfUsernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rfUsernameLbl.setBounds(45, 66, 80, 28);
		getRegisterFrame().getContentPane().add(rfUsernameLbl);
		
		JLabel rfNameLbl = new JLabel("Name: ");
		rfNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rfNameLbl.setBounds(45, 95, 62, 28);
		getRegisterFrame().getContentPane().add(rfNameLbl);
		
		JLabel rfPhoneLbl = new JLabel("Phone: ");
		rfPhoneLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rfPhoneLbl.setBounds(45, 124, 56, 28);
		getRegisterFrame().getContentPane().add(rfPhoneLbl);
		
		JLabel rfAddressLbl = new JLabel("Address: ");
		rfAddressLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rfAddressLbl.setBounds(45, 153, 62, 28);
		getRegisterFrame().getContentPane().add(rfAddressLbl);
		
		JLabel rfEmailLbl = new JLabel("Email: ");
		rfEmailLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rfEmailLbl.setBounds(45, 182, 56, 28);
		getRegisterFrame().getContentPane().add(rfEmailLbl);
		
		JLabel rfPasswordLbl = new JLabel("Password: ");
		rfPasswordLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rfPasswordLbl.setBounds(45, 211, 67, 28);
		getRegisterFrame().getContentPane().add(rfPasswordLbl);
		
		rfPasswordTxt = new JPasswordField();
		rfPasswordTxt.setToolTipText("Enter your password");
		rfPasswordTxt.setBounds(124, 212, 220, 28);
		getRegisterFrame().getContentPane().add(rfPasswordTxt);
		
		rfUsernameTxt = new JTextField();
		rfUsernameTxt.setToolTipText("Enter your username");
		rfUsernameTxt.setBounds(124, 67, 220, 28);
		getRegisterFrame().getContentPane().add(rfUsernameTxt);
		rfUsernameTxt.setColumns(10);
		
		setNameTxt(new JTextField());
		getNameTxt().setBounds(124, 96, 220, 28);
		getRegisterFrame().getContentPane().add(getNameTxt());
		getNameTxt().setColumns(10);
		
		rfPhoneTxt = new JTextField();
		rfPhoneTxt.setToolTipText("Enter your phone number");
		rfPhoneTxt.setBounds(124, 125, 220, 28);
		getRegisterFrame().getContentPane().add(rfPhoneTxt);
		rfPhoneTxt.setColumns(10);
		
		rfAddressTxt = new JTextField();
		rfAddressTxt.setToolTipText("Enter your address");
		rfAddressTxt.setBounds(124, 154, 220, 28);
		getRegisterFrame().getContentPane().add(rfAddressTxt);
		rfAddressTxt.setColumns(10);
		
		rfEmailTxt = new JTextField();
		rfEmailTxt.setToolTipText("Enter your email address");
		rfEmailTxt.setBounds(124, 183, 220, 28);
		getRegisterFrame().getContentPane().add(rfEmailTxt);
		rfEmailTxt.setColumns(10);
		
		JButton rfRegisterBtn = new JButton("Register");
		rfRegisterBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		rfRegisterBtn.setToolTipText("Submit your data");
		rfRegisterBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(rfUsernameTxt.getText().length() == 0)
				{
					JOptionPane optionPane = new JOptionPane("Please enter your username",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else if(getNameTxt().getText().length() == 0)
				{
					JOptionPane optionPane = new JOptionPane("Please enter your name",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else if(rfPhoneTxt.getText().length() == 0)
				{
					JOptionPane optionPane = new JOptionPane("Please enter your phone number",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else if(rfAddressTxt.getText().length() == 0)
				{
					JOptionPane optionPane = new JOptionPane("Please enter your address",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else if(rfEmailTxt.getText().length() == 0 || rfEmailTxt.getText().indexOf('@') > rfEmailTxt.getText().indexOf('.') || rfEmailTxt.getText().indexOf('@') == -1 || rfEmailTxt.getText().indexOf('.') == -1)
				{
					JOptionPane optionPane = new JOptionPane("Please enter your valid email",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else if(rfPasswordTxt.getPassword().length < 8)
				{
					JOptionPane optionPane = new JOptionPane("Your password must be 8 letters at minimum",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else
				{
					profileForm.currentUsername = getNameTxt().getText();
					profileForm.currentUserID = rfUsernameTxt.getText();
					
					if(us.register(rfUsernameTxt.getText(), getNameTxt().getText(), rfPhoneTxt.getText(), rfAddressTxt.getText(), rfEmailTxt.getText(), rfPasswordTxt.getPassword().toString()))
					{
						JOptionPane optionPane = new JOptionPane("Register successful",JOptionPane.INFORMATION_MESSAGE);
						JDialog dialog = optionPane.createDialog("Done!");
						dialog.setAlwaysOnTop(true); // to show top of all other application
						dialog.setVisible(true); // to visible the dialog
						
						profileForm window = new profileForm();
						window.getProfileFrame().setVisible(true);
						
						registerFrame.hide();
					}
					else
					{
						JOptionPane optionPane = new JOptionPane("Your account is already existed",JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionPane.createDialog("Error!");
						dialog.setAlwaysOnTop(true); // to show top of all other application
						dialog.setVisible(true); // to visible the dialog
					}
				}		
			}
		});
		rfRegisterBtn.setBounds(165, 252, 97, 32);
		getRegisterFrame().getContentPane().add(rfRegisterBtn);
		
		JButton rfBackBtn = new JButton("<< Back");
		rfBackBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		rfBackBtn.setToolTipText("back to the previous window");
		rfBackBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				welcomeForm window = new welcomeForm();
				window.getWelcomeFrame().setVisible(true);
				
				registerFrame.hide();
			}
		});
		rfBackBtn.setBounds(10, 13, 97, 25);
		getRegisterFrame().getContentPane().add(rfBackBtn);
	}

	public JFrame getRegisterFrame() {
		return registerFrame;
	}

	public void setRegisterFrame(JFrame registerFrame) {
		this.registerFrame = registerFrame;
		registerFrame.setResizable(false);
		registerFrame.getContentPane().setBackground(UIManager.getColor("ArrowButton.background"));
		registerFrame.getContentPane().setForeground(SystemColor.control);
	}

	public JTextField getNameTxt() {
		return rfNameTxt;
	}

	public void setNameTxt(JTextField nameTxt) {
		this.rfNameTxt = nameTxt;
		nameTxt.setToolTipText("Enter your name");
	}
}