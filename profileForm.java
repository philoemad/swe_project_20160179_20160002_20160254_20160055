package TheFinder;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class profileForm {

	public static String currentUsername;
	public static String currentUserID;
	private JFrame profileFrame;
	JLabel TimeLbl;
	JLabel DateLbl;
	JLabel pfVariablenameLbl;

	public void Date()
	{
		Thread date = new Thread() {
		
			public void run()
			{
				try {
					while(true)
					{
						Calendar cal = new GregorianCalendar();
						
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						
						DateLbl.setText("Date: " + day + "-" + (month+1) + "-" + year);
						
						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		date.start();
	}
	
	public void Time()
	{
		Thread time = new Thread() {
		
			public void run()
			{
				try {
					while(true)
					{
						Calendar cal = new GregorianCalendar();
						
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						
						TimeLbl.setText("Time: " + hour + ":" + minute + ":" + second);
						
						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		time.start();
	}
	
	public String getName(String ID){
		String sql = "SELECT Name FROM User WHERE ID = ?";

		try (Connection conn = welcomeForm.connect();
				PreparedStatement pstmt  = conn.prepareStatement(sql)){

			pstmt.setString(1, ID);
			return pstmt.executeQuery().getString("name");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Create the application.
	 */
	public profileForm() {
		initialize();
		Date();
		Time();
		//setUsername(loginForm.lfUsernameTxt.getText());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		currentUsername = getName(currentUserID);
		
		setProfileFrame(new JFrame());
		getProfileFrame().getContentPane().setBackground(UIManager.getColor("ArrowButton.background"));
		getProfileFrame().getContentPane().setForeground(SystemColor.control);
		getProfileFrame().setTitle("The Finder - User Profile");
		getProfileFrame().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ammsb\\Desktop\\lenteingrandimento7-512.png"));
		getProfileFrame().setBounds(100, 100, 1000, 700);
		getProfileFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profileFrame.getContentPane().setLayout(null);
		
		JLabel YourNameLbl = new JLabel("Your name:");
		YourNameLbl.setFont(new Font("Consolas", Font.PLAIN, 18));
		YourNameLbl.setBounds(55, 6, 117, 32);
		profileFrame.getContentPane().add(YourNameLbl);
		
		pfVariablenameLbl = new JLabel(currentUsername);
		pfVariablenameLbl.setBounds(55, 10, 400, 89);
		pfVariablenameLbl.setToolTipText("");
		pfVariablenameLbl.setFont(new Font("Consolas", Font.BOLD, 24));
				
		getProfileFrame().getContentPane().add(pfVariablenameLbl);
		
		JSeparator pfSeparator = new JSeparator();
		pfSeparator.setBounds(12, 97, 958, 2);
		getProfileFrame().getContentPane().add(pfSeparator);
		
		JButton pfPostBtn = new JButton("Post");
		pfPostBtn.setBounds(645, 60, 97, 32);
		pfPostBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		pfPostBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				kindForm window = new kindForm();
				window.getKindFrame().setVisible(true);
				
				profileFrame.hide();				
			}
		});
		pfPostBtn.setToolTipText("Create a post");
		getProfileFrame().getContentPane().add(pfPostBtn);
		
		JButton pfSearchBtn = new JButton("Search");
		pfSearchBtn.setBounds(754, 60, 97, 32);
		pfSearchBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		pfSearchBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				searchForm window = new searchForm();
				window.getSearchFrame().setVisible(true);
				
				profileFrame.hide();
				
			}
		});
		pfSearchBtn.setToolTipText("Search for a post");
		getProfileFrame().getContentPane().add(pfSearchBtn);
		
		JButton pfLogoutBtn = new JButton("Logout");
		pfLogoutBtn.setBounds(862, 60, 97, 32);
		pfLogoutBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		pfLogoutBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
				
				if(action == 0)
				{
					JOptionPane optionPane = new JOptionPane("You have successfully loged out",JOptionPane.INFORMATION_MESSAGE);
					JDialog dialog = optionPane.createDialog("Done!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
					
					welcomeForm window = new welcomeForm();
					window.getWelcomeFrame().setVisible(true);
					
					profileFrame.hide();
				}
			}
		});
		pfLogoutBtn.setToolTipText("Logout from your account");
		profileFrame.getContentPane().add(pfLogoutBtn);
		
		TimeLbl = new JLabel("");
		TimeLbl.setBounds(806, 10, 148, 28);
		TimeLbl.setFont(new Font("Consolas", Font.PLAIN, 16));
		profileFrame.getContentPane().add(TimeLbl);
		
		DateLbl = new JLabel("");
		DateLbl.setBounds(806, 31, 148, 28);
		DateLbl.setFont(new Font("Consolas", Font.PLAIN, 16));
		profileFrame.getContentPane().add(DateLbl);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Consolas", Font.PLAIN, 30));
		lblProfile.setBounds(401, 0, 139, 99);
		profileFrame.getContentPane().add(lblProfile);
	}

	public JFrame getProfileFrame() {
		return profileFrame;
	}

	public void setProfileFrame(JFrame profileFrame) {
		this.profileFrame = profileFrame;
	}
}