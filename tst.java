import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class tst extends JFrame {

	private JPanel contentPane;
	static String id;
	static String name;
	Connection conect=Database.dbConnector();
	//JOptionPane.showMessageDialog(null, id);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tst frame = new tst();
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
	public tst() {
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		conect=Database.dbConnector();
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 787, 410);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("About Us");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About_Us ques=new About_Us();
				ques.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(173, 255, 47));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(0, 0, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Wellcome  To Online Class Test");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setBounds(211, 69, 420, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course Code");
		lblNewLabel_1.setFont(new Font("Papyrus", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(127, 255, 0));
		lblNewLabel_1.setBounds(149, 161, 109, 31);
		panel.add(lblNewLabel_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		comboBox.setForeground(new Color(148, 0, 211));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSTE 2201", "CSTE 2203", "CSTE 2205", "CSTE 2207", "MATH 2107"}));
		comboBox.setBounds(279, 165, 143, 27);
		panel.add(comboBox);
		
		JLabel lblCourseTitle = new JLabel("Course Title");
		lblCourseTitle.setForeground(new Color(127, 255, 0));
		lblCourseTitle.setFont(new Font("Papyrus", Font.BOLD, 14));
		lblCourseTitle.setBounds(149, 222, 109, 31);
		panel.add(lblCourseTitle);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Data Structure and Algorithms", "Digital Electronics and Pulse Technique", "Computer Architecture and Organization", "Object Oriented Programming in GUI Environment", "Complex variables, Statistics and Probability"}));
		comboBox_1.setForeground(new Color(148, 0, 211));
		comboBox_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		comboBox_1.setBounds(279, 226, 352, 27);
		panel.add(comboBox_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(127, 255, 0));
		lblDate.setFont(new Font("Papyrus", Font.BOLD, 14));
		lblDate.setBounds(485, 161, 63, 31);
		panel.add(lblDate);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1 ", "2 ", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_2.setBounds(547, 165, 40, 27);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "Octobar", "November", "December"}));
		comboBox_3.setBounds(606, 163, 77, 29);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		comboBox_4.setBounds(703, 163, 57, 27);
		panel.add(comboBox_4);
		
		JButton btnNewButton_1 = new JButton("START");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
//				String query="insert into Student (Course Code,Course Title) values (?,?)";
//				PreparedStatement pst=conect.prepareStatement(query);
//				pst.setString(1,comboBox.getToolTipText() );
//				pst.setString(1,comboBox_1.getToolTipText() );
//				
//				pst.execute();
					String a,b;
					a=comboBox.getSelectedItem().toString();
					b=comboBox_1.getSelectedItem().toString();
					String sq = "update Result set Course_code='"+a+"', Course_title='"+b+"' where ID='"+id+"'";
					 
					PreparedStatement statement = conect.prepareStatement(sq);
//					String value= comboBox.getSelectedItem().toString();
//					statement .setString(1,value );
//					value=comboBox_1.getSelectedItem().toString();
//					statement.setString(2,value);
//					statement.setString(3, "ASH1601001M");
					
					 
					statement.executeUpdate();
					OnlineTest.id1=id;
//					String sql="Update Result set Course code=? where ID='ASH1601001M'";
//					PreparedStatement ps=conect.prepareStatement(sql);
					
					//ps.setString(2,comboBox_1.getToolTipText() );
					//ps.executeUpdate();
				dispose();
				OnlineTest ques=new OnlineTest("Question Paper");
				ques.setVisible(true);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton_1.setBackground(new Color(250, 250, 210));
		btnNewButton_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 20));
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setBounds(377, 343, 89, 31);
		panel.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\Download\\rsz_23472148_1683625651656371_5710644314808792405_n (1).jpg"));
		label.setBounds(0, 0, 787, 410);
		panel.add(label);
	}
}
