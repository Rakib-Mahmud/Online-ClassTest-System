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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class AddQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField Quesfield;
	private JTextField option1;
	private JTextField option2;
	private JTextField option3;
	private JTextField option4;
	private JTextField answer;
	final Connection conect=Database.dbConnector();
	int i=0,k=0;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestion frame = new AddQuestion();
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
	
	public void last_element(){
		String query="insert into Ques_paper (ques,option1,option2,option3,option4,ans,Serial) values (?,?,?,?,?,?,?)";
		try {
			//int jj=1;
			i++;
			PreparedStatement pst=conect.prepareStatement(query);
			pst.setString(1,"Hello" );
			pst.setString(7,Integer.toString(i) );
			pst.executeUpdate();
	}catch(Exception e){
		
	}
	}
	
	public void delet_last(){
		String query="delete from Ques_paper where ques='Hello'";
		try {
			//int jj=1;
			PreparedStatement pst=conect.prepareStatement(query);
			pst.executeUpdate();
	}catch(Exception e){
		
	}
	}
	public AddQuestion() {
		setTitle("Add Question");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 721, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Quesfield = new JTextField();
		Quesfield.setBounds(166, 40, 437, 59);
		panel.add(Quesfield);
		Quesfield.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Question :");
		lblNewLabel_1.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblNewLabel_1.setBounds(60, 43, 128, 35);
		panel.add(lblNewLabel_1);
		
		JLabel txt2 = new JLabel("Option2");
		txt2.setFont(new Font("MV Boli", Font.BOLD, 13));
		txt2.setBounds(409, 153, 128, 35);
		panel.add(txt2);
		
		JLabel lblOption_2 = new JLabel("Option3");
		lblOption_2.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblOption_2.setBounds(60, 216, 128, 35);
		panel.add(lblOption_2);
		
		JLabel lblOption_3 = new JLabel("Option4");
		lblOption_3.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblOption_3.setBounds(409, 214, 128, 35);
		panel.add(lblOption_3);
		
		JLabel lblOption = new JLabel("Option1");
		lblOption.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblOption.setBounds(60, 155, 128, 35);
		panel.add(lblOption);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblAnswer.setBounds(60, 276, 128, 35);
		panel.add(lblAnswer);
		
		option1 = new JTextField();
		option1.setBounds(118, 160, 207, 28);
		panel.add(option1);
		option1.setColumns(10);
		
		option2 = new JTextField();
		option2.setColumns(10);
		option2.setBounds(467, 160, 207, 28);
		panel.add(option2);
		
		option3 = new JTextField();
		option3.setColumns(10);
		option3.setBounds(118, 223, 207, 28);
		panel.add(option3);
		
		option4 = new JTextField();
		option4.setColumns(10);
		option4.setBounds(467, 223, 207, 28);
		panel.add(option4);
		
		answer = new JTextField();
		answer.setColumns(10);
		answer.setBounds(118, 283, 207, 28);
		panel.add(answer);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query="insert into Ques_paper (ques,option1,option2,option3,option4,ans,Serial) values (?,?,?,?,?,?,?)";
				try {
					//int jj=1;
					i++;
					if(k==0){
						k=1;
						delet_last();
					}
					PreparedStatement pst=conect.prepareStatement(query);
					pst.setString(1,Quesfield.getText() );
					pst.setString(2,option1.getText() );
					pst.setString(3,option2.getText() );
					pst.setString(4,option3.getText() );
					pst.setString(5,option4.getText() );
					pst.setString(6,answer.getText() );
					pst.setString(7, textField.getText());
					//jj++;
					pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(622, 325, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String query="insert into Ques_paper (ques,option1,option2,option3,option4,ans,Serial) values (?,?,?,?,?,?,?)";
//				try {
//					//int jj=1;
//					i++;
//					PreparedStatement pst=conect.prepareStatement(query);
//					pst.setString(1,Quesfield.getText() );
//					pst.setString(2,option1.getText() );
//					pst.setString(3,option2.getText() );
//					pst.setString(4,option3.getText() );
//					pst.setString(5,option4.getText() );
//					pst.setString(6,answer.getText() );
//					pst.setString(7,textField.getText() );
//					//OnlineTest.ll=jj-1;
//					pst.executeUpdate();
//					last_element();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				last_element();
				JOptionPane.showMessageDialog(null, "Questions have been set successfully!!! ");
				dispose();
				Admin ad=new Admin();
				ad.setVisible(true);
			}
		});
		btnFinish.setBounds(467, 325, 89, 23);
		panel.add(btnFinish);
		
		JLabel lblSerial = new JLabel("Serial");
		lblSerial.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblSerial.setBounds(409, 276, 128, 35);
		panel.add(lblSerial);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(467, 283, 207, 28);
		panel.add(textField);
		
		JButton btnDeleteEarlierQuestion = new JButton("Delete Earlier Question");
		btnDeleteEarlierQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String del="delete from Ques_paper";
				try{
					PreparedStatement ps=conect.prepareStatement(del);
					ps.executeUpdate();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnDeleteEarlierQuestion.setBounds(30, 325, 171, 23);
		panel.add(btnDeleteEarlierQuestion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\Download\\Webp.net-resizeimage (3).jpg"));
		lblNewLabel.setBounds(0, 0, 721, 359);
		panel.add(lblNewLabel);
	}
}
