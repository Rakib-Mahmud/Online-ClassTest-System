import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 662, 402);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AdminPanel window = new AdminPanel();
				window.frmPleaseLoginFirst.setVisible(true);
			}
		});
		btnAdminLogin.setForeground(new Color(0, 0, 128));
		btnAdminLogin.setBackground(new Color(240, 230, 140));
		btnAdminLogin.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnAdminLogin.setBounds(244, 122, 200, 50);
		panel.add(btnAdminLogin);
		
		JButton btnStudentLogin = new JButton("Student Login");
		btnStudentLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LoginPanel window = new LoginPanel();
				window.frmPleaseLoginFirst.setVisible(true);
			}
		});
		btnStudentLogin.setForeground(new Color(0, 0, 128));
		btnStudentLogin.setBackground(new Color(240, 230, 140));
		btnStudentLogin.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnStudentLogin.setBounds(244, 232, 200, 50);
		panel.add(btnStudentLogin);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Pristina", Font.PLAIN, 29));
		lblNewLabel.setForeground(new Color(218, 112, 214));
		lblNewLabel.setBounds(265, 37, 159, 50);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("About Us");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About_Us ques=new About_Us();
				ques.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 0));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		btnNewButton.setBounds(568, 0, 94, 25);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\Download\\Webp.net-resizeimage.jpg"));
		label.setBounds(0, 0, 662, 402);
		panel.add(label);
	}
}
