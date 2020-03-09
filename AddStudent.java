import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField id;
	private JTextField session;
	private JTextField code;
	private JTextField title;
	private JTextField ct;
	Connection conn=Database.dbConnector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setTitle("Add Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 721, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setForeground(new Color(148, 0, 211));
		lblStudentName.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblStudentName.setBounds(95, 43, 114, 27);
		panel.add(lblStudentName);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setForeground(new Color(148, 0, 211));
		lblStudentId.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblStudentId.setBounds(95, 97, 114, 27);
		panel.add(lblStudentId);
		
		JLabel lblSession = new JLabel("Session");
		lblSession.setForeground(new Color(148, 0, 211));
		lblSession.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblSession.setBounds(95, 150, 114, 27);
		panel.add(lblSession);
		
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setForeground(new Color(148, 0, 211));
		lblCourseCode.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblCourseCode.setBounds(95, 213, 114, 27);
		panel.add(lblCourseCode);
		
		JLabel lblCourseTitle = new JLabel("Course Title");
		lblCourseTitle.setForeground(new Color(148, 0, 211));
		lblCourseTitle.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblCourseTitle.setBounds(95, 278, 114, 27);
		panel.add(lblCourseTitle);
		
		JLabel lblCtNo = new JLabel("CT No.");
		lblCtNo.setForeground(new Color(148, 0, 211));
		lblCtNo.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblCtNo.setBounds(420, 156, 114, 27);
		panel.add(lblCtNo);
		
		name = new JTextField();
		name.setBounds(219, 44, 268, 24);
		panel.add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(219, 100, 210, 24);
		panel.add(id);
		
		session = new JTextField();
		session.setColumns(10);
		session.setBounds(219, 153, 168, 24);
		panel.add(session);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(219, 216, 168, 24);
		panel.add(code);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(219, 281, 268, 24);
		panel.add(title);
		
		ct = new JTextField();
		ct.setColumns(10);
		ct.setBounds(493, 159, 108, 24);
		panel.add(ct);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query="insert into Student (ID,Name,Session,Course_code,Course_title,CT_no) values (?,?,?,?,?,?)";
				try {
					//int jj=1;
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,id.getText() );
					pst.setString(2,name.getText() );
					pst.setString(3,session.getText() );
					pst.setString(4,code.getText() );
					pst.setString(5,title.getText() );
					pst.setString(6,ct.getText() );
					//jj++;
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Student has been added Successfully!!");
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnAddStudent.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnAddStudent.setBounds(322, 325, 119, 23);
		panel.add(btnAddStudent);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Admin ad=new Admin();
				ad.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnBack.setBounds(562, 325, 119, 23);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\Download\\Webp.net-resizeimage (3).jpg"));
		lblNewLabel.setBounds(0, 0, 721, 359);
		panel.add(lblNewLabel);
	}
}
