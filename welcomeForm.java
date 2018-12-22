package TheFinder;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class welcomeForm {

	private JFrame welcomeFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				try {
					welcomeForm window = new welcomeForm();
					window.getWelcomeFrame().setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Connection connect()
	{
		Connection con = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:\\FCI\\lvl 3\\SWE\\project\\TheFinderDB.db");
			//System.out.println("Connected Successfully");
		}catch(Exception e)
		{
			System.out.println("Failed to connect");
		}
		return con;
	}		


	/**
	 * Create the application.
	 */
	public welcomeForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setWelcomeFrame(new JFrame());
		getWelcomeFrame().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ammsb\\Desktop\\lenteingrandimento7-512.png"));
		getWelcomeFrame().setTitle("The Finder - Welcome");
		getWelcomeFrame().getContentPane().setBackground(UIManager.getColor("ArrowButton.background"));
		getWelcomeFrame().setBounds(100, 100, 450, 180);
		getWelcomeFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getWelcomeFrame().getContentPane().setLayout(null);
		
		JLabel welcomeLbl = new JLabel("Welcome to The Finder");
		welcomeLbl.setFont(new Font("Consolas", Font.BOLD, 24));
		welcomeLbl.setBounds(79, 13, 273, 54);
		getWelcomeFrame().getContentPane().add(welcomeLbl);
		
		JButton wfRegisterBtn = new JButton("Register");
		wfRegisterBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		wfRegisterBtn.setToolTipText("Make a new account");
		wfRegisterBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				registerForm window = new registerForm();
				window.getRegisterFrame().setVisible(true);
				
				getWelcomeFrame().hide();
			}
		});
		wfRegisterBtn.setBounds(79, 80, 97, 32);
		getWelcomeFrame().getContentPane().add(wfRegisterBtn);
		
		JButton wfLoginBtn = new JButton("Login");
		wfLoginBtn.setPreferredSize(new Dimension(75, 28));
		wfLoginBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		wfLoginBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				loginForm window = new loginForm();
				window.getLoginFrame().setVisible(true);
				
				getWelcomeFrame().hide();
			}
		});
		wfLoginBtn.setToolTipText("Login with an existed account");
		wfLoginBtn.setBounds(264, 80, 97, 32);
		getWelcomeFrame().getContentPane().add(wfLoginBtn);
	}

	public JFrame getWelcomeFrame() {
		return welcomeFrame;
	}

	public void setWelcomeFrame(JFrame welcomeFrame) {
		this.welcomeFrame = welcomeFrame;
		welcomeFrame.setResizable(false);
		welcomeFrame.getContentPane().setForeground(SystemColor.control);
	}
}
