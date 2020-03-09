import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Admin extends JFrame {
	Connection conect=Database.dbConnector();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 654, 342);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Question");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					AddQuestion add=new AddQuestion();
					dispose();
					add.setVisible(true);
				}catch(Exception e){
					
				}
			}
		});
		btnNewButton.setBackground(new Color(238, 232, 170));
		btnNewButton.setForeground(new Color(75, 0, 130));
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnNewButton.setBounds(44, 141, 163, 65);
		panel.add(btnNewButton);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddStudent add=new AddStudent();
				add.setVisible(true);
			}
		});
		btnAddStudent.setForeground(new Color(75, 0, 130));
		btnAddStudent.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnAddStudent.setBackground(new Color(238, 232, 170));
		btnAddStudent.setBounds(458, 141, 163, 65);
		panel.add(btnAddStudent);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HomePage hp=new HomePage();
				hp.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		btnNewButton_1.setBackground(new Color(64, 224, 208));
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setBounds(297, 258, 96, 38);
		panel.add(btnNewButton_1);
		
		JButton btnResult = new JButton("Result");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String st="CREATE TABLE Result (ID TEXT  NOT NULL ,name TEXT,Mark INTEGER,Course_code TEXT DEFAULT (null) ," +
				//		"Course_title TEXT DEFAULT (null) ,Date TEXT,FOREIGN KEY (ID) REFERENCES Student(ID))";
//				try {
//					PreparedStatement statement;
//					statement = conect.prepareStatement(st);
//					statement.executeUpdate();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				dispose();
				Result es=new Result();
				es.setVisible(true);
			}
		});
		btnResult.setForeground(new Color(75, 0, 130));
		btnResult.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnResult.setBackground(new Color(238, 232, 170));
		btnResult.setBounds(252, 99, 163, 65);
		panel.add(btnResult);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\Download\\Webp.net-resizeimage (2).jpg"));
		label.setBounds(0, 0, 654, 342);
		panel.add(label);
	}
}
