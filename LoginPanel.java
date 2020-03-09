import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class LoginPanel {

	JFrame frmPleaseLoginFirst;
	private JTextField textField;
	private JPasswordField passwordField;
	Connection conect=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel window = new LoginPanel();
					window.frmPleaseLoginFirst.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPanel() {
		initialize();
		conect=Database.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPleaseLoginFirst = new JFrame();
		frmPleaseLoginFirst.setBackground(new Color(204, 51, 153));
		frmPleaseLoginFirst.setForeground(new Color(102, 51, 51));
		frmPleaseLoginFirst.setTitle("Please Login First");
		frmPleaseLoginFirst.setBounds(100, 100, 800, 450);
		frmPleaseLoginFirst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPleaseLoginFirst.getContentPane().setLayout(null);
		frmPleaseLoginFirst.setFocusable(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 411);
		frmPleaseLoginFirst.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Panel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(153, 255, 0));
		lblNewLabel.setFont(new Font("Edwardian Script ITC", Font.BOLD, 40));
		lblNewLabel.setBounds(300, 37, 200, 50);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("F:\\Download\\rsz_1user-coat-blue-icon.png"));
		label_1.setBounds(205, 160, 32, 50);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 204));
		textField.setForeground(Color.GRAY);
		//textField.setCaret(new HighlightCaret());
		//textField.getCaret().setVisible(false);
		//textField.setFocusable(false);
		textField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText("");
				//textField.getCaret().setVisible(true);
				textField.setForeground(Color.BLACK);
			}
		});
		textField.setText("Username");
		//textField.setToolTipText("");
		textField.setFont(new Font("Vivaldi", Font.PLAIN, 17));
		textField.setBounds(291, 172, 284, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("F:\\Download\\rsz_1password--password-icon-95838.png"));
		label_2.setBounds(191, 212, 84, 50);
		panel.add(label_2);
		
		JButton btnLogin = new JButton("Login");
		Image im = new ImageIcon(this.getClass().getResource("/Ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(im));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="select * from Student where Name=? and ID=? ";
					PreparedStatement pst=conect.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					boolean flag=false;
					
					while(rs.next()){
						flag=true;
					}
					int k=0;
					if(flag==true){
						//JOptionPane.showMessageDialog(null,"Data Found!!");
						String query1="insert into Result (ID,name) values (?,?)";
						try {
							//int jj=1;
							PreparedStatement pst1=conect.prepareStatement(query1);
							pst1.setString(1,passwordField.getText() );
							pst1.setString(2,textField.getText() );
							tst.id=passwordField.getText();
							tst.name=textField.getText();
							//jj++;
							pst1.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							JOptionPane.showMessageDialog(null,"You have already submitted!");
							frmPleaseLoginFirst.dispose();
							HomePage hm=new HomePage();
							hm.setVisible(true); k=1;
						}
					if(k==0){
						frmPleaseLoginFirst.dispose();
						tst ques=new tst();
						ques.setVisible(true);
					}
					}
					else{
						JOptionPane.showMessageDialog(null,"Username or Password doesn't match!");
					}
					
					}catch(Exception e){
						JOptionPane.showMessageDialog(null,e);
					}
				}
		});
		btnLogin.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnLogin.setBounds(382, 304, 118, 39);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setText("Password");
		//passwordField.setCaret(new HighlightCaret());
		//passwordField.setFocusable(false);
		passwordField.setBackground(new Color(224, 255, 255));
		passwordField.setForeground(Color.GRAY);
		passwordField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				passwordField.setText("");
				//passwordField.getCaret().setVisible(true);
				passwordField.setForeground(Color.BLACK);
			}
		});
		passwordField.setToolTipText("");
		passwordField.setBounds(291, 224, 284, 28);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("Username");
				textField.setForeground(Color.GRAY);
				passwordField.setText("password");
				passwordField.setForeground(Color.GRAY);
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnNewButton.setBounds(203, 304, 118, 39);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPleaseLoginFirst.dispose();
				HomePage hp=new HomePage();
				hp.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnBack.setBounds(573, 304, 118, 39);
		panel.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\Download\\rsz_cool_hd_wallpaper_cool_wallpaper_hd.jpg"));
		label.setBounds(0, 0, 784, 411);
		panel.add(label);
	}
}
