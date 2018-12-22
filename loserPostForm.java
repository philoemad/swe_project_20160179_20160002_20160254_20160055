package TheFinder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class loserPostForm {

	private JFrame loserPostFrame;

	/**
	 * Create the application.
	 */
	public loserPostForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLoserPostFrame(new JFrame());
		getLoserPostFrame().setTitle("The Finder - Post");
		getLoserPostFrame().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ammsb\\Desktop\\lenteingrandimento7-512.png"));
		getLoserPostFrame().setBounds(100, 100, 864, 321);
		getLoserPostFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getLoserPostFrame().getContentPane().setLayout(null);
		
		JLabel lpfCreateAPostLbl = new JLabel("Create a post");
		lpfCreateAPostLbl.setFont(new Font("Consolas", Font.BOLD, 18));
		lpfCreateAPostLbl.setBounds(346, 13, 136, 22);
		getLoserPostFrame().getContentPane().add(lpfCreateAPostLbl);
		
		JLabel lpfPostContentLbl = new JLabel("Post Content: ");
		lpfPostContentLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lpfPostContentLbl.setBounds(76, 64, 90, 22);
		getLoserPostFrame().getContentPane().add(lpfPostContentLbl);
		
		JTextArea lpfTextArea = new JTextArea();
		lpfTextArea.setToolTipText("Write your post here");
		lpfTextArea.setBounds(76, 99, 700, 100);
		getLoserPostFrame().getContentPane().add(lpfTextArea);
		
		JButton lpfPostBtn = new JButton("Post");
		lpfPostBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		lpfPostBtn.setToolTipText("Submit your post");
		lpfPostBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(lpfTextArea.getText().length() == 0)
				{
					JOptionPane optionPane = new JOptionPane("Please write the post content",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else
				{
					JOptionPane optionPane = new JOptionPane("Your post has been successfully submited ",JOptionPane.INFORMATION_MESSAGE);
					JDialog dialog = optionPane.createDialog("Done!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
					
					profileForm window = new profileForm();
					window.getProfileFrame().setVisible(true);
					
					getLoserPostFrame().hide();	
				}
				
			}
		});
		lpfPostBtn.setBounds(367, 229, 97, 32);
		getLoserPostFrame().getContentPane().add(lpfPostBtn);
		
		JButton lpfBackBtn = new JButton("<< Back");
		lpfBackBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		lpfBackBtn.setToolTipText("back to the previous window");
		lpfBackBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				profileForm window = new profileForm();
				window.getProfileFrame().setVisible(true);
				
				getLoserPostFrame().hide();	
			}
		});
		lpfBackBtn.setBounds(12, 11, 97, 25);
		getLoserPostFrame().getContentPane().add(lpfBackBtn);
	}

	public JFrame getLoserPostFrame() {
		return loserPostFrame;
	}

	public void setLoserPostFrame(JFrame loserPostFrame) {
		this.loserPostFrame = loserPostFrame;
		loserPostFrame.setResizable(false);
	}
}
