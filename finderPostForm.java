package TheFinder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class finderPostForm {
	

	private JFrame finderPostFrame;
	int returnValue;
	private final JFileChooser openFileChooser = new JFileChooser();
	BufferedImage originalBI;
	private JTextField fpfTextField1;
	private JTextField fpfTextField2;
	private JTextField fpfTextField3;
	private JTextField fpfTextField4;
	
    public boolean savePost(String userID, String userKind, String category, BufferedImage image, String content, String VQ1, String VQ2, String VQ3, String VQ4) {
    	
    	boolean flag = false;
        String sql = "INSERT INTO Post(userID,UserKind,Category,Image,Content,VQ1,VQ2,VQ3,VQ4) VALUES(?,?,?,?,?,?,?,?,?)";
 
        try (Connection conn = welcomeForm.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            pstmt.setString(2, userKind);
            pstmt.setString(3, category);
            pstmt.setBlob(4, (Blob) image);
            pstmt.setString(5, content);
            pstmt.setString(6, VQ1);
            pstmt.setString(7, VQ2);
            pstmt.setString(8, VQ3);
            pstmt.setString(9, VQ4);
            pstmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
			flag = false;
        }
        return flag;
    }

	/**
	 * Create the application.
	 */
	public finderPostForm() {
		initialize();
		
		openFileChooser.setCurrentDirectory(new File("C:\\Users\\ammsb\\Desktop"));
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFinderPostFrame(new JFrame());
		getFinderPostFrame().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ammsb\\Desktop\\lenteingrandimento7-512.png"));
		getFinderPostFrame().setTitle("The Finder - Post");
		getFinderPostFrame().setBounds(100, 100, 864, 577);
		getFinderPostFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFinderPostFrame().getContentPane().setLayout(null);
				
		JLabel fpfCreateAPostLbl = new JLabel("Create a post");
		fpfCreateAPostLbl.setFont(new Font("Consolas", Font.BOLD, 18));
		fpfCreateAPostLbl.setBounds(340, 15, 130, 28);
		finderPostFrame.getContentPane().add(fpfCreateAPostLbl);
		
		JComboBox<String> fpfCategoryComboBox = new JComboBox<String>();
		fpfCategoryComboBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		fpfCategoryComboBox.setMaximumRowCount(9);
		fpfCategoryComboBox.setToolTipText("Select a category");
		fpfCategoryComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Mobile Phones", "Labtops", "Watchs", "Wallets", "Money", "Personal IDs", "Bags", "Keys", "others"}));
		fpfCategoryComboBox.setBounds(154, 67, 138, 32);
		finderPostFrame.getContentPane().add(fpfCategoryComboBox);
		
		JLabel fpfCategoryLbl = new JLabel("Category: ");
		fpfCategoryLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fpfCategoryLbl.setBounds(76, 66, 66, 32);
		finderPostFrame.getContentPane().add(fpfCategoryLbl);
		
		JLabel fpfPostContentLbl = new JLabel("Post Content: ");
		fpfPostContentLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fpfPostContentLbl.setBounds(76, 120, 97, 28);
		finderPostFrame.getContentPane().add(fpfPostContentLbl);
		
		JTextArea fpfTextArea = new JTextArea();
		fpfTextArea.setToolTipText("Write your post here");
		fpfTextArea.setBounds(76, 160, 700, 100);
		finderPostFrame.getContentPane().add(fpfTextArea);
		
		JLabel fpfVrificationQuestionsLbl = new JLabel("Verification Questions: ");
		fpfVrificationQuestionsLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fpfVrificationQuestionsLbl.setBounds(76, 288, 138, 28);
		finderPostFrame.getContentPane().add(fpfVrificationQuestionsLbl);
		
		JLabel fpf1Lbl = new JLabel("1. ");
		fpf1Lbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		fpf1Lbl.setBounds(76, 328, 15, 28);
		finderPostFrame.getContentPane().add(fpf1Lbl);
		
		fpfTextField1 = new JTextField();
		fpfTextField1.setToolTipText("Write a question");
		fpfTextField1.setBounds(102, 328, 674, 28);
		finderPostFrame.getContentPane().add(fpfTextField1);
		fpfTextField1.setColumns(10);
		
		JLabel fpf2Lbl = new JLabel("2. ");
		fpf2Lbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		fpf2Lbl.setBounds(76, 361, 15, 28);
		finderPostFrame.getContentPane().add(fpf2Lbl);
		
		fpfTextField2 = new JTextField();
		fpfTextField2.setToolTipText("Write a question");
		fpfTextField2.setBounds(102, 361, 674, 28);
		finderPostFrame.getContentPane().add(fpfTextField2);
		fpfTextField2.setColumns(10);
		
		JLabel fpf3Lbl = new JLabel("3. ");
		fpf3Lbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		fpf3Lbl.setBounds(76, 396, 15, 28);
		finderPostFrame.getContentPane().add(fpf3Lbl);
		
		fpfTextField3 = new JTextField();
		fpfTextField3.setToolTipText("Write a question");
		fpfTextField3.setBounds(102, 396, 674, 28);
		finderPostFrame.getContentPane().add(fpfTextField3);
		fpfTextField3.setColumns(10);
		
		JLabel fpf4Lbl = new JLabel("4. ");
		fpf4Lbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		fpf4Lbl.setBounds(76, 431, 15, 28);
		finderPostFrame.getContentPane().add(fpf4Lbl);
		
		fpfTextField4 = new JTextField();
		fpfTextField4.setToolTipText("Write a question");
		fpfTextField4.setBounds(102, 431, 674, 28);
		finderPostFrame.getContentPane().add(fpfTextField4);
		fpfTextField4.setColumns(10);

		JLabel fpfNewLabel = new JLabel("");
		fpfNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		fpfNewLabel.setBounds(494, 67, 173, 32);
		finderPostFrame.getContentPane().add(fpfNewLabel);
		
		JButton fpfBrowseBtn = new JButton("Browse");
		fpfBrowseBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		fpfBrowseBtn.setToolTipText("Upload an image");
		fpfBrowseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 returnValue = openFileChooser.showOpenDialog(finderPostFrame);
					
				if(returnValue == JFileChooser.APPROVE_OPTION)
				{
					try {
						originalBI = ImageIO.read(openFileChooser.getSelectedFile());   ///this image is stored in BufferedImage 'originalBI'
						fpfNewLabel.setText("Image file successfully loaded");
						
					}catch(IOException ioe) {
						fpfNewLabel.setText("Failed to load image file");
					}
				}
				else
				{
					fpfNewLabel.setText("NO file choosen");
					JOptionPane optionPane = new JOptionPane("Please select an image to upload",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}				
			}
		});
		fpfBrowseBtn.setBounds(679, 67, 97, 32);
		finderPostFrame.getContentPane().add(fpfBrowseBtn);
				
		JButton fpfPostBtn = new JButton("Post");
		fpfPostBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		fpfPostBtn.setToolTipText("Submit your post");
		fpfPostBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(fpfNewLabel.getText().compareTo("Failed to load image file") == 0 || fpfNewLabel.getText().compareTo("NO file choosen") == 0 || fpfNewLabel.getText().length() == 0)
				{
					JOptionPane optionPane = new JOptionPane("Please select an image to upload",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else if(fpfTextArea.getText().length() == 0)
				{
					JOptionPane optionPane = new JOptionPane("Please write the post content",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else if(fpfTextField1.getText().length() == 0 && fpfTextField2.getText().length() == 0 && fpfTextField3.getText().length() == 0 && fpfTextField4.getText().length() == 0)
				{
					JOptionPane optionPane = new JOptionPane("Please write at least one question",JOptionPane.ERROR_MESSAGE);
					JDialog dialog = optionPane.createDialog("Error!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
				}
				else
				{
					if(savePost(profileForm.currentUserID, kindForm.UserKind, fpfCategoryComboBox.getSelectedItem().toString(), originalBI, fpfTextArea.getText(), fpfTextField1.getText(), fpfTextField2.getText(), fpfTextField3.getText(), fpfTextField4.getText()))
					{
						JOptionPane optionPane = new JOptionPane("Your post has been successfully submited ",JOptionPane.INFORMATION_MESSAGE);
						JDialog dialog = optionPane.createDialog("Done!");
						dialog.setAlwaysOnTop(true); // to show top of all other application
						dialog.setVisible(true); // to visible the dialog
						
						profileForm window = new profileForm();
						window.getProfileFrame().setVisible(true);
						
						finderPostFrame.hide();
					}
					else
					{
						JOptionPane optionPane = new JOptionPane("Faild to submit post ",JOptionPane.ERROR_MESSAGE);
						JDialog dialog = optionPane.createDialog("Error!");
						dialog.setAlwaysOnTop(true); // to show top of all other application
						dialog.setVisible(true); // to visible the dialog
					}
				}
				
			}
		});
		fpfPostBtn.setBounds(360, 485, 97, 32);
		finderPostFrame.getContentPane().add(fpfPostBtn);
		
		JButton fpfBackBtn = new JButton("<< Back");
		fpfBackBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		fpfBackBtn.setToolTipText("back to the previous window");
		fpfBackBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				profileForm window = new profileForm();
				window.getProfileFrame().setVisible(true);
				
				finderPostFrame.hide();
				
			}
		});
		fpfBackBtn.setBounds(12, 13, 97, 25);
		finderPostFrame.getContentPane().add(fpfBackBtn);	
	}

	public JFrame getFinderPostFrame() {
		return finderPostFrame;
	}

	public void setFinderPostFrame(JFrame finderPostFrame) {
		this.finderPostFrame = finderPostFrame;
		finderPostFrame.setResizable(false);
	}
}
