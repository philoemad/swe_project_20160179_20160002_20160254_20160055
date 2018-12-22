package TheFinder;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class kindForm {

	private JFrame kindFrame;
	public static String UserKind;

	/**
	 * Create the application.
	 */
	public kindForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setKindFrame(new JFrame());
		getKindFrame().getContentPane().setBackground(UIManager.getColor("ArrowButton.background"));
		getKindFrame().setTitle("The Finder - Post - User Kind");
		getKindFrame().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ammsb\\Desktop\\lenteingrandimento7-512.png"));
		getKindFrame().setBounds(100, 100, 470, 176);
		getKindFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getKindFrame().getContentPane().setLayout(null);
		
		JLabel kfChooseYourKindLbl = new JLabel("Choose Your Kind");
		kfChooseYourKindLbl.setFont(new Font("Consolas", Font.PLAIN, 17));
		kfChooseYourKindLbl.setBounds(160, 13, 144, 28);
		getKindFrame().getContentPane().add(kfChooseYourKindLbl);
		
		JRadioButton kfFinderRdBtn = new JRadioButton("Finder");
		kfFinderRdBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		kfFinderRdBtn.setToolTipText("You found something?");
		kfFinderRdBtn.setBackground(SystemColor.control);
		kfFinderRdBtn.setBounds(160, 53, 65, 28);
		getKindFrame().getContentPane().add(kfFinderRdBtn);
		
		JRadioButton kfLoserRdBtn = new JRadioButton("Loser");
		kfLoserRdBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		kfLoserRdBtn.setToolTipText("You lost something?");
		kfLoserRdBtn.setBackground(SystemColor.control);
		kfLoserRdBtn.setBounds(245, 55, 59, 25);
		getKindFrame().getContentPane().add(kfLoserRdBtn);

		ButtonGroup bg1 = new ButtonGroup( );
		bg1.add(kfFinderRdBtn);
		bg1.add(kfLoserRdBtn);
		
		JButton kfOkBtn = new JButton("OK");
		kfOkBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		kfOkBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(kfFinderRdBtn.isSelected())
				{
					UserKind = kfFinderRdBtn.getText();
					finderPostForm window = new finderPostForm();
					window.getFinderPostFrame().setVisible(true);
					
					kindFrame.hide();
				}
				else if(kfLoserRdBtn.isSelected())
				{
					UserKind = kfLoserRdBtn.getText();
					loserPostForm window = new loserPostForm();
					window.getLoserPostFrame().setVisible(true);
					
					kindFrame.hide();
				}
				else
				{
					JOptionPane optionPane = new JOptionPane("Please select what you are",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				
			}
		});
		kfOkBtn.setToolTipText("Submit your choice");
		kfOkBtn.setBounds(184, 93, 97, 32);
		getKindFrame().getContentPane().add(kfOkBtn);
		
		JButton kfBackBtn = new JButton("<< Back");
		kfBackBtn.setToolTipText("back to the previous window");
		kfBackBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				profileForm window = new profileForm();
				window.getProfileFrame().setVisible(true);
				
				kindFrame.hide();
				
			}
		});
		kfBackBtn.setBounds(12, 11, 97, 25);
		kindFrame.getContentPane().add(kfBackBtn);
	}

	public JFrame getKindFrame() {
		return kindFrame;
	}

	public void setKindFrame(JFrame kindFrame) {
		this.kindFrame = kindFrame;
		kindFrame.setResizable(false);
	}
}