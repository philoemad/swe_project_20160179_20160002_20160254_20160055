package TheFinder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class searchForm {

	private JFrame searchFrame;

	/**
	 * Create the application.
	 */
	public searchForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSearchFrame(new JFrame());
		getSearchFrame().setTitle("The Finder - Search");
		getSearchFrame().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ammsb\\Desktop\\lenteingrandimento7-512.png"));
		getSearchFrame().setBounds(100, 100, 340, 233);
		getSearchFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getSearchFrame().getContentPane().setLayout(null);
		
		JFrame.setDefaultLookAndFeelDecorated(false);
		
		JLabel sSearchLbl = new JLabel(" Search");
		sSearchLbl.setFont(new Font("Consolas", Font.PLAIN, 20));
		sSearchLbl.setBounds(125, 13, 92, 24);
		searchFrame.getContentPane().add(sSearchLbl);
		
		JLabel sCategoryLbl = new JLabel("Category: ");
		sCategoryLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sCategoryLbl.setBounds(42, 62, 66, 32);
		searchFrame.getContentPane().add(sCategoryLbl);
		
		JComboBox<String> sComboBox = new JComboBox<String>();
		sComboBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		sComboBox.setToolTipText("Select a category");
		sComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Mobile Phones", "Labtops", "Watchs", "Wallets", "Money", "Personal IDs", "Bags", "Keys", "others"}));
		sComboBox.setMaximumRowCount(9);
		sComboBox.setBounds(118, 63, 138, 32);
		searchFrame.getContentPane().add(sComboBox);
		
		JLabel sKindLbl = new JLabel("Kind: ");
		sKindLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sKindLbl.setBounds(42, 95, 66, 32);
		searchFrame.getContentPane().add(sKindLbl);
		
		JRadioButton sFinderRdBtn = new JRadioButton("Finder");
		sFinderRdBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		sFinderRdBtn.setToolTipText("People who found something");
		sFinderRdBtn.setBounds(118, 96, 66, 32);
		searchFrame.getContentPane().add(sFinderRdBtn);
		
		JRadioButton sLoserRdBtn = new JRadioButton("Loser");
		sLoserRdBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		sLoserRdBtn.setToolTipText("People who lost somthing");
		sLoserRdBtn.setBounds(197, 96, 59, 32);
		searchFrame.getContentPane().add(sLoserRdBtn);
		
		ButtonGroup bg1 = new ButtonGroup( );
		bg1.add(sFinderRdBtn);
		bg1.add(sLoserRdBtn);
		
		JButton sBackBtn = new JButton("<< Back");
		sBackBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		sBackBtn.setToolTipText("back to the previous window");
		sBackBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				profileForm window = new profileForm();
				window.getProfileFrame().setVisible(true);
				
				searchFrame.hide();
				
			}
		});
		sBackBtn.setBounds(12, 13, 97, 25);
		searchFrame.getContentPane().add(sBackBtn);
		
		JButton sSearchBtn = new JButton("Search");
		sSearchBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		sSearchBtn.setToolTipText("Do search");
		sSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(sFinderRdBtn.isSelected() == false && sLoserRdBtn.isSelected() == false)
				{
					JOptionPane optionPane = new JOptionPane("Please select a user kind",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog

				}
			}
		});
		sSearchBtn.setBounds(122, 145, 97, 32);
		searchFrame.getContentPane().add(sSearchBtn);
	}

	public JFrame getSearchFrame() {
		return searchFrame;
	}

	public void setSearchFrame(JFrame searchFrame) {
		this.searchFrame = searchFrame;
		searchFrame.setResizable(false);
	}
}
